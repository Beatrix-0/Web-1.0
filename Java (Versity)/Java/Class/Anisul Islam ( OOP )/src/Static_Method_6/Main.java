package Static_Method_6;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        // Without static
        s1.print1();
        // With static
        Student.print2();

    }
}
