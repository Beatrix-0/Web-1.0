package Static_5;

public class Student {
    String name;
    String id;
    static String dept = "CSE";// same for all , relate with class only not object , dont take extra space

    Student(String name , String id ){
        this.name = name;
        this.id = id;
    }

    void print(){
        System.out.println(name + " " + id + " " + dept);
    }
}
