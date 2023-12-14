public class datatype {
    public static void main(String[] args) {
        // 데이터 타입은 메모리 필요량에 따라 사용한다.
        // 데이터 타입의 크기에 따라 성능이 달라지기도 한다.
        System.out.println("Asdfasdf");
        byte a;
        // byte 타입은 128 까지만 허용하기 때문에 에러가 난다.
        // 이를 overflow 라고 한다.
        //a = 128;

        // 이건 에러 안 난다.
        a = 127;
        System.out.println(a);

        // long 타입을 선언하려면 끝에 L 을 붙여줘야 한다.
        // 참고 : b, c 는 같은 메모리 사이즈를 점유하고 있다(8 byte);
        long b = 2147381231136421237L;
        long c = 1L;
        
        // float 형은 F 를 뒤에다가 붙여준다.
        float flA = 1.2F;

        int d = 2147111111;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        
    }
    
}