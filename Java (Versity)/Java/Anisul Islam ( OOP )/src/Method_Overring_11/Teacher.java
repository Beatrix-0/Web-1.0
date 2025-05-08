package Method_Overring_11;

public class Teacher extends Person{
    String dept ;

    Teacher( String name, int age, String dept){
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    @Override
    void print(){ // main facility is , we can use same method name, we can change the inside code as we like
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + dept);
    }
}
