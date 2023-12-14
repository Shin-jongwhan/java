//package 8_comparison_and_boolean;

public class comparison {
    public static void main(String[] args) {
        System.out.println(1 == 2);     // false
        System.out.println(1 == 1);     // true
        System.out.println("a" == "a");     // true

        System.out.println("\n숫자 비교");
        System.out.println(1 > 2);     // false
        System.out.println(1 < 2);     // true
        System.out.println(1 >= 2);     // false
        System.out.println(1 <= 2);     // false

        System.out.println("\nstring 비교");
        // 문자열을 비교할 때는 .equals 를 사용해야 한다.
        // ==은 두개의 데이터 타입이 동일한 객체인지를 알아내기 위해서 사용하는 연산자이기 때문에 b에 담긴 객체와 일치하지 않는 것이다. 
        // 이를 보안하는 비교 방법이 equals이고 이를 이용해서 서로 다른 객체들간에 값이 같은지를 비교할 수 있다. 
        String a = "Hello !";
        String b = new String("Hello !");
        System.out.println(a == b);     // false
        System.out.println(a.equals(b));        // true
    }
}
