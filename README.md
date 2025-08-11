# 💳 Bank Management System (Java Swing + MySQL + JDBC)

A Java-based desktop application that simulates an **ATM and bank management system**.  
It allows users to create bank accounts, log in, perform transactions (deposit, withdraw, fast cash), check balance, change PIN, and view mini statements.

---

## 📌 Features
- **User Registration** (3-step signup process)
- **User Login & Authentication**
- **Deposit Funds**
- **Withdraw Funds**
- **Fast Cash Withdrawal**
- **Balance Enquiry**
- **PIN Change**
- **Mini Statement View**
- **MySQL Database Integration**
- **ATM-style UI with icons**

---

## 🛠 Technologies Used
- **Java SE** (Swing, AWT)
- **MySQL** (Database)
- **JDBC** (MySQL Connector)
- **jCalendar** (Date selection UI)
- **IDE:** IntelliJ IDEA / Eclipse

---

## 📂 Project Structure
```
BankManagementSystem/
│── src/
│   └── atm/machine/system/
│       ├── BalanceEnquiry.java
│       ├── Conn.java
│       ├── Deposite.java
│       ├── FastCash.java
│       ├── Login.java
│       ├── MiniStatement.java
│       ├── PinChange.java
│       ├── SignupOne.java
│       ├── SignupTwo.java
│       ├── SignupThree.java
│       └── Transactions.java
│── library/
│   ├── jcalendar-tz-1.3.3-4.jar
│   └── mysql-connector-java-8.0.28.jar
│── SQL Query for db.sql   # Database schema & tables
│── icons/                 # UI icons
│── .idea/                 # IntelliJ project files
│── ATMMachineSystem.iml
│── README.md
```

---

## 🗄 Database Setup
1. Install **MySQL** and create a database.
2. Open **`SQL Query for db.sql`** in MySQL Workbench or CLI.
3. Execute the script to create the required tables.

---

## 🚀 Installation & Setup
### 1️⃣ Prerequisites
- Java JDK 8+ (tested with JDK 17)
- MySQL Server & MySQL Workbench
- IntelliJ IDEA / Eclipse

### 2️⃣ Steps
1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/BankManagementSystem.git
   ```
2. Import the project into your IDE.
3. Add the following libraries to your project build path:
   - `library/mysql-connector-java-8.0.28.jar`
   - `library/jcalendar-tz-1.3.3-4.jar`
4. Configure database credentials in `Conn.java`:
   ```java
   String url = "jdbc:mysql://localhost:3306/yourdbname";
   String user = "root";
   String password = "yourpassword";
   ```
5. Run the application:
   - First, **SignupOne.java** to create an account.
   - Then, **Login.java** to log in and use ATM features.

---

## 📜 License
This project is licensed under the MIT License.  
You are free to use, modify, and distribute this software.

---

## 👨‍💻 Author
- **Atharva Virkar** – [GitHub](https://github.com/AtharvaVirkar)
