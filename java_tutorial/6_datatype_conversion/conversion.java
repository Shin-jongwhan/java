//package 6_datatype_conversion;

public class conversion {
    public static void main(String[] args) {
        // 자동 형변환 (암시적 형변환 (implicit conversion))
        // 데이터 타입이 더 큰 경우 암시적 형변환이 가능하다.
        // 그 반대는 안 된다.
        float a = 1.1F;
        double b = a + 1.2;
        System.out.println(b);

        // 명시적 형변환 (explicit conversion)
        // 데이터 타입이 선언이 되었지만, 다른 데이터 타입을 선언해주는 것이다.
        int c = (int) 1;
        System.out.println(c);

        // 다음과 같이 다른 타입을 가진 변수를 명시적으로 다른 데이터 타입으로 선언할 수 있다.
        float d = (float) 100.0;
        int e = (int) d;
        float f = (float) c;
        System.out.println("e : " + e);
        System.out.println("f : " + f);
    }
}
