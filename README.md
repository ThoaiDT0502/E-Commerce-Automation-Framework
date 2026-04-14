# E-Commerce Automation Framework

## Overview
This repository contains a robust, scalable, and maintainable Web Automation Testing Framework designed particularly for E-Commerce applications. The framework is engineered using **Java**, **Selenium WebDriver**, and **TestNG**, adhering to robust software design patterns such as the **Page Object Model (POM)** and **Data-Driven Testing (DDT)**.

## Technical Stack
- **Programming Language**: Java (JDK 17)
- **Web Automation**: Selenium WebDriver 4
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Design Pattern**: Page Object Model (POM)
- **Data-Driven Strategy**: Apache POI (Excel integrations)
- **Reporting**: ExtentReports 5
- **Logging**: Log4j
- **Driver Management**: WebDriverManager

## Framework Architecture
The framework follows an organized modular layout to ensure extreme reusability, clear readability, and frictionless maintenance:
- **`src/main/java/com/mystore/base`**: Contains `BaseClass.java` which encapsulates core configurations, WebDriver initialization, implicit waits, properties loading, and teardown methodologies.
- **`src/main/java/com/mystore/actiondriver`**: Provides a comprehensive custom operations wrapper (`Action.java`) around standard Selenium methods (Click, Type, Scroll, JS execution, Select, Hover) to handle synchronization dynamically. 
- **`src/main/java/com/mystore/pageobjects`**: Repository for Page Classes (e.g., `HomePage`, `CheckOutPage`, `PaymentPage`). Every class securely scopes explicit local WebElements and abstracts page actions.
- **`src/main/java/com/mystore/dataprovider`**: Data provider utilities bridging TestNG parameters with dynamic Excel constraints mapping.
- **`src/test/java/com/mystore/testcases`**: Dedicated test scripts testing functionalities sequentially (e.g., Authentication, Adding to Cart, Registering Before/While Checkout, E2E). Subclass implementation inherited from the `BaseClass`. 
- **`src/main/java/com/mystore/utility`**: Contains globally utilized services mechanisms such as Custom Event Listeners (`ListenerClass.java`), logging management (`Log.java`), Extent Configurations, and Excel manipulation (`NewExcelLibrary.java`).
- **`src/test/resources/TestData`**: Centralized Excel files (`TestData.xlsx`) where variant input datasets reside safely isolated from source code. 

## Key Features
- **Extensive Scenario Coverage**: Holistic end-to-end user journeys simulated securely over 18 test cases validating registrations, searches, reviews, shopping carts, subscriptions, and transaction checkouts.
- **Cross-Browser Verification**: Fully compatible across Chrome, Firefox, and Edge browsers powered seamlessly through mapped XML suites (`testng_crossbrowser.xml`).
- **Rich Interactive Reporting**: Dynamically synthesizes actionable HTML ExtentReports demonstrating precise Pass/Fail percentages, time durations, payload metrics, and environments. Automatic capturing and attachment of Screenshots for failure validations natively embedded in logs.
- **CI/CD Readiness**: Structured over a POM abstraction natively friendly to orchestration mechanisms (Jenkins, pipelines). Maven profile-execution enables contextual triggering constraints (Smoke, Sanity, Regression suites).
- **Comprehensive Logging**: Detailed, localized Log4j tracking ensuring deep step-by-step insight, auditing logic behaviors sequentially inside local `.log` files.

## Prerequisites
1. Java Development Kit (JDK) 17 or higher
2. Maven
3. A preferred Java IDE (IntelliJ IDEA / Eclipse)
4. Git 

## Installation & Setup
1. Clone this repository to your local machine:
```bash
git clone <repository_url>
```
2. Import the project directly into your IDE as a standard Maven Project.
3. Clean build and synchronize all Maven dependencies dynamically:
```bash
mvn clean install
```
4. Define parameters natively in `Configuration/Config.properties` if local endpoints overrides are necessitated.

## Execution Instructions
Engineered to allow isolated executions per suite, run mechanisms can be invoked locally or sequentially through Maven CLIs.

**Run via TestNG XML runner suites**
Navigate via IDE to the root directory and explicitly trigger any configured matrix:
- `testng-all.xml` (Full Master Suite)
- `testng-smoke.xml` (Smoke Validations)
- `testng-sanity.xml` (Sanity Logic validations)
- `testng-regression.xml` (Regression Validations)
- `testng_crossbrowser.xml` (Cross Browser Suite Verification)

**Run via Maven seamlessly**
```bash
# Execute native configurations 
mvn test

# Execute specialized runner subsets explicitly 
mvn test -Dsurefire.suiteXmlFiles=testng-sanity.xml
```

## Investigating Execution Artifacts
Upon test suites concluding success or failures, results are localized locally systematically:
- **Rich Reports**: Browse the visual log output generated systematically inside context directories.  
- **GUI Snapshots**: Investigate the `ScreenShots/` repository visually highlighting test execution UI failures mapped to logical timestamp checkpoints.
- **Application Logs**: Contextual logging traces are systematically built into `Logs/` locally.
