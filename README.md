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


---

## 🧩 Database Schema
**Tables:**
- `users(user_id, username, password)`  
- `clients(client_id, client_name, contact_info)`  
- `project(project_id, project_name, description, user_id, client_id)`  
- `task(task_id, task_name, description, status, project_id)`

---

## 💡 How to Run
1. Clone the repository  
2. Create a MySQL database named `freelancehub`  
3. Update database credentials in `DatabaseConnection.java`  
4. Compile and run using your preferred IDE (Eclipse/IntelliJ)  
5. Use the GUI to register, log in, and manage your freelance tasks  

---

## 🧠 Future Enhancements
- Task deadline tracking  
- Export reports to PDF/CSV  
- User performance analytics dashboard  
- Cloud backup integration  

---

## 📚 References
- [Java Official Documentation](https://docs.oracle.com/javase)  
- [MySQL Developer Guide](https://dev.mysql.com/doc)  
- TutorialsPoint JDBC & Swing Guides  

---

### Author
**Developed by:** [Javanwala]  
**Technology Stack:** Core Java, JDBC, MySQL, Swing  

---
