Introduction 
------------------------------------------------------
------------------------------------------------------
Flight Details Query System : this is consoled based program
	This program will take 3 console inputs [Deparature location, Arrival location and Valid date] from user and based on the user inputs,
	program should search for the flights from the loaded csv file and list the results on standard output, sorted by Fare.
Assumption
	Date in CSV file should be in dd-MM-yyyy format
	
------------------------------------------------------
For executing this program - Setup required: 
- Java 8 is required.
- Eclipse/Netbeans/intelliJ etc IDE
------------------------------------------------------
How to install:

Download Jdk8 (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
To Install the JDK Software and Set JAVA_HOME, PATH on a Windows System
Install the JDK software.

Go to https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html.
In Java SE Development Kit 8u231 software, accept the license agreement.
Select Windows x64/x86.
Create oracle account with your personal email id and download will get started.
Double click on downloaded program and follow the steps to install jdk and jre.
The JDK software is installed on your computer, for example, at C:\Program Files\Java\jdk1.8.0_231\.
Set JAVA_HOME:

Right click My Computer and select Properties.

On the Advanced tab, select Environment Variables, and then edit JAVA_HOME to point to where the JDK software is located, for example, C:\Program Files\Java\jdk1.8.0_231\.

Set PATH:

Add in PATH variable C:\Program Files\Java\jdk1.8.0_231\bin, C:\Program Files\Java\jdk1.8.0_231\lib
To verify installation, run “java -version” command in command prompt as shown below.

Eclipse IDE (https://www.eclipse.org/downloads/packages/release/2019-12/r/eclipse-ide-enterprise-java-developers) (or IntelliJ)
------------------------------------------------------
How to run program:

1. Unzip the zip file
2. Open the IDE
3. Click on file followed by import
4. Select the path of unzip folder
5. Open Flight Details Query System
6. Open Main class file and run the program

------------------------------------------------------
File system: 
Input: FlightsData.csv file

Code files:
Main class - Entry point of the Flight Details Query System
Flight class - In this program we have used custom array/ arraylist for storing csv file data
Utilities class - This file is having generic or common methods
FileWatcher class - This is abstract class, this will check the file modification
TestOperations class - This class is having all the intermediate methods/functions used for the system to work in proper way