package Encapsulation_8;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

//         Here i cant access 'name' and 'id' attribute as i declare them private
//         i can access 'batch' attribute as i am not declare it private
        //s1.name = "Siam";
        //s1.id = 2057 ;
        //s1.batch = 64 ;

//        To fix the problem we have to use getter and setter method in that particular class

        s1.setName("Siam");
        System.out.println(s1.getName());


    }
}
