package Super_two_13;

public class Car extends Vehicle{
    int year;

    Car(String brand, String colour, int year ){
        super(brand, colour);
        this.year = year;
    }

    @Override
    void print(){
        super.print();
        System.out.println("Car year: " + year);
    }
}
