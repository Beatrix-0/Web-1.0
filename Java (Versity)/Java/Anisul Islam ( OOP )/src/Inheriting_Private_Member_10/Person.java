package Inheriting_Private_Member_10;

public class Person {
    private String name;
    private int age;

    void setName(String name){
        this.name = name;
    }
    void setAge(int age){
        this.age = age;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }

}
