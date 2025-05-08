package Variable_Length_Argument_3;

public class Main {


    static int sum( int ... num ){ // for using 3 dot it can receive any amount of int value
        int sum = 0 ;
        for ( int it : num ){
            sum += it ;
        }
        return sum ;
    }

    public static void main(String[] args) {

        int x = sum( 1 , 2 );
        int y = sum(1 , 2 , 3);
        int z = sum(1 , 2 , 3 , 4);

        System.out.println( x + " " + y + " " + z );
    }
}
