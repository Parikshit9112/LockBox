# SecureBox
## File Securing system using Java ,MySQL ,JDBC , Java Mail API

Secure Box is a Java-based file securing system employing MySQL JDBC for database connectivity, MVC design pattern, and Java Mail API for enhanced security. Responsibilities included backend development, role-based access control implementation. Achieved secure file handling and user authentication while ensuring scalability and maintainability.

## Overview
Libraries Used
- java.sql: Used for database functionalities, facilitating the storage of file metadata.
- java.util: Provides various utility classes and data structures used within the program.
- java.io: Used for handling input and output operations, essential for file handling.
- javax.mail: Enables email functionalities like sending notifications or alerts.
- javax.mail.internet.MimeMessage: A part of the JavaMail API used for handling MIME messages.
- java.util.Random: Provides support for generating random numbers used within the application.
- java.util.Properties: Used for maintaining application configuration properties.

## Getting Started
Prerequisites
- Java Development Kit (JDK) installed on your machine.
- MySQL database set up with necessary configurations.
  
## Installation
- Set up your MySQL database configure the necessary credentials within the application in MyConnection.java(db package).
- Create two tables 'users' and 'data' in MySQL.
    create table users(id int primary key auto_increment, name varchar(100),email varchar(100) unique);
    create table data(id int primary key auto_increment,name varchar(100),path varchar(255),email varchar(100),bin_data blob); 
- Ensure all required libraries are included in the project classpath.
- Import jar file javax.mail-1.6.2.jar 
  
## Usage
- Navigate to the src folder using the command line interface.

   cd path/to/JP project/src

- Compile the Java code using javac:

   javac Main.java

- Run the program using java:

   java Main
