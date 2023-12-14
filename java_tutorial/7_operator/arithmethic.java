//package 7_operator;

public class arithmethic {
    public static void main(String[] args) {
        int a = 2;
        int result;

        result = a + 1;     // 2 + 1 = 3
        System.out.println(result);

        result = result - 1;        // 3 - 1 = 2
        System.out.println(result);
        
        result = result * 2;        // 2 * 2 = 4
        System.out.println(result);

        result = result / 2;        // 4 / 2 = 2
        System.out.println(result);

        // 나머지 연산 (%)
        result = 7;
        System.out.println("\n나머지 연산");
        System.out.println(result % 1);
        System.out.println(result % 2);
        System.out.println(result % 3);
        System.out.println(result % 4);
        System.out.println(result % 5);
        System.out.println(result % 6);
        System.out.println(result % 7);
    }
}
