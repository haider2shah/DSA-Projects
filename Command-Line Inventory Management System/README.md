# **Command-Line Inventory Management System**

This is a command-line application for managing a parts inventory, built in Java. It serves as a practical demonstration of implementing a custom hash table from scratch for efficient data storage and retrieval.

## **Features**

* **Add Parts:** Insert new parts with a unique part number, description, and quantity.  
* **Remove Parts:** Mark parts for deletion from the inventory.  
* **Find Parts:** Search for a part by its number to quickly retrieve its current quantity.  
* **View Inventory:** Print a formatted list of all parts currently in stock.

## **Core Concepts Demonstrated**

This project was built to showcase an understanding of fundamental data structures and algorithms:

* **Custom Hash Table:** The inventory is managed by a hash table built from the ground up using a Java array.  
* **Linear Probing:** Implements linear probing as a collision resolution strategy to handle multiple parts hashing to the same index.

## **Technologies Used**

* **Language:** [Java](https://www.java.com/en/)  
* **Build Tool:** [Maven](https://maven.apache.org/)

## **How to Run Locally**

To get this project running on your own machine, follow these steps.

### **Prerequisites**

* [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)  
* [Apache Maven](https://maven.apache.org/download.cgi)

### **Steps**

1. **Clone the repository:**  
   Bash  
   git clone https://github.com/haider2shah/DSA-Projects.git  
     
2. **Navigate to the project directory:**  
   Bash  
   cd DSA-Projects/Command-Line Inventory Management System/Driver

3. **Build the project with Maven:**  
   Bash  
   mvn clean install

4. **Run the application:**  
   Bash  
   mvn exec:java \-Dexec.mainClass="partslist.Driver"

## **Example Usage**

Enter the number of parts you will enter: 2

Entry \#1....  
   Enter the part description: CPU  
   Enter the part number: 1001  
   Enter the part quantity: 50

Entry \#2....  
   Enter the part description: GPU  
   Enter the part number: 2002  
   Enter the part quantity: 30

PARTS INVENTORY  
Desc.           Part\#      Qty  
CPU             1001       50  
GPU             2002       30

Enter part number to search for: 1001  
Quantity in Stock: 50\.  
