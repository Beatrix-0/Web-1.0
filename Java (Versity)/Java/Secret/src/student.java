public class student {
    String id ;
    String name ;
    String password ;
    String program;
    String batch;
    Double CGPA;

    public student(String id, String name, String password, String program, String batch, Double CGPA) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.program = program;
        this.batch = batch;
        this.CGPA = CGPA;
    }

    public String toString(){
        return id + "," + name + "," + password + "," + program + "," + batch + "," + CGPA;
    }


}
