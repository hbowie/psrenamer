/*
 * Copyright 2003 - 2013 Herb Bowie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.powersurgepub.psrenamer;

  import java.io.*;
  import java.util.*;

  /** 
   A collection of files contained within a given directory.
   
   */
  public class PSFiles {
  
  SortedSet files = new TreeSet();
  File dir;
  String dirName = "";
  Iterator each;
  
  ArrayList selectors = new ArrayList();
  
  /** 
   Creates a new instance of PSFiles. The collection of files
   will be empty until the directory name is set.
   */
  public PSFiles() {
    // do-nothing constructor
  }
  
  /** 
   Set the directory to contain the collection of files in the
   given directory.
   
   @param   dirName The name of the directory containing the files
            to be manipulated.
   
   @return  the number of files found in this directory, or -1
            if the directory name could not be found. 
   */  
  public int setDirectory (String dirName) {
    this.dirName = dirName;
    if (files.size() > 0) {
      files = new TreeSet();
    }
    if (selectors.size() > 0) {
      selectors = new ArrayList();
    }
    try {
      dir = new File(dirName);
    } catch (Exception e) {
      return -1;
    }
    if (dir.isDirectory()) {
      String[] dirEntries;
      try {
        dirEntries = dir.list();
      } catch (Exception e) {
        return -1;
      }
      if (dirEntries == null) {
        return -1;
      } else {
        for (int i = 0; i < dirEntries.length; i++) {
          PSFile newFile = new PSFile (dir, dirEntries[i]);
          if ((newFile.isFile()) && (! newFile.isHidden())) {
            files.add (newFile);
          } // end if directory entry is a file
        } // end for each entry in directory
        return files.size();
      } // end if directory entries returned
    } else { // not a directory
      return -1;
    }
  }
  
  public void addSelector (Selector sel) {
    selectors.add (sel);
  }
  
  public int sizeSelectors() {
    return selectors.size();
  }
  
  public int makeSelection () {
    int selectedCount = 0;
    String firstNewName = "";
    String lastNewName = "";
    start();
    while (each.hasNext()) {
      PSFile nextFile = next();
      nextFile.initialize();
      nextFile.setSelected (true);
      for (int i = 0; i < selectors.size(); i++) {
        Selector nextSelector = (Selector)selectors.get (i);
        nextFile.select (nextSelector);
      }
      if (nextFile.isSelected()) {
        selectedCount++;
        String newFileName = nextFile.getNewName();
        if (selectedCount == 1) {
          firstNewName = nextFile.getNewName();
        } else {
          if (firstNewName.equals (nextFile.getNewName())) {
            nextFile.incrementNewName(lastNewName);
          }
        } // end if selected file later than first
        lastNewName = nextFile.getNewName();
      } // end if next file is selected
    } // end while more files to process
    return selectedCount;
  } // end method
  
  /**
   Finds a file by name, if it exists in the list and has been selected.
   */
  public PSFile find (String fileName) {
    Iterator finder = files.iterator();
    PSFile next = null;
    boolean found = false;
    while (finder.hasNext() && (! found)) {
      next = (PSFile)finder.next();
      if (fileName.equals (next.getName())) {
        found = true;
      }
    }
    if (found && next.isSelected()) {
      return next;
    } else {
      return null;
    }
  }
  
  /**
   Sets the process flag off, for all files.
   */
  public void preProcess () {
    Iterator all = files.iterator();
    PSFile next = null;
    while (all.hasNext()) {
      next = (PSFile)all.next();
      next.setProcessed (false);
    }
  }
  
  /** 
   Prepares the list of files for sequential retrieval via the
   next or nextSelected methods.
   */  
  public void start() {
    each = files.iterator();
  }
  
  /** 
   Gets the next file whose selected flag has been
   set to true.
   
   @return Next file that has been selected, or null if
   no more files to return.
   */  
  public PSFile nextSelected() {
    PSFile nextFile;
    do {
      nextFile = next();
    } while (nextFile != null
        && (! nextFile.isSelected()));
    return nextFile;
  } // end method
  
  /** 
   Gets the next file in the directory.
   
   @return The next file in the directory, or null
   if there are no more files to return.
   */  
  public PSFile next() {
    if (each.hasNext()) {
      return (PSFile)each.next();
    } else {
      return null;
    }
  } // end method
} // end class
