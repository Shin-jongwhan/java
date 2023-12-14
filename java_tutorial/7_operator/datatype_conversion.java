public class datatype_conversion {
    public static void main(String[] args) {
        // 데이터타입 형변환
        int a = 10;
        int b = 3;

        float c = 10.F;
        float d = 3.0F;

        System.out.println(a * b);      // 정수 * 정수 = 정수

        System.out.println(a * c);      // 실수
        System.out.println(c * d);      // 실수
        System.out.println(c / d);      // 실수

    }
}
