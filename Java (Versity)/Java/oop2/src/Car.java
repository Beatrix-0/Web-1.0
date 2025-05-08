public class Car
{
    private String model ;
    private String brand ;
    private Double fuel;

    void setModel(String x ){
        this.model = x ;
    }
    void setBrand(String y ){
        this.brand = y ;
    }
    void setFuel( Double a){
        if ( a < 0 ){
            System.err.println("Invalid fuel");
        }
        else{
            this.fuel = a ;
        }
    }

    String getModel(){
        return this.model;
    }
    String getBrand(){
        return this.brand;
    }
    Double getFuel(){
        return this.fuel;
    }

    Car(){

    }
    Car(String brand){
        this.brand = brand;
    }
    Car(String brand , String model){
        this.brand = brand;
        this.model = model;
    }
    Car(String brand , String model , Double fuel){
        this.brand = brand;
        this.model = model;
        if ( fuel < 0 ){
            System.err.println("Invalid fuel");
        }
        else {
            this.fuel = fuel;
        }
    }



}
