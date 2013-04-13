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
  import java.lang.reflect.*;

/** 
  An extension of the File class that supports desired
  partial name comparisons.
 */
public class PSFile extends java.io.File {
  
  final static String DIGITS = "0123456789";
  final static String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
  final static String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  boolean selected;
  boolean renamed;
  boolean processed = false;
  StringBuffer newName;
  
  /** 
    Creates a new instance of PSFile
   
    @param fileName The name of the file.
   */
  public PSFile (String fileName) {
    super (fileName);
    initialize();
  }
  
   /** 
    Creates a new instance of PSFile
   
    @param dir      The directory containing the file.
    @param fileName The name of the file.
   */
  public PSFile (File directory, String fileName) {
    super (directory, fileName);
    initialize();
  }
  
  public void initialize() {
    selected = false;
    renamed = false;
    processed = false;
    newName = new StringBuffer (getName());
  }
  
  public void process() {
    setProcessed (true);
  }
  
  public void setProcessed (boolean processed) {
    this.processed = processed;
  }
  
  public boolean alreadyProcessed () {
    return processed;
  }
  
  /** 
    Process one selector, using it to determine whether this file
    should be selected, and to create a new name for the file. The selected
    flag for this file should initially be set to true, before processing
    any selectors. If any selectors deselect the file, then the file
    will not be selected.
   
    @param selector The selector to be used to select this file and to
                    create its new name.
   */  
  public void select (Selector selector) {
    switch (selector.location) {
      case Selector.BEGINS_WITH:
        startsWith (selector);
        break;
      case Selector.CONTAINS:
        if (selector.action == Selector.REPLACE_CHARS) {
          containsChars (selector);
        } else {
          contains (selector);
        }
        break;
      case Selector.ENDS_WITH:
        endsWith (selector);
        break;
      case Selector.EQUALS:
        nameEquals (selector);
        break;
      case Selector.EXTENSION:
        extEquals (selector);
        break;
    } // end switch
  }
  
  /** 
    Determine whether the file name (without path information)
    contains the passed String, with or without case
    sensitivity.
   
    @param selector Information used for selection and name modification.

   */  
  public void contains (Selector selector) {
    String a;
    String b;
    if (selector.caseSensitive) {
      a = newName.toString();
      b = selector.findValue;
    } else {
      a = newName.toString().toLowerCase();
      b = selector.findValue.toLowerCase();
    }
    int i = a.indexOf(b);
    if (i >= 0) {
      modify (selector, i, i + b.length());
    } else {
      setSelected (false);
    }
  } // end method
  
  /** 
    Determine whether the file name (without path information)
    contains any of the characters in the passed String, 
    with or without case sensitivity.
   
    @param selector Information used for selection and name modification.

   */  
  public void containsChars (Selector selector) {
    String fileName;
    String findValue;
    String findChar;
    String replaceChar;
    int fileNameIndex;
    int fileNameSearchStart;
    int inc = 1;
    if (selector.caseSensitive) {
      fileName = newName.toString();
      findValue = selector.findValue;
    } else {
      fileName = newName.toString().toLowerCase();
      findValue = selector.findValue.toLowerCase();
    }
    boolean anyCharsFound = false;
    for (int findCharIndex = 0; 
        findCharIndex < findValue.length(); 
        findCharIndex++) {
      findChar 
          = findValue.substring (findCharIndex, findCharIndex + 1);
      if (findChar.equals ("b")) {
        findChar = " ";
      }
      replaceChar = "";
      if (findCharIndex < selector.newValue.length()) {
        replaceChar 
            = selector.newValue.substring (findCharIndex, findCharIndex + 1);
        if (replaceChar.equals ("^")) {
          replaceChar = "";
        } // end if character should be removed
      } // end if we found a replacement value
      inc = replaceChar.length();
      fileNameIndex = fileName.indexOf (findChar);
      while (fileNameIndex >= 0) {
        anyCharsFound = true;
        newName.replace (fileNameIndex, fileNameIndex + 1, replaceChar);
        if (selector.caseSensitive) {
          fileName = newName.toString();
        } else {
          fileName = newName.toString().toLowerCase();
        }
        fileNameSearchStart = fileNameIndex + inc;
        fileNameIndex = fileName.indexOf (findChar, fileNameSearchStart);
      } // end while more occurrences of search character found in file name
    } // end for every character in search string
    if (! anyCharsFound) {
      setSelected (false);
    }
  } // end method
  
  /** 
    Determine whether the file name (without path information
    and without file extension) ends with the passed String, 
    with or without case sensitivity.
   
    @param selector Information used for selection and name modification.
   */  
  public void endsWith (Selector selector) {
    String a;
    String b;
    int dot = lastDotPosition();
    if (selector.caseSensitive) {
      a = newName.substring(0,dot);
      b = selector.findValue;
    } else {
      a = newName.substring(0,dot).toLowerCase();
      b = selector.findValue.toLowerCase();
    }
    if (a.endsWith(b)) {
      modify (selector, a.length() - b.length(), a.length());
    } else {
      setSelected (false);
    }
  } // end method

   /** 
    Determine whether the file name has the passed String
    as a file extension, without case sensitivity.
   
    @param selector Information used for selection and name modification.
   */  
  public void extEquals (Selector selector) {
    String a;
    String b;
    int dot = newName.toString().lastIndexOf ('.');
    if (dot < 0) {
      a = "";
    } else {
      a = newName.substring(dot + 1).toLowerCase();
    }
    b = selector.findValue.toLowerCase();
    if (a.equals(b)) {
      modify (selector, dot + 1, newName.length());
    } else {
      setSelected (false);
    }
  } // end method 

  /** 
    Determine whether the file name (without path information
    and without file extension) equals the passed String, 
    with or without case sensitivity.
   
    @param selector Information used for selection and name modification.
   */  
  public void nameEquals (Selector selector) {
    String a;
    String b;
    int dot = lastDotPosition();
    if (selector.caseSensitive) {
      a = newName.substring(0,dot);
      b = selector.findValue;
    } else {
      a = newName.substring(0,dot).toLowerCase();
      b = selector.findValue.toLowerCase();
    }
    if (a.equals(b)) {
      modify (selector, 0, a.length());
    } else
    if (b.equals (Selector.FIND_ANY)) {
      modify (selector, 0, a.length());
    } else {
      setSelected (false);
    }
  } // end method
  
   /** 
    Determine whether the file name (without path information)
    starts with the passed String, with or without case
    sensitivity.
   
    @param selector Information used for selection and name modification.
   */  
  public void startsWith (Selector selector) {
    String a;
    String b;
    if (selector.caseSensitive) {
      a = newName.toString();
      b = selector.findValue;
    } else {
      a = newName.toString().toLowerCase();
      b = selector.findValue.toLowerCase();
    }
    if (a.startsWith (b)) {
      modify (selector, 0, b.length());
    } else {
      setSelected (false);
    }
  } // end method
  
  /** 
    Sets the selected flag to the passed value.
   
    @param selected Has this file been selected for further processing?
   */  
  public void setSelected (boolean selected) {
    this.selected = selected;
  }
  
  /** 
    Has this file been selected for further processing? 
   
    @return True if file selected, false if not.
   */  
  public boolean isSelected () {
    return selected;
  }
  
  /** 
    Modify the proposed new file name in accordance with
    the input.
   
    @param selector Selection and modification data
    @param start    Starting index position in the new file name for
                    this action.
    @param end      Ending index position in the new file name for this
                    action.
   */  
  public void modify (Selector selector, int start, int end) {
    switch (selector.action) {
      case Selector.REPLACE:
        newName.replace (start, end, selector.newValue);
        break;
      case Selector.INSERT_BEFORE:
        newName.insert (start, selector.newValue);
        break;
      case Selector.INSERT_AFTER:
        newName.insert (end, selector.newValue);
        break;
      case Selector.DO_NOTHING:
        break;
    } // end switch
  }

  /** 
    Increment the trailing characters of the file name by 1 
    compared to the last file processed.
   
    @param startingName Name to be incremented

   */  
  public void incrementNewName (String startingName) {
    newName = new StringBuffer (startingName);
    int i = lastDotPosition();
    boolean incAgain = true;
    char c;
    int position;
    String allowableChars = "";
    do {
      incAgain = false;
      i--;
      c = newName.charAt (i);
      position = DIGITS.indexOf (c);
      if (position >= 0) {
        allowableChars = DIGITS;
      } else {
        position = LOWER_CASE_LETTERS.indexOf (c);
        if (position >= 0) {
          allowableChars = LOWER_CASE_LETTERS;
        } else {
          position = UPPER_CASE_LETTERS.indexOf (c);
          if (position >= 0) {
            allowableChars = UPPER_CASE_LETTERS;
          } // end if upper-case letter
        } // end if not digit or lower-case letter
      } // end if not digit
      if (position >= 0) {
        position++;
        if (position >= allowableChars.length()) {
          position = 0;
          incAgain = true;
        }
        newName.setCharAt (i, allowableChars.charAt (position));
      }
    } while (incAgain);
  } // end method
  
  /** 
    Return the position of the last dot (period) in the new file name.
   
    @return Position of last period in the new file name, or length of
            file name if no period in file name.
   */
  public int lastDotPosition () {
    int dot = newName.toString().lastIndexOf ('.');
    if (dot < 0) {
      dot = newName.length();
    }  
    return dot;
  }
  
  /** 
    Returns the proposed new name for this file.
   
    @return The proposed new name for this file.
   */  
  public String getNewName () {
    return newName.toString();
  } 
  
  public boolean rename() {
    renamed = false;
    File newFile = new File (getParent(), newName.toString());
    try {
      renamed = renameTo (newFile);
    } catch (Exception e) {
    }
    return renamed;
  }
  
  public boolean undoRename() {
    boolean unrenamed = false;
    if (renamed) {
      renamed = false;
      File newFile = new File (getParent(), newName.toString());
      try {
        unrenamed = newFile.renameTo (this);
      } catch (Exception e) {
        unrenamed = false;
      }
    }
    return unrenamed;
  }
  
}
