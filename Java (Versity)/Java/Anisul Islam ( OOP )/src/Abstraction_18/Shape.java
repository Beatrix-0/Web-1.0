package Abstraction_18;

public abstract class Shape {
    double val1 , val2;
    Shape( double val1 , double val2 ){
        this.val1 = val1;
        this.val2 = val2;
    }
    abstract void area();
}
