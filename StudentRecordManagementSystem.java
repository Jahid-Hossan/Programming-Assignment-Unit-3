import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    int age;
    int grade;

    public Student(String name, int id, int age, int grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    public void viewDetails() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }

}

class StudentManagement {

    static int totalStudent = 0;
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void addStudent(int id, String name, int age, int grade) {

        Student newStudent = new Student(name, id, age, grade);

        studentList.add(newStudent);
        totalStudent++;
        System.out.println("Student added successfully.");

    }

}
