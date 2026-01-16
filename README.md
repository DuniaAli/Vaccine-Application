# Vaccination Recommendation System

A Java console-based patient vaccination management system.  
This project demonstrates object-oriented programming, encapsulation, and conditional logic through patient record handling and vaccine recommendations.

---

## Features

- Add patients with basic demographic info
- Store patients in a simple record system
- Generate vaccine recommendations based on age ranges
- Console-driven user interaction
- Demonstrates core Java OOP design patterns

---

## Architecture Overview

The system is composed of four main Java classes:

### **`Patient.java`**
Represents an individual patient and stores:
- `id`
- `name`
- `age`
- vaccination status

Implements constructors, getters, and setters following encapsulation principles.

---

### **`PatientsRecord.java`**
Stores multiple `Patient` objects in an array.  
Responsible for:
- Adding new patients
- Retrieving stored records
- Record validation and formatting

Acts as a lightweight in-memory patient database.

---

### **`RecommendedVaccine.java`**
Contains conditional rules to generate age-based vaccine recommendations, such as:
- Childhood vaccines
- Teen/young adult vaccines
- Adult vaccines
- Senior vaccines

Returns formatted recommendation strings for output.

---

### **`TestApplication.java`**
Console UI driver and application entry point.

Handles:
- User input via `Scanner`
- Menu options
- Linking record and recommendation logic
- Displaying formatted results to the screen

---

## Running the Application

### **Requirements**
- Java 17+ (earlier versions likely compatible)
- Any IDE (IntelliJ, Eclipse, VS Code) or terminal

### **Compile + Run (Terminal)**

```bash
javac *.java
java TestApplication
