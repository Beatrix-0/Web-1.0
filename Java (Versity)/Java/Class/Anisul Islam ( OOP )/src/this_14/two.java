package this_14;

public class two extends one {

    @Override
    void print(){
        System.out.println("The name of this class is two");
    }

    void print1(){
        super.print();
        this.print();
    }
}
