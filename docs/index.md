LinkTweaker User Guide
======================

## Introduction

LinkTweaker adjusts URLs (aka hyperlinks) to make them both more useful and more usable. 

LinkTweaker's operation is based on the philosophy that URLs should point a Web browser to a specific address, but should also tell a human user where a resource is located, so that said user can navigate to that resource through other means as well. To this end, LinkTweaker converts as many escape sequences as practical back to their original characters (changing a "%2F" back to a simple slash, for example), as well as removing other cruft and detritus that may have attached itself to a link somewhere along its journey. 

## System Requirements

LinkTweaker is written in Java and can run on any reasonably modern operating system, including Mac OS X, Windows and Linux. LinkTweaker requires a Java Runtime Environment (JRE), also known as a Java Virtual Machine (JVM). The version of this JRE/JVM must be at least 6. Visit [www.java.com][java] to download a recent version for most operating systems. Installation happens a bit differently under Mac OS X, but generally will occur fairly automatically when you try to launch a Java app for the first time.  

## Rights

LinkTweaker Copyright &copy; 2012 - 2013 Herb Bowie

LinkTweaker is [open source software][osd]. 

Licensed under the Apache License, Version 2.0 (the &#8220;License&#8221;); you may not use this file except in compliance with the License. You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an &#8220;AS IS&#8221; BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

LinkTweaker also incorporates or adapts the following open source software libraries. 

* BrowserLauncher2 &#8212; Copyright 2004 - 2007 Markus Gebhard, Jeff Chapman, used under the terms of the [GNU General Public License][gnu]. 

## Installation

Download the latest version from [PowerSurgePub.com][downloads]. Decompress the downloaded file. Drag the resulting file or folder into the location where you normally store your applications. 

## User Interface

LinkTweaker has a straightforward user interface consisting of the following elements. 

<dl>
	<dt>Input Link:</dt>
		<dd>Enter the link to be tweaked. Usually you would copy this information from a field in another app, and then paste it into this field. </dd>
		
	<dt>Output Link:</dt>
		<dd>This is the resulting link, after the tweaking has occurred. It may or may not be different than the input, and it may or may not still perform the same function. Always test the link before relying on it.  </dd>
		
	<dt>Remove SharePoint Cruft?</dt>
		<dd>When copying a link from Internet Explorer while navigating a SharePoint site, the copied link often seems to contain a great deal of additional, optional and apparently quite useless information. Checking this box will cause LinkTweaker to try to remove this stuff, resulting in a shorter and more straightforward hyperlink. </dd>
		
	<dt>Insert Redirect?</dt>
		<dd>In some cases, especially while inside a corporate firewall, it may be necessary to insert some sort of redirecting URL in order to successfully navigate to your ultimate destination. You will need to enter your redirect URL in the Preferences pane. Once doing so, checking this box will cause the redirect to be inserted before the Input Link.  </dd>
		
	<dt>Show spaces as spaces?</dt>
		<dd>In order to avoid corruption, especially when being relayed via email, spaces in hyperlinks are often converted to "%20" strings. Checking this box will convert these strings back to spaces, which will generally make the link more readable (but less durable). This may be useful as a temporary setting, just to see the elements of your URL as they would normally appear in a file or web browser.   </dd>
		
	<dt>Tweak</dt>
		<dd>Pressing this button will cause the tweaking logic to be applied to the Input Link, producing a new Output Link. However, since this operation is also triggered by most of your other actions in the user interface, it may not be strictly necessary to press this button.   </dd>
		
	<dt>Launch</dt>
		<dd>Pressing this button will cause the Output Link to be launched, using your favorite Web browser. This should be done to test the Output Link, to ensure it actually takes the user to your desired location.  </dd>
		
	<dt>Copy</dt>
		<dd>Pressing this button will cause the Output Link to be copied to the system clipboard, so that your next paste will place the Output Link into a new location.  </dd>
</dl>

[java]:       http://www.java.com/

[pspub]:      http://www.powersurgepub.com/
[downloads]:  http://www.powersurgepub.com/downloads.html

[osd]:				http://opensource.org/osd
[gnu]:        http://www.gnu.org/licenses/
[apache]:			http://www.apache.org/licenses/LICENSE-2.0.html
