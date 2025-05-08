package Super_one_12;

public class two extends one {
    int x = 35 ;
    int y = 40 ;

    void print(){
        super.print();
        System.out.println("Class two");
    }

    void print1(){
        System.out.println(super.x + " " + y);
    }
}
