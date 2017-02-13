#hellofresh challense

This project creates an automated test that will run few tests on the hellofresh site (uk, us divisions)
It is a Selenium project using TestNG framework and Maven for build and dependency handling. 
Page Object model framework is used to create the pages that are used for test.

##Prerequisites:

This project currently has the capability to run directly in windowsn machine and in firefox browser 


##Getting Started and installing:

This project can be imported directly as a Maven project All the dependency needed for the project are handled in the POM. 
However the firefoxdriver are kept in the resources folder rather and set to the system properties.
Importing this project and running on windows machine which has firefox browser will directly run the tests.
This project and be directly run from the command line as well with mvn test command which takes a parameter country.
-Dcountry=uk as the parameter will run tests on UK site and -Dcountry=us or -Dcountry = any paramater will run the test on US site.


##Running the Tests and Test Reports:

The tests can be run as Maven tests which are run using the TestNG framework.
The test data are called out in the testng xml and the testng xml is called inside the POM.
The TestNG report will be present target folder. reporter-output present inside suite folder will show the logs generated.

##Tests:

There are two tests that are present
1)ResgisterUSerLongin- which registers a new user and gives an error if the user is already present.
2)VerifyPlanBox- which uses a exisitng user credentials to login and verify the classic plan/box ,price are ok.
