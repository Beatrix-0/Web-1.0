import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (RandomAccessFile raf = new RandomAccessFile("officer_file.txt" , "rw")){
            raf.seek(raf.length());
            raf.writeBytes("admin 123");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(!authentication(sc)){
            System.err.println("Password is incorrect. Try again.");
            return;
        }
        while (true){
            System.out.println("\nMenu");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add advised courses");
            System.out.println("4. View advised courses");
            System.out.println("5. Search course by Strident ID");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                addStudent(sc);
            }
            else if(choice == 2){
                viewStudents();
            }
            else if(choice == 3){
                AddAdvisedCourses(sc);
            }
            else if(choice == 4){
                ViewAdvisedCourse();
            }
            else if(choice == 5){
                SearchCourseByID(sc);
            }
            else if(choice == 6){
                System.exit(0);
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }

    static boolean authentication(Scanner sc){
        System.out.println("Please enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your password: ");
        String password = sc.nextLine();
        try (RandomAccessFile raf = new RandomAccessFile("officer_file.txt" , "r")){
            String line ;
            while((line = raf.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return false ;
    }

    static void addStudent(Scanner sc ){
        try(RandomAccessFile raf = new RandomAccessFile("student.txt" , "rw")){
            raf.seek(raf.length());
            System.out.println("Enter ID");
            String id = sc.nextLine();
            System.out.println("Enter Name");
            String name = sc.nextLine();
            System.out.println("Enter Password");
            String password = sc.nextLine();
            System.out.println("Enter Program");
            String program = sc.nextLine();
            System.out.println("Enter Batch");
            String batch = sc.nextLine();
            System.out.println("Enter CGPA");
            double cgpa = sc.nextDouble();

            student Student = new student(id, name, password, program, batch, cgpa);
            raf.writeBytes(Student.toString() + "\n");

            System.out.println("Student added successfully");
        }
        catch( IOException ew){
            ew.printStackTrace();
        }
    }

    static void viewStudents(){
        try(RandomAccessFile raf = new RandomAccessFile("student.txt" , "r")){
            String line ;
            System.out.println("Student List");
            while ((line = raf.readLine()) != null){
                System.out.println(line);
            }
        }
        catch( IOException ew){
            ew.printStackTrace();
        }
    }

    static void AddAdvisedCourses(Scanner sc ){
        try(RandomAccessFile raf = new RandomAccessFile("course.txt" , "rw")){
            raf.seek(raf.length());
            System.out.println("Enter ID");
            String id = sc.nextLine();
            System.out.println("Enter Course Code");
            String courseCode = sc.nextLine();

            AdvisedCourse advised_course = new AdvisedCourse(id, courseCode);
            raf.writeBytes(advised_course.toString() + "\n");

            System.out.println("Advised Course added successfully");
        }
        catch( IOException ew){
            ew.printStackTrace();
        }
    }

    static void ViewAdvisedCourse(){
        try(RandomAccessFile raf = new RandomAccessFile("course.txt" , "r")){
            String line;
            System.out.println("Advised Course List");
            while((line = raf.readLine())!= null){
                System.out.println(line);
            }
        }
        catch( IOException ew){
            ew.printStackTrace();
        }
    }

    static void SearchCourseByID(Scanner sc ){
        System.out.println("Enter ID");
        String id = sc.nextLine();
        try(RandomAccessFile raf = new RandomAccessFile("course.txt" , "r")){
            String line;
            boolean ok = false ;
            System.out.println("Advised Course by ID" + " " + id + ": ");
            while ((line = raf.readLine()) != null){
                String[] part = line.split(",");
                if (part[0].equals(id)){
                    ok = true ;
                    System.out.println("Course Code " + part[1]);
                }
            }

            if (!ok){
                System.out.println("Course not found");
            }
        }
        catch( IOException ew){
            ew.printStackTrace();
        }
    }

}
