/*
 * Selector.java
 *
 * Created on June 17, 2003, 6:41 PM
 */

package com.powersurgepub.psrenamer;

/**
   A set of criteria used to select a file and generate a new name for it.<p>
   
   This code is copyright (c) 2003-2004 by Herb Bowie of PowerSurge Publishing. 
   All rights reserved. <p>
   
   Version History: <ul><li>
      2003/07/14 - Modified to add an EQUALS value for location,
                   and a FIND_ANY value for findValue. In conjunction,
                   these will allow an entire file name to be
                   replaced. <li>
  		2003/06/21 - Initial creation.
      </ul>
  
   @author Herb Bowie (<a href="mailto:herb@powersurgepub.com">
           herb@powersurgepub.com</a>)<br>
           of PowerSurge Publishing (<A href="http://www.powersurgepub.com">
           www.powersurgepub.com</a>)
  
   @version 2004/06/20 - Modified to add a "Replace Chars" option that interprets
                         the replacement string as a string of characters, with 
                         each character corresponding to a character in the
                         search string.
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
