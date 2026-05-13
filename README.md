# Java QA Toolkit

A collection of Java-based utility toolkits and automation scripts built for software Quality Assurance (QA) and testing. This repository serves as a practical demonstration of core programming logic, input validation, and test-driven architecture.

## Current Tools

*   **Bug Validator (`bug_validator`)**
    A dynamic command-line tool that captures bug titles, verifies reproducible steps, calculates defect severity, and generates formatted reports. Built with robust defensive programming to handle hostile or blank user inputs without crashing.

*   **Cart Validator (`Cart_Validator`)**
    An e-commerce logic validation utility. Designed to test boundary conditions, validate numerical inputs (like item quantities and prices), and ensure accurate state calculations during simulated checkout flows.

*   **Authentication Validator (`AuthenticationValidator`)**
    A security and access-control testing script. Manages credential verification, simulates account lockout protocols after consecutive failed attempts, and handles user clearance levels using secure loop states.

## Technical Skills Demonstrated

*   **Defensive Programming & Input Validation:** Preventing system crashes from invalid data types (e.g., `InputMismatchException`) and boundary violations.
*   **Modular Code Architecture:** Strict isolation of manager and worker methods (Method Isolation) for clean execution.
*   **State Management:** Utilizing `while` loops and boolean flags to maintain persistent application states.
*   **Java `Scanner` API Mastery:** Advanced buffer management (clearing rogue inputs) and logic flow control.

## How to Run

1. Clone this repository to your local machine.
2. Navigate to the `src/` directory in your terminal.
3. Open the specific tool's folder and compile the Java file (e.g., `javac bug_validator/YourFileName.java`).
4. Execute the compiled class to begin the terminal prompt.
