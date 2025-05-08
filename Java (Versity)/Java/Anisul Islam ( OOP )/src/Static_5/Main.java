package Static_5;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Siam" , "2023");
        Student s2 = new Student("Fahim" , "2025");

        s1.print();
        s2.print();

        // no need to create any object as dept is static
        // means, it only depend in class not object
        System.out.println(Student.dept);

    }
}
