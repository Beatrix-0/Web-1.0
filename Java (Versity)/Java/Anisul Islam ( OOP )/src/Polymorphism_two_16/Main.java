package Polymorphism_two_16;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        Shape s2 = new Rectangle(12.5 , 3.6);
        Shape s3 = new Triangle(5.8 , 9.6);
        System.out.println(s1.area() + " " + s2.area() + " " + s3.area());
    }
}
