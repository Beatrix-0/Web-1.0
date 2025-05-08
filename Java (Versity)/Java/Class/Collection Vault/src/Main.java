import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    static double avg( HashMap<Integer , Integer > mp ){
        int sum = 0 ;
        for ( Integer x : mp.keySet()){
            sum += mp.get(x);
        }
        return sum / mp.size();
    }

    //    static int sum( ArrayList<Integer> v , int n ){
//        int sum = 0 ;
//        for ( int i = 0 ; i < n ; i++ ){
//            sum += v.get(i);
//        }
//        return sum ;
//    }
//
//    static int mx_f( ArrayList<Integer> v , int n ){
//        int mx = -1 ;
//        for ( int i = 0 ; i < n ; i++ ){
//            if ( v.get(i) > mx ){
//                mx = v.get(i);
//            }
//        }
//        return mx ;
//    }
//
//    static int mn_f( ArrayList<Integer> v , int n ){
//        int mn = 200 ;
//        for ( int i = 0 ; i < n ; i++ ){
//            if ( v.get(i) < mn ){
//                mn = v.get(i);
//            }
//        }
//        return mn ;
//    }
//
    public static void main(String[] args) {
//        ArrayList<Integer> v = new ArrayList<Integer>();
//        for( int i = 1 ; i <= 10 ; i++ ){
//            v.add(i);
//        }
//        int x = sum( v , v.size());
//        int mx = mx_f(v , v.size());
//        int mn = mn_f(v , v.size());
//        double avg = (x / v.size());
//
//        System.out.println( x + " " + mx + " " + mn + " " + avg );
//    }

//        HashSet<String> st = new HashSet<String>();
//        st.add("Bangladesh");
//        st.add("China");
//        st.add("England");
//        st.add("France");
//        st.add("Germany");
//
//        for (String s : st) {
//            System.out.print(s + " ");
//        }

        HashMap<Integer , Integer > mp = new HashMap<>();
        mp.put( 101 , 10 );
        mp.put( 102 , 20 );
        mp.put( 103 , 30 );
        mp.put( 104 , 40 );
        mp.put( 105 , 50 );

        for ( Integer x : mp.keySet()){
           System.out.println( x + " " + mp.get(x) );
        }

        double avg_salary = avg(mp);
        System.out.println( avg_salary );


    }
}