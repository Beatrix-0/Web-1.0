package Static_Variable_7;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        // as count is not static so each call will be count individually
        System.out.println(s1.count + " " + s2.count + " " + s3.count);

        // as count is static so all call will be counted
        System.out.println(Student.s_count);
    }
}
