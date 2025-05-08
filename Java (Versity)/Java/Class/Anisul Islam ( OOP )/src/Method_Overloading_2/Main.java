package Method_Overloading_2;

public class Main {

    public static class Class_1 {
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

    static int sum(int a, int b){
        return a + b;
    }
    static double sum(int a, double c ){
        return a + c;
    }
    static double sum(int a, int b, double c ){
        return a*b*c ;
    }

    public static void main(String[] args) {
        // Method overloding : where method name is same but parameter must be diffrent


        // category 01 : where we can create class in main page
        Class_1 c1 = new Class_1();
        System.out.println(c1.sum(1,2) + " " + c1.sum(2,3.5) + " " + c1.sum(3,4 , 5.5));

        // category 02 : Creating class in diffrent page
        Class_2 c2 = new Class_2();
        System.out.println(c2.sum(1,2) + " " + c2.sum(2,3.5) + " " + c2.sum(3,4 , 5.5));

        // Category 03 : creating normal method (without class) in main page
        System.out.println(sum(1,2) + " " + sum(2,3.5) + " " + sum(3,4 , 5.5));
    }
}
