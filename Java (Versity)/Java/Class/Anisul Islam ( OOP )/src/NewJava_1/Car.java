package NewJava_1;

public class Car {
    String name;
    int year;
    Car(){

    }

    Car(String name , int year){
        this.name = name ;
        this.year = year;
    }

    void print(){
        System.out.println("Name: " + name);
        System.out.println("Year: " + year);
    }
}
