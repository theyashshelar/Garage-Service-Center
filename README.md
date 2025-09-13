# Garage Service Billing System - Java Console App

A Java console-based application to manage a garage service center. It supports adding customers with vehicles, generating invoices for services, and viewing records. Ideal for learning Java OOP, console-based input handling, and simple backend logic.

---

## ✨ Features

- 👤 Add Customers with their Vehicles  
- 🧾 Generate Invoices for services  
- 📄 View all invoices  
- 🔎 View invoices by specific customer  
- 🚗 List all registered vehicles  
- 👥 List all registered customers  
- 🚪 Exit the application  

---

## 🛠 Tech Stack

- **Language:** Java (JDK 23)  
- **IDE:** IntelliJ IDEA (or any Java IDE)  
- **Concepts:** OOP (Encapsulation, Inheritance, Polymorphism), Collections API  
- **Data Handling:** Lists, Maps  
- **Input Handling:** Scanner-based console input  

---

## ▶️ How to Run

1. Clone the repository:
```bash
git clone https://github.com/theyashshelar/Garage-Service-Billing-System.git
```
2. Open the project in IntelliJ IDEA or any Java IDE.

3. Ensure you have MySQL Connector JAR added to your project classpath.

4. Run App.java from the src folder.

## 📸 Sample Console Output

```console
1. Add Customer with Vehicle
2. Generate Invoice 
3. Show Invoice
4. Show Invoices by Customer
5. Show All Customers
6. Show All Vehicles
7. Exit
Enter Your Choice: 1
Customer name: John
Customer Phone no: 1234567890
Enter Vehicle number: MH12AB1234
Enter Vehicle model: Honda City
Customer and Vehicle added successfully.

Enter Your Choice: 2
Enter Customer Id: 1
Enter Vehicle Id: 1
Enter Number of Services: 2
Enter the Service id: 101
Enter the Service id: 102
Invoice generated successfully.

Enter Your Choice: 3
InvoiceId: 1 | Customer: John | Vehicle: Honda City | Services: [101, 102] | Total: $500
```

🚀 Future Improvements

- Add database persistence (MySQL/PostgreSQL) for storing customers, vehicles, and invoices

- Implement a GUI using JavaFX or Swing

- Add detailed service catalog with pricing and service descriptions

---

- 👨‍💻 Developed by Yash Shelar

- 📧 Email: yashshelar006@gmail.com

- 🔗 GitHub: theyashshelar

