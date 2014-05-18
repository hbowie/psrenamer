
## Version 1.6 (2013-04-13)

1. **Released as Open Source Software**

    Released as Open Source Software under the terms of the Apache 2.0 license.


## Version 1.5 (2011-10-17)

1. **Improved Control over Window Positioning**

    Program now saves last window position and size as user preferences that are restored the next time the application is launched. Default position and size can be restored by using CMD W or selecting Reduce Window Size from the Help menu.

2. **Requirements Updated to Java Version 1.6+**

    Updated to required Java version 1.6 or later.

3. **Updated to Work with Mac OS X Lion**

    Updated to create a version that will run on OS X Lion


## Version 1.4 (2006-07-30)

1. **Check for Name Collisions**

    Changed to look for collisions with existing files. If collisions can be avoided by changing the order of renames, then they will be, otherwise renames will be skipped if they would cause existing files to be deleted.


## Version 1.3 (2004-06-20)

1. **Added Replace Chars Action**

    Added a new Action of Replace Chars which, in combination with the Contains option, will treat the Find and New Value strings as individual characters, with each character in the Find string being replaced by the character at the corresponding position in the New Value string. The letter b in the Find string will be interpreted as a blank. A caret ('^') in the New Value string will cause the corresponding character in the Find string to be removed without a replacement.


## Version 1.2 ()

1. **Help/About window opens at odd size.**

    Made Help/About window open at a more reasonable size.


## Version 1.1 ()

1. **Automatically Increment File Names**

    Added an equals option in the Where column, so that you can look for a matching pattern in the entire file name (minus the extension). For the new equals option only, an asterisk in the Find column will match any value. If you use these two new options together, then the new name you specify will essentially be interpreted as a starting name, and will have its trailing characters incremented by 1 for each successive file renamed. So if you say replace '*' with 'file number 001', then your files will be named 'file number 001', 'file number 002', etc. Similarly, 'file a' would result in 'file a', 'file b', etc.


## Version 1.0 ()

1. **GUI Tool for Renaming a Group of Files**

    Initial release of a new program that will allow the user to rename a group of files all at once. Program has a user-friendly interface and allows one or more sections of the file name to be searched for a matching string, and then will modify the file name in or around the matching string.






