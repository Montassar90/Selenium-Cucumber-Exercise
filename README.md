# E-commerce Application Test Automation Project

## 📌 Introduction

This project is an automated testing suite for the e-commerce application [Automation Exercise](https://automationexercise.com/). The tests are written in **Java** using **Selenium WebDriver** for browser automation and **Cucumber** for Behavior-Driven Development (BDD).

---

## 📖 Project Overview

This project automates various user flows of the e-commerce platform **Automation Exercise**. The goal is to ensure that key functionalities of the platform (such as **login, product search, cart management, etc.**) work as expected through **end-to-end tests**.

---

## 🛠 Technologies Used

- **Java** - The programming language used for writing test logic.
- **Selenium WebDriver** - Automates browser interactions.
- **Cucumber** - Framework for BDD-style testing, allowing tests to be written in a more readable format.
- **JUnit** - Test runners used to execute test cases.
- **Maven** - For dependency management and project build.
- **Log4j** - Used for logging test activities and results.

---

## 📂 Project Structure

```
Selenium-Cucumber-Exercice/
│-- src/
│   ├── spec/features/featuresFiles      # Contains the .feature files written in Gherkin language.
│   ├── test/java                        # Contains step definitions and test classes.
│   ├── test/resources                   # Contains Extent Report and log4j configuration.
│   ├── configs/                          # Contains configFile.properties (not provided, you must create your own).
│-- pom.xml                               # Project Object Model file for Maven dependency management.
```

---

## 🚀 Setup Instructions

### 1️⃣ Clone the repository:
```sh
git clone https://github.com/Montassar90/Selenium-Cucumber-Exercice.git
```

### 2️⃣ Navigate to the project directory:
```sh
cd Selenium-Cucumber-Exercice
```

### 3️⃣ Install dependencies:
Make sure you have **Maven** installed, then run:
```sh
mvn clean install
```

---

## 🏃 Running the Tests

To run the tests using Maven, execute the following command:
```sh
mvn test
```

Alternatively, you can run the tests using your preferred **IDE** (such as **IntelliJ** or **Eclipse**) by selecting the **TestRunner** class or executing individual **feature files**.

---

## 📊 Test Reporting

The project generates test reports using **Extent Report**. After running the tests, the reports can be found in the **/ExtentReports** directory.

---

## 🤝 Contributing

Contributions are welcome! If you'd like to improve this project, please create a **pull request** with a detailed description of your changes.

---

### 📩 Contact
For any inquiries or issues, feel free to open an **issue** in the repository.

---

💡 *Happy Testing!* 🛠️🚀

