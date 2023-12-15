import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class read_file {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("/TBI/People/tbi/jhshin/script/java_tutorial/14_input_output/test.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                System.out.println(sc.nextInt() * 1000);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
