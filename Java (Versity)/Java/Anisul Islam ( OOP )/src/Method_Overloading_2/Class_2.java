package Method_Overloading_2;

public class Class_2 {
        int a ;
        int b ;
        double c ;

        int sum(int a, int b){
            return a + b;
        }
        double sum(int a, double c ){
            return a + c;
        }
        double sum(int a, int b, double c ){
            return a*b*c ;
        }
}
