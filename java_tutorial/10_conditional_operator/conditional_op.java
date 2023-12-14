//package 10_conditional_operator;

public class conditional_op {
    public static void main(String[] args) {
        // 논리연산자
        // and, or
        System.out.println("\nand 논리연산자");
        if (true && true) {     // 출력
            System.out.println(1);
        }
        if (true && false) {     // 출력 안 됨
            System.out.println(2);
        }
        if (false && true) {     // 출력 안 됨
            System.out.println(3);
        }
        if (false && false) {     // 출력 안 됨
            System.out.println(4);
        }

        // or 
        // 조건문 안에서 어느 것 하나라도 맞으면 true 이다.
        System.out.println("\nor 논리연산자");
        String a = "test";
        if (a.equals("tes") || a.equals("test")){       // true
            System.out.println("true");
        }
        // and 와도 같이 사용 가능
        if (a.equals("tes") || a.equals("test") && a.equals(a)){        // true
            System.out.println("true");
        }

        // not 논리 연산자
        System.out.println("\nnot 논리연산자");
        // not true = false
        if (! true) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

        // not false = true
        if (! false) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
