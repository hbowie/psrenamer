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

/**
   A set of criteria used to select a file and generate a new name for it.<p>
   
 */
public class Selector {
  
  protected String findValue = "";
  
  public static final String FIND_ANY = "*";
  
  protected boolean caseSensitive = true;
  
  protected int location = 0;
  
  public static final int BEGINS_WITH = 0;
  public static final int CONTAINS = 1;
  public static final int ENDS_WITH = 2;
  public static final int EQUALS = 3;
  public static final int EXTENSION = 4;
  
  protected String newValue = "";
  
  protected int action;
  
  public static final int REPLACE = 0;
  public static final int REPLACE_CHARS = 1;
  public static final int INSERT_BEFORE = 2;
  public static final int INSERT_AFTER = 3;
  public static final int DO_NOTHING = 4;
  
  /** Creates a new instance of Selector */
  public Selector(String findValue, boolean caseSensitive, int location,
      String newValue, int action) {
    this.findValue = findValue;
    this.caseSensitive = caseSensitive;
    this.location = location;
    this.newValue = newValue;
    this.action = action;
  }
  
} // end class
