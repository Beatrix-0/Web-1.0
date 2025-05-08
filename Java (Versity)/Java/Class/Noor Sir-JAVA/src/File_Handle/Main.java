package File_Handle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "Siam";
        int id = 20234;

//        String[] name = new String[5];
//        name[0] = "Akbar Ali";
//        name[1] = "Fahim Ahmed";
//        name[2] = "Siam Ahmed";
//        name[3] = "Juton Ahmed";
//        name[4] = "hi hello";

        ArrayList<String> name = new ArrayList<>();
        name.add("Akbar Ali");
        name.add("Fahim Ahmed");
        name.add("Siam Ahmed");
        name.add("Juton Ahmed");
        name.add("Hello");

        write(name);
        read();
    }

    public static void write(ArrayList<String> name) {
        try{
            RandomAccessFile raf = new RandomAccessFile("Student.txt" , "rw");
            raf.seek(raf.length());
            for (int i = 0 ; i < name.size() ; i++ ) {
                raf.writeBytes(name.get(i) + "\n");
            }
        }catch(FileNotFoundException ex ){
            System.out.println("File Not Found");
            ex.printStackTrace();
        }catch (IOException ex){
            System.out.println("IO Exception");
            ex.printStackTrace();
        }
    }

    public static void read(){
        try{
            RandomAccessFile raf = new RandomAccessFile("Student.txt" , "r");
            String s ;
            while ( (s = raf.readLine()) != null ){
                System.out.println(s);
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
            System.out.println("Can not read the file ");
        }
    }
}
