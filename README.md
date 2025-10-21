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
- **Language:** Java (TERUMIN 21)  
- **Database:** MySQL  
- **UI:** Java Swing  
- **Connectivity:** JDBC (`com.mysql.cj.jdbc.Driver`)  
- **IDE:** Eclipse / IntelliJ IDEA  
- **Server:** Localhost  

---

## 📁 Project Structure
```
FreelanceHub/
├── DatabaseConnection.java       # Handles DB connection and setup
├── Auth.java                     # Manages login & registration
├── FrameManager.java             # Controls GUI frames and navigation
├── Create.java                   # Adds clients, projects, and tasks
├── Update.java                   # Modifies project/task details
├── View.java                     # Displays data from database
├── Delete.java                   # Removes entries safely
├── AnimatedPanel.java            # Banner animation for UI
└── README.md                     # Project documentation
```
```

If you want to **automatically generate a tree structure** file, you can use this Python script and run it locally:

```python
import os

def generate_tree_structure(root_dir, output_file, indent=""):
    with open(output_file, 'w') as readme:
        generate_tree(root_dir, readme, indent)

def generate_tree(directory, readme, indent):
    items = os.listdir(directory)
    items.sort()
    for i, item in enumerate(items):
        item_path = os.path.join(directory, item)
        is_last = i == len(items) - 1
        if os.path.isdir(item_path):
            readme.write(f"{indent}{'└── ' if is_last else '├── '}{item}/
")
            next_indent = indent + ("    " if is_last else "│   ")
            generate_tree(item_path, readme, next_indent)
        else:
            readme.write(f"{indent}{'└── ' if is_last else '├── '}{item}
")

if __name__ == "__main__":
    generate_tree_structure("./FreelanceHub", "PROJECT_TREE.md")
    print("Project tree saved to PROJECT_TREE.md")
```




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
