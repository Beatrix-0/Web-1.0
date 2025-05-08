package Anonymous_Class_21;

// When we want to change the method to a perticular class from another class
// kind of lemda function in c++

public class Main {
    public static void main(String[] args) {
        // Changing method of Student class from this current class(Main)
        Student s = new Student(){
            @Override
            void print(){
                System.out.println("I am a student , my name is Siam");
            }
        };
        s.print();
    }
}
