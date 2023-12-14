//package 9_condition;

public class condition {
    public static void main(String[] args) {
        // if 문 기본
        if(true) {
            System.out.println("result : true");
        }

        // if, else
        if(true) {
            System.out.println("result : true");
        }
        else {
            System.out.println("result : false");
        }

        // if, else if, else
        // true 인 조건문을 위에서부터 처음 만난 것을 출력한다. 
        // 다른 것은 생략한다.
        if(false) {
            System.out.println("result : true 1");
        }
        else if(true) {
            System.out.println("result : true 2");      // 출력됨
        }
        else if(true) {
            System.out.println("result : true 3");      // true 이지만 출력 안 됨
        }
        else {
            System.out.println("result : false");
        }

        // if 문 중첩
        if(true) {
            System.out.println("result : true");
            if(1 == 1){
                System.out.println("Hi !");
            }
            else{
                System.out.println("Hello !");
            }
        }
        else {
            System.out.println("result : false");
        }
    }
}
