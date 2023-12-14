public class infix_operator {
    public static void main(String[] args) {
        /* 
         * 단항연산자 (infix operator)
         * 항이 하나만 있는 것을 단항연산자라고 한다.
         * + 
         * -
         * ++
         * --
         */

        int a = 1;
        a++;
        System.out.println(a);
        ++a;
        System.out.println(a);
        a += 1;     // a + 1
        System.out.println(a);

        System.out.println(a++);        // a + 1 이 아닌 a 가 출력됨(a 를 먼저 print 하고 a + 1 을 함)
        System.out.println(a);      // a = a + 1 가 되어 출력됨
    }
}
