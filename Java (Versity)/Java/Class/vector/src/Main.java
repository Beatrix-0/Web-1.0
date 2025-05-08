import java.util.HashMap;

public class Main {

    static double avg( HashMap<Integer , Integer > mp )
    {
        int sum = 0 ;
        for ( Integer x : mp.keySet()){
            sum += mp.get(x);
        }
        return sum / mp.size();
    }

    public static void main(String[] args) {
        HashMap<Integer , Integer > mp = new HashMap<>();
        mp.put(101 , 10);
        mp.put(102 , 20);
        mp.put(103 , 30);
        mp.put(104 , 40);
        mp.put(105 , 50);

        for ( Integer key : mp.keySet() ) {
            System.out.println(key + " : " + mp.get(key));
        }

        double salary = avg(mp);
        System.out.println(salary);
    }
}