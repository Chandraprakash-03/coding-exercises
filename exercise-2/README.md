# VIRTUAL CLASSROOM MANAGER

---

## Table of Contents

- **Introduction**
- **Features**
- **Installation**
- **Usage**
- **Documentation**
- **Contribution**

---

## Introduction

The Virtual Classroom Manager is a terminal-based application designed to manage virtual classrooms, including class scheduling, student enrollment, assignment management and submissions. It provides a streamlined interface for managing classrooms, students, and assignments, ensuring an organized and efficient virtual learning environment.

---

## Features

- **Classroom Management**:
    - Add new classrooms.
    - List existing classrooms.
    - Remove classrooms.
- **Student Management**: 
    - Enroll students into classrooms.
    - List students in each classroom.
    - Remove students from classrooms.
- **Assignment Management**:
    - Schedule assignments for classrooms.
    - Allow students to submit assignments.
    - Allows providing assignments to specified students.

---

## Getting Started

1. **Clone the repository**

```bash
git clone https://github.com/Chandraprakash-03/coding-exercises.git
```

2. **Navigate to the project directory**:

```bash
cd coding-exercises/Exercise-2
```

3. **Compile the project**:

Ensure you have Java JDK 11 or later installed. Compile the Java files using:

```bash
javac *.java
java Main
```
---

## Usage
### Command Format

The application accepts commands in the following format:

- `add_classroom <classroom_name>`
- `add_student <student_id> <classroom_name>`
- `schedule_assignment <classroom_name> <assignment_id> <description>`
- `submit_assignment <student_id> <classroom_name> <assignment_id>`
- `list_students <class_name>`
- `list_assignments <class_name>`
- `list_classrooms`
- `remove_classroom <class_name>`
- `remove_student <student_id> <class_name>`
- `assign_for_student <student_id> <assignment_id> <description> <duedate>`
- `list_assignment_for_student <student_id>`

---

### Example Commands

- Add a classroom:
```
add_classroom Math101
```

- Add a student:
```
add_student 12345 Math101 
```

- Schedule an assignment:
```
schedule_assignment Math101 HW01 "Complete the exercises" 
```

- Submit an assignment:
```
submit_assignment 12345 Math101 HW1 
```

---

## Documentation

Each class and method is documented with Javadoc comments. You can view the Javadoc documentation for detailed information on the functionalities provided by each component.

## Contribution

If you have any suggestions or improvements, feel free to open an issue or submit a pull request.


