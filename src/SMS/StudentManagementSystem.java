package SMS;


	import java.util.HashMap;
	import java.util.Scanner;
public class StudentManagementSystem {
	    static class Course {

	        int courseId;
	        String courseName;

	        Course(int courseId, String courseName) {
	            this.courseId = courseId;
	            this.courseName = courseName;
	        }
	    }

	    static class Student {

	        int id;
	        String name;
	        String email;
	        double marks;
	        int attendance;
	        String status;
	        Course course;

	        Student(int id, String name, String email,
	                double marks, int attendance,
	                String status, Course course) {

	            this.id = id;
	            this.name = name;
	            this.email = email;
	            this.marks = marks;
	            this.attendance = attendance;
	            this.status = status;
	            this.course = course;
	        }

	        void display() {

	            System.out.println("Student ID: " + id);
	            System.out.println("Name: " + name);
	            System.out.println("Email: " + email);
	            System.out.println("Marks: " + marks);
	            System.out.println("Attendance: " + attendance + "%");
	            System.out.println("Status: " + status);
	            System.out.println("Course: " + course.courseName);
	            System.out.println();
	        }
	    }

	    static class StudentService {

	        HashMap<Integer, Student> students =
	                new HashMap<>();

	        void addStudent(Student student) {

	            if (students.containsKey(student.id)) {

	                System.out.println("Student ID already exists.");

	            } else {

	                students.put(student.id, student);

	                System.out.println("Student added successfully.");
	            }
	        }

	        void displayStudents() {

	            if (students.isEmpty()) {

	                System.out.println("No students found.");

	                return;
	            }

	            for (Student student : students.values()) {

	                student.display();
	            }
	        }

	        void searchById(int id) {

	            Student student = students.get(id);

	            if (student != null) {

	                student.display();

	            } else {

	                System.out.println("Student not found.");
	            }
	        }

	        void searchByName(String name) {

	            boolean found = false;

	            for (Student student : students.values()) {

	                if (student.name.equalsIgnoreCase(name)) {

	                    student.display();

	                    found = true;
	                }
	            }

	            if (!found) {

	                System.out.println("Student not found.");
	            }
	        }

	        void updateMarks(int id, double marks) {

	            Student student = students.get(id);

	            if (student == null) {

	                System.out.println("Student not found.");

	                return;
	            }

	            if (marks < 0 || marks > 100) {

	                System.out.println("Marks must be between 0 and 100.");

	                return;
	            }

	            student.marks = marks;

	            System.out.println("Marks updated successfully.");
	        }

	        void updateAttendance(int id, int attendance) {

	            Student student = students.get(id);

	            if (student == null) {

	                System.out.println("Student not found.");

	                return;
	            }

	            if (attendance < 0 || attendance > 100) {

	                System.out.println(
	                        "Attendance must be between 0 and 100."
	                );

	                return;
	            }

	            student.attendance = attendance;

	            System.out.println("Attendance updated successfully.");
	        }

	        void calculateGrade(int id) {

	            Student student = students.get(id);

	            if (student == null) {

	                System.out.println("Student not found.");

	                return;
	            }

	            if (student.marks >= 90) {

	                System.out.println("Grade: A");

	            } else if (student.marks >= 80) {

	                System.out.println("Grade: B");

	            } else if (student.marks >= 70) {

	                System.out.println("Grade: C");

	            } else if (student.marks >= 60) {

	                System.out.println("Grade: D");

	            } else if (student.marks >= 50) {

	                System.out.println("Grade: E");

	            } else {

	                System.out.println("Grade: F");
	            }
	        }

	        void removeStudent(int id) {

	            Student student = students.remove(id);

	            if (student != null) {

	                System.out.println("Student removed successfully.");

	            } else {

	                System.out.println("Student not found.");
	            }
	        }

	        void displayTopper() {

	            if (students.isEmpty()) {

	                System.out.println("No students found.");

	                return;
	            }

	            Student topper = null;

	            for (Student student : students.values()) {

	                if (topper == null ||
	                        student.marks > topper.marks) {

	                    topper = student;
	                }
	            }

	            System.out.println("Topper:");

	            topper.display();
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        StudentService service = new StudentService();

	        while (true) {

	            System.out.println();
	            System.out.println("===== Student Management System =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. Display Students");
	            System.out.println("3. Search By ID");
	            System.out.println("4. Search By Name");
	            System.out.println("5. Update Marks");
	            System.out.println("6. Update Attendance");
	            System.out.println("7. Calculate Grade");
	            System.out.println("8. Remove Student");
	            System.out.println("9. Display Topper");
	            System.out.println("10. Exit");

	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {

	                case 1:

	                    System.out.print("Enter Student ID: ");
	                    int id = sc.nextInt();

	                    sc.nextLine();

	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Email: ");
	                    String email = sc.nextLine();

	                    System.out.print("Enter Marks: ");
	                    double marks = sc.nextDouble();

	                    System.out.print("Enter Attendance: ");
	                    int attendance = sc.nextInt();

	                    sc.nextLine();

	                    System.out.print("Enter Course Name: ");
	                    String courseName = sc.nextLine();

	                    Course course =
	                            new Course(1, courseName);

	                    Student student =
	                            new Student(
	                                    id,
	                                    name,
	                                    email,
	                                    marks,
	                                    attendance,
	                                    "ACTIVE",
	                                    course
	                            );

	                    service.addStudent(student);

	                    break;

	                case 2:

	                    service.displayStudents();

	                    break;

	                case 3:

	                    System.out.print("Enter Student ID: ");

	                    int searchId = sc.nextInt();

	                    service.searchById(searchId);

	                    break;

	                case 4:

	                    sc.nextLine();

	                    System.out.print("Enter Student Name: ");

	                    String searchName = sc.nextLine();

	                    service.searchByName(searchName);

	                    break;

	                case 5:

	                    System.out.print("Enter Student ID: ");

	                    int marksId = sc.nextInt();

	                    System.out.print("Enter New Marks: ");

	                    double newMarks = sc.nextDouble();

	                    service.updateMarks(
	                            marksId,
	                            newMarks
	                    );

	                    break;

	                case 6:

	                    System.out.print("Enter Student ID: ");

	                    int attendanceId = sc.nextInt();

	                    System.out.print("Enter New Attendance: ");

	                    int newAttendance = sc.nextInt();

	                    service.updateAttendance(
	                            attendanceId,
	                            newAttendance
	                    );

	                    break;

	                case 7:

	                    System.out.print("Enter Student ID: ");

	                    int gradeId = sc.nextInt();

	                    service.calculateGrade(gradeId);

	                    break;

	                case 8:

	                    System.out.print("Enter Student ID: ");

	                    int removeId = sc.nextInt();

	                    service.removeStudent(removeId);

	                    break;

	                case 9:

	                    service.displayTopper();

	                    break;

	                case 10:

	                    System.out.println("Thank you!");

	                    sc.close();

	                    return;

	                default:

	                    System.out.println("Invalid choice.");
	            }
	        }
	    }
	}

