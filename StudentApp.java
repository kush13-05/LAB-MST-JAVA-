import java.util.*;

public class StudentApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentController controller = new StudentController();

        while (true) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Department: ");
                    String dept = sc.next();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    controller.addStudent(new Student(id, name, dept, marks));
                    System.out.println("✅ Student added successfully!");
                    break;

                case 2:
                    System.out.println("ID\tName\tDept\tMarks");
                    for (Student s : controller.getAllStudents()) {
                        System.out.println(s.getStudentID() + "\t" + s.getName() + "\t" +
                                           s.getDepartment() + "\t" + s.getMarks());
                    }
                    break;

                case 3:
                    System.out.print("Enter StudentID to update: ");
                    id = sc.nextInt();
                    System.out.print("Enter new Marks: ");
                    marks = sc.nextDouble();
                    controller.updateMarks(id, marks);
                    System.out.println("Marks updated!");
                    break;

                case 4:
                    System.out.print("Enter StudentID to delete: ");
                    id = sc.nextInt();
                    controller.deleteStudent(id);
                    System.out.println("Student deleted!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
