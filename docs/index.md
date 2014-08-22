<!-- Generated using template product-user-guide-template.mdtoc -->
<!-- Generated using template product-user-guide-template.md -->
<h1 id="psrenamer-user-guide">PSRenamer User Guide</h1>


<h2 id="table-of-contents">Table of Contents</h2>

<div id="toc">
  <ul>
    <li>
      <a href="#introduction">Introduction</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li>
          <a href="#system-requirements">System Requirements</a>
        </li>
        <li>
          <a href="#rights">Rights</a>
        </li>
        <li>
          <a href="#installation">Installation</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#data-fields">Data Fields</a>
    </li>
    <li>
      <a href="#file-operations">File Operations</a>
      <ul>
        <li>
          <a href="#open">Open...</a>
        </li>
      </ul>

    </li>
    <li>
      <a href="#user-interface">User Interface</a>
    </li>
  </ul>

</div>


<h2 id="introduction">Introduction</h2>


PSRenamer is an application with a graphical interface that will easily rename a group of files for you. You can change file extensions, or any part of the file name. You can also assign a series of sequentially numbered file names, or replace certain characters with others. Preview and Undo functions are available. The files to be renamed must all reside in the top level of an existing folder.



<h2 id="getting-started">Getting Started</h2>


<h3 id="system-requirements">System Requirements</h3>


PSRenamer is written in Java and can run on any reasonably modern operating system, including Mac OS X, Windows and Linux. PSRenamer requires a Java Runtime Environment (JRE), also known as a Java Virtual Machine (JVM). The version of this JRE/JVM must be at least 6. Visit [www.java.com](http://www.java.com) to download a recent version for most operating systems. Installation happens a bit differently under Mac OS X, but generally will occur fairly automatically when you try to launch a Java app for the first time.

Because PSRenamer may be run on multiple platforms, it may look slightly different on different operating systems, and will obey slightly different conventions (using the CMD key on a Mac, vs. an ALT key on a PC, for example).

<h3 id="rights">Rights</h3>


PSRenamer Copyright 2003 - 2014 by Herb Bowie

PSRenamer is [open source software](http://opensource.org/osd). Source code is available at [GitHub](http://github.com/hbowie/psrenamer).

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

  [www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


<h3 id="installation">Installation</h3>


Download the latest version from [PowerSurgePub.com](http://www.powersurgepub.com/downloads.html). Decompress the downloaded file. Drag the resulting file or folder into the location where you normally store your applications. Double-click on the jar file (or the application, if you've downloaded the Mac app) to launch.


<h2 id="data-fields">Data Fields</h2>


PSRenamer works with file names.

<h2 id="file-operations">File Operations</h2>


File operations may be accessed via the File menu.

<h3 id="open">Open...</h3>


The **Open** command may be used as an alternative to pressing the **Set Folder** button, to set the folder in which files are to be renamed.

<h2 id="user-interface">User Interface</h2>



PSRenamer has a single main window containing the following controls.

Set Folder button
:    Pressing this button will produce a dialog box allowing you to select the folder containing the files to be renamed. The folder you select here will then appear in the Folder Path text box below. The same dialog box can be invoked using the File/Open menu item.

Preview button
:    Pressing this button will produce a preview of the files to be renamed in the Details window below, based on the criteria you have entered. Note that pressing this button before entering any criteria will produce a list of all the files in the selected folder.

Rename button
:    Pressing this button will actually rename the selected files according to the criteria you have specified. All the details of the renaming activity will be listed in the Details window below.

Undo button
:    If, immediately after pressing the Rename button, a review of the Details window reveals that you have done something other than what you intended, pressing this button will cause the file names to revert to their previous values.

Folder Path
:    This indicates the folder containing the files you wish to rename. This will initially default to the folder containing the PSRenamer program. You may type or paste a path directly into this field. You may also set it using the Set Folder button above.

Find
:    Note that there are four occurrences of this field and the next four. You may use any or all of these rows, depending on the complexity of the operation you wish to perform.

    Enter a value in the Find column to indicate the text value you wish to replace, or simply a value you wish to use as part of your selection criteria, if no Action is specified. If the Where field for this row is set to Equals, then an asterisk in this column will cause all file names to be selected.

Case
:    Check this box if you wish the Find value to be compared to your file names in a case-sensitive manner. Leaving this box unchecked will ignore differences in capitalization of letters.

Where
:    Select the location in the file names where you want the preceding Find value to be located. This can have one of five values. Note that each row initially defaults to a different one of these values. You may use as many of these as you like, and may change any of the rows to different values in this column. The allowable values are as follows.

    Begins With
    :    The Find value will only be located if it is at the very beginning of a file name.

	Contains
	:	The Find value will be located anywhere within a file name (but not within the file extension).

	Ends With
	:    The Find value will only be located if it is at the very end of a file name, but prior to the file extension.

	Equals
	:    The Find value will only be located if it is equal to the entire file name, ignoring the file extension and the period preceding the file extension. If this value is selected, then an asterisk in the Find column will match any and all file names.

	File Extension
	:    The Find value will only be located if it is a complete file extension.

New Value
:    This is the new value you wish to have replace the Find value. The exact case (upper/lower) of this text will be used as you enter it.

	Note that if you replace the entire file names for a group of files with a constant value, then this program will treat the new file name (preceding the extension) as a starting value for the first file, and will then increment that value by 1 for each succeeding file, so long as the file name ends with a digit or a letter. Note that, for this feature to work, all files selected must have the same extension.

Action
:    Select the action you wish to have performed. This can have one of the following values.

	Replace
	:    The New value will replace the Find value.

	Replace Chars
	:    When used in conjunction with the Contains option, the characters in the New Value string will replace the characters in corresponding positions of the Find string. The character 'b' in the Find string will be interpreted as a blank (aka space). The caret character ('^') in the New Value string will cause any occurrences of the corresponding character in the Find string to be removed, with no replacement character.

	Insert Before
	:    The New value will be inserted just before the Find value.

	Insert After
	:    The New value will be inserted just after the Find value.

	Do Nothing
	:    The Find value will be used to select file names to be acted upon, but no change will be made to or around this Find value.

Details
:    The results of pressing the Preview, Rename or Undo buttons will be shown here, along with any error messages. Files will not be renamed if the new name of the file already exists, unless the new name is to be renamed as well, in which case the sequence of renames will proceed in an order that will allow the collisions to be renamed first.




[java]:       http://www.java.com/
[pspub]:      http://www.powersurgepub.com/
[downloads]:  http://www.powersurgepub.com/downloads.html
[osd]:		  http://opensource.org/osd
[gnu]:        http://www.gnu.org/licenses/
[apache]:	     http://www.apache.org/licenses/LICENSE-2.0.html
[markdown]:		http://daringfireball.net/projects/markdown/
[multimarkdown]:  http://fletcher.github.com/peg-multimarkdown/

[wikiq]:     http://www.wikiquote.org
[support]:   mailto:support@powersurgepub.com
[fortune]:   http://en.wikipedia.org/wiki/Fortune_(Unix)
[opml]:      http://en.wikipedia.org/wiki/OPML
[textile]:   http://en.wikipedia.org/wiki/Textile_(markup_language)
[pw]:        http://www.portablewisdom.org

[store]:     http://www.powersurgepub.com/store.html

[pegdown]:   https://github.com/sirthias/pegdown/blob/master/LICENSE
[parboiled]: https://github.com/sirthias/parboiled/blob/master/LICENSE
[Mathias]:   https://github.com/sirthias

[club]:         clubplanner.html
[filedir]:      filedir.html
[metamarkdown]: metamarkdown.html
[template]:     template.html

[mozilla]:    http://www.mozilla.org/MPL/2.0/


