E-commerce Application Test Automation Project:

This project is an automated testing suite for the e-commerce application https://automationexercise.com/. The tests are written in Java using Selenium WebDriver for browser automation and Cucumber for Behavior-Driven Development (BDD).


-Project Overview:

This project automates various user flows of the e-commerce platform Automation Exercise. The goal is to ensure that key functionalities of the platform (like login, product search, cart management, etc.) work as expected through end-to-end tests.

-Technologies:

Java: The programming language used for writing the test logic.

Selenium WebDriver: Automates browser interactions.

Cucumber: Framework for BDD-style testing, allowing tests to be written in a more readable format.

JUnit: Test runners used to execute the test cases.

Maven: For dependency management and project build.

Log4j: Used for logging test activities and results.

-Project Structure:

src/spec/features/featuresFiles: Contains the .feature files that describe test scenarios in Gherkin language.

src/test/java: Contains step definitions and test classes.

src/test/resources: Contains Extent Report and log4j configuration.(cofigs contains the configFile.properties and it's not provided,you have to create your own file in order to run the tests) 

pom.xml: Project Object Model file used by Maven to manage dependencies and plugins.

-Setup Instructions:

1-Clone the repository:

git clone https://github.com/Montassar90/Selenium-Cucumber-Exercice.git

2-Navigate to the project directory:

cd Selenium-Cucumber-Exercice

3-Install dependencies: Make sure you have Maven installed, then run:

mvn clean install

-Running the Tests:

To run the tests, you can execute the following Maven command:

mvn test

Alternatively, you can run the tests using your preferred IDE (like IntelliJ or Eclipse) by selecting the TestRunner class or running the individual feature files.

-Reporting:

The project generates test reports using Extent Report. After running the tests, the reports can be found in the /ExtentReports directory.

-Contributing:

Contributions are welcome! Please create a pull request with a detailed description of your changes.





