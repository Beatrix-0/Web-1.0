package NewJava_1;


public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car( "BMW", 2000);
        c1.name = "Toyta";
        c1.year = 2019;
        c1.print();
        c2.print();
    }
}