//package 34_reference;

public class reference_ex {
    public static void runValue(){
        int a = 1;
        int b = a;

        // b = a 이고, b 값을 바꾸면 a 값은 어떻게 되는가를 알아보기 위한 것
        b = 2;
        // a 는 1 로 출력이 된다.
        System.out.println("runValue a, "+a); 
        System.out.println("runValue b, "+b); 
    }

    public static void main(String[] args) {
        runValue();
    }
}
