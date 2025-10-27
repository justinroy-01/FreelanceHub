# 💼 FreelanceHub – Mini Freelancing Management System

### 🧠 Overview

**FreelanceHub** is a **Java-based desktop application** designed to streamline freelance project management.  
Built using **Java Swing** and **MySQL**, it connects an interactive UI with a powerful backend via **JDBC**.

Clients can post projects, set budgets, and hire freelancers based on skills and ratings —  
while freelancers can browse, bid, and manage their ongoing work efficiently.

> 🎯 A perfect mini-project demonstrating **Core Java**, **GUI Design**, **OOP Concepts**, and **Database Connectivity**.

---

## 🚀 Features

- 🔐 **User Authentication** – Secure login and registration system  
- 🧾 **Full CRUD Operations** – Add, view, update, and delete clients, projects, and tasks  
- 💬 **In-App Chat System** – Simple communication between freelancers and clients  
- 🎨 **Interactive Swing UI** – Clean interface with animated banner  
- 🧠 **MVC-Inspired Architecture** – Organized, modular, and reusable structure  
- 📊 **Admin Dashboard** – Manage users, monitor projects, and view analytics  
- 🗄️ **Database-Driven Workflow** – Persistent data storage via MySQL  

---

## 🛠️ Tech Stack

| Component | Technology |
|------------|-------------|
| **Language** | Java (Temurin 21) |
| **Database** | MySQL |
| **UI Framework** | Java Swing |
| **Connectivity** | JDBC (`com.mysql.cj.jdbc.Driver`) |
| **IDE** | Eclipse / IntelliJ IDEA |
| **Server** | Localhost |

---

## 📁 Project Structure

FreelanceHub/ ├── DatabaseConnection.java   # Handles MySQL connection setup ├── Auth.java                 # Login & Registration logic ├── FrameManager.java         # Manages GUI frame navigation ├── Create.java               # Adds clients, projects, and tasks ├── Update.java               # Updates project/task details ├── View.java                 # Displays stored data ├── Delete.java               # Handles safe record deletions ├── AnimatedPanel.java        # Adds header animation └── README.md                 # Project documentation

---

## 🧩 Database Schema

**Tables:**

| Table | Columns |
|--------|----------|
| **users** | `user_id`, `username`, `password` |
| **clients** | `client_id`, `client_name`, `contact_info` |
| **project** | `project_id`, `project_name`, `description`, `user_id`, `client_id` |
| **task** | `task_id`, `task_name`, `description`, `status`, `project_id` |

---

## ⚙️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/FreelanceHub.git
   cd FreelanceHub

2. Create a MySQL database

CREATE DATABASE freelancehub;


3. Update your MySQL credentials in DatabaseConnection.java


4. Run the project using Eclipse or IntelliJ IDEA


5. Login/Register and start managing freelance projects 🚀




---

🌱 Future Enhancements

📅 Task deadline tracking & progress reminders

📈 Freelancer performance analytics dashboard

📤 Export reports to PDF/CSV

☁️ Cloud backup and sync functionality

💰 Integrated payment & milestone tracking system



---

📚 References

☕ Java Official Documentation

🐬 MySQL Developer Guide

📘 TutorialsPoint JDBC Guide

🎨 Java Swing Documentation



---

👨‍💻 Author

Developed by: [Javanwala]
Tech Stack: Core Java · JDBC · MySQL · Swing
Purpose: Mini Project – Freelance Management System

> 💡 FreelanceHub is built as a learning-oriented project demonstrating the integration of front-end (Swing) and back-end (MySQL) using JDBC (java database connectivity).




---
