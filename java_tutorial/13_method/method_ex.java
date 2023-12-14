//package 13_method;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class method_ex {
    // 메쏘드 정의 방법
    // void : return 하는 변수의 타입
    public static void numbering(String a, int limit) {
        int i = 0;
        while (i < 10) {
            System.out.println(i + " : " + a);
            i++;
            if (limit < i) {
                break;
            }
        }
    }

    // 메쏘드가 String 데이터 타입을 return 
    public static String str_return() {
        return "return str";
    }

    // string 배열 return
    public static String[] str_arr_return() {
        return new String[] {"a", "b", "c"};
    }

    public static void main(String[] args) {
        // method 는 다른 언어에서는 함수 (function) 이라고 부른다.
        String a = "test";
        numbering(a, 5);

        String str = str_return();
        System.out.println(str);

        try {
            // output 파일을 저장
            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
            output.write(str);
            output.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        System.out.println("");
        String[] arrStr = str_arr_return();
        System.out.println(arrStr[0]);
    }
}
