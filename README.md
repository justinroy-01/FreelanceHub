# FreelanceHub – Mini Freelancing Management System

FreelanceHub is a **Java-based desktop application** that helps freelancers manage clients, projects, and tasks in one place.  
Built using **Java Swing** and **MySQL**, it demonstrates how to connect front-end GUI and relational databases using **JDBC**.

---

## 🚀 Features
- User registration and login system
- Add, update, view, and delete clients, projects, and tasks  
- Interactive and reusable GUI with Java Swing  
- Database-backed workflow using MySQL  
- MVC-inspired modular design  
- Simple animated header for better UX  

---

## 🛠️ Technologies
- **Language:** Java (JDK 21)  
- **Database:** MySQL  
- **UI:** Java Swing  
- **Connectivity:** JDBC (`com.mysql.cj.jdbc.Driver`)  
- **IDE:** Eclipse / IntelliJ IDEA  
- **Server:** Localhost  

---

## 📁 Project Structure
FreelanceHub/
├── DatabaseConnection.java     # Handles DB connection and setup
├── Auth.java                   # Manages login & registration
├── FrameManager.java           # Controls GUI frames and navigation
├── Create.java / Update.java / View.java / Delete.java  # CRUD operations
├── AnimatedPanel.java          # Displays header animation
