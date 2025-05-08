package Overloding_Constructor_4;

public class Strudent {
    String name;
    String id;
    int batch ;

    Strudent(String name,String id, int batch){
        this.name=name;
        this.id=id;
        this.batch=batch;
    }

    Strudent(){

    }
    Strudent(String name){
        this.name=name;
    }

}
