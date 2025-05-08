package Overloding_Constructor_4;

public class Main {
    public static void main(String[] args) {
        Strudent s1 = new Strudent();
        s1.name = "James";
        Strudent s2 = new Strudent("Kamal");
        Strudent s3 = new Strudent("Rahim" , "301" , 64);

        System.out.println(s1.name);
    }
}
