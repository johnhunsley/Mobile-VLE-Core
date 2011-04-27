############################ Mobile VLE Core ############################

This is the core project for the Mobile VLE project. It defines the interfaces
used to access the VLE and is a dependency of the other Mobile VLE projects.

You'll need to build and install this project using Maven before you can build the
VLE Handler implementation package and the Android front end.

You'll need Maven installed on your machine to build it see http://maven.apache.org/

To build this project check it out to a directory e.g. ~/Mobile-VLE-Core/ 

From the command line cd into that directory, the pom.xml and src/ dir should be present in this
directory, then issue the following 

mvn clean install

You'll end up with a target/ directory in the same directory and the MobileVLE_Core-1.0.jar which 
will also be installed in your local maven repo.

Now you can build the VLE Handler implementation followed by the Android front end app.

email john@vlemobile.com or jphunsley@gmail.com for more help  :-)