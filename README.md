# AutoShowHWA

The purpose of this project is having CRUD functionalities over REST API calls and provide interactions with the its user friendly front-end site. For this project Auto Car Show decided to be implemented 
with two relational tables and their interactions with the calls over the HTTP protocols. 

## Hobby Project for QA Academy with Spring (Week 9) (AutoShow)

The project aims to illusturate knowlegde of using tools learned through the acamdey for creating API service and its calls and having CRUD functionalities over HTTP protocols
by using front-end web technologies JavaScript language,HTML,CSS and as well as API serivces with back-end Java programming language.
# Getting Started

## Prerequisites

## Java
Go to this link download JDK
Click the Download link that and use the latest. This project has Java version 16 currently.
e.g. jdk-16.0.1_windows-x64_bin.exe

Run the installer with admin priveleges and follow the instructions.
Check if the installer set the PATH variable for you, as JDK15+ does this automatically.

To set the PATH variable, browse to Control Panel and then System.
Click Advanced and then Environment Variables.
Add the location of the bin folder of your JDK installation to the PATH variable in System Variables.
Typically, the full path is:
C:\User\Program Files\Java\jdk-16\bin

You can check your version by;

java -version

If you don't get a successful response from these commands, you will need to return to the installation process.

## Maven Builders
Go to this link download Maven
Click the Binary zip archive download under 'Files'.
e.g. apache-maven-3.8.1-bin.zip

Once that has downloaded, unzip it into your C:\Program Files folder.
And copy the path for the installation.
e.g. C:\User\Program Files\apache-maven-3.0.1

To set the PATH variable, browse to Control Panel and then System.
Click Advanced and then Environment Variables.
Add a new system variable using that path, with the name MVN_HOME or something recognisable.
Finally, add %MVN_HOME%\bin to the PATH variable.

To verify the Maven version, launch a command prompt window and type:
mvn -version

If you don't get a successful response from the command, you will need to return to the installation process.

## Eclipse EDI 
Go to this link download Eclipse
Download the X86_64 executable.
Run the .exe and complete the setup wizard to install Eclipse, default/java options are fine throughout.

## MySQL Server
Go to this link download MySQL(Used 8.0.25 in this version)
Download the mysql-installer-community-8.0.25.0.msi
Complete the setup wizard, making sure to select MySQL server.
All default options are fine, with a default password of root for the server

## h2 Testing Server

H2 server also implemented through pom.xml file dependecies for testing on virtual environment and profiles added too for both production and testing environment.

### Installing

Clone the project from GitHub
Use the following command to clone this repository to your local machine:
git clone https://github.com/Eboz98/AutoShowHWA

Afterwards, 


### Executing program

To run the application from Eclipse, simply right click the project folder in the hierarchical view on the left and Right click > Run as > Java Spring Boot Application

You will now be able to give user input to the program through the front-end website located at localhost:8080/cars.html

## Steps

First needs to be run through eclipse and then through your browser http://localhost:8080/cars.html

```
code blocks for commands
```
## Front-End

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Running the tests
To run all tests on the system, right click the project folder and Run as > JUnit Test

## Unit Tests
CarsServices has been tested with JUnit and Mockito.

## Integration Tests
CarsDTO related controller and serviceshas been tested with JUnit and Mockito by using the Integration testing.

## Testing Help
For example, to test the functionality of the Cars related classes (e.g CarsService, CarsController and DTOs):
In the package manager view on the left hand side,
locate the src/main/java folder/package and Right click > Run as > JUnit Test
This will unit test the overall project and each individual classby testing each method functions correctly.


## Version History

* 0.1
    * Initial Release

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

