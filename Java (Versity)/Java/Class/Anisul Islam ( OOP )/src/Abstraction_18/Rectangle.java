package Abstraction_18;

public class Rectangle extends Shape{
    Rectangle(double x , double y ){
        super(x,y);
    }
    @Override
    void area(){
        double res = val1 * val2 ;
        System.out.println( "Area of Rectangle is : " + res);
    }
}
