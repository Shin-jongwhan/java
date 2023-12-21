//package 31_exception;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class B{
    void run() throws IOException, FileNotFoundException{
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("31_exception/out.txt"));
        input = bReader.readLine();
        System.out.println(input); 
    }
}
class C{
    void run(){
        B b = new B();
        try {
            b.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


public class example1 {
    public static void main(String[] args) {
        C c = new C();
        c.run();
   }   
}
