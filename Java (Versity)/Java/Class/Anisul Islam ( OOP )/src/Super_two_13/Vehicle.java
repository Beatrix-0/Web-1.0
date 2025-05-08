package Super_two_13;

public class Vehicle {
    String brand;
    String colour ;

    Vehicle(){

    }

    Vehicle(String brand, String colour) {
        this.brand = brand;
        this.colour = colour;
    }

    void print(){
        System.out.println("Brand: " + brand);
        System.out.println("Colour: " + colour);
    }
}
