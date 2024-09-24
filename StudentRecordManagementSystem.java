import java.util.ArrayList;
import java.util.Scanner;

// Class to represent individual student data
class Student {
    String name;
    int id;
    int age;
    String grade;

    // Constructor to initialize student object
    public Student(String name, int id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

}

// Class for managing student records
class StudentManagement {

    // Static variables for storing total students and student list
    static int totalStudent = 0;
    static ArrayList<Student> studentList = new ArrayList<>();

    // Method to add a new student
    public static void addStudent(int id, String name, int age, String grade) {

        Student newStudent = new Student(name, id, age, grade);

        studentList.add(newStudent);
        totalStudent++;
        System.out.println("Student added successfully.");

    }

    // Method to update student information
    public static void updateStudent(int id, String name, int age, String grade) {

        boolean found = false;

        for (Student student : studentList) {
            if (student.id == id) {
                student.name = name;
                student.id = id;
                student.age = age;
                student.grade = grade;
                found = true;
                System.out.println("Student information updated successfully");
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Student ID not found.");
        }

    }

    // Method to view student details by ID
    public static void viewStudent(int id) {

        boolean found = false;

        for (Student student : studentList) {
            if (student.id == id) {
                student.displayDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Student ID not found.");
        }

    }

    // Method to display the total number of students
    public static void displayTotalStudents() {
        System.out.println("Total student: " + totalStudent);
    }

}

/**
 * StudentRecordManagementSystem
 */
public class StudentRecordManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nAdministrator Menu:");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. View Total Number of Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // adding a new student
                    System.out.println("Enter student name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter student grade: ");
                    scanner.nextLine();
                    String grade = scanner.nextLine();
                    StudentManagement.addStudent(id, name, age, grade);
                    break;

                case 2:
                    // updating student information

                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new name: ");
                    scanner.nextLine(); // Consume newline
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    scanner.nextLine(); // Consume newline
                    String newGrade = scanner.nextLine();
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;

                case 3:
                    // Viewing student details
                    System.out.print("Enter student ID to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;

                case 4:
                    // Viewing total students
                    StudentManagement.displayTotalStudents();
                    break;

                case 5:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }
        scanner.close();
    }

}
