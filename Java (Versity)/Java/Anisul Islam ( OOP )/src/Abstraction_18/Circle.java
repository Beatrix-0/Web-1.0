package Abstraction_18;

public class Circle extends Shape{
    double r ;
    Circle(double r){
        super(r , r);
        this.r = r;
    }

    @Override
    void area(){
        double res = 3.1416*r*r ;
        System.out.println( "Area of Circle is : " + res);
    }
}
