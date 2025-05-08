package Inheriting_Private_Member_10;

    public class Teacher extends Person {
        private String dept;

        void setDept(String dept) {
            this.dept = dept;
        }
        String getDept() {
            return dept;
        }

        void print(){
            System.out.println("Name: " + getName());
            System.out.println("Age: " + getAge());
            System.out.println("Department: " + getDept());
        }
}
