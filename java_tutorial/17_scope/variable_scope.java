//package 17_scope;

public class variable_scope {
    static int i;


    static void a() {
        // 경우 1
        // 이렇게 하면 local scope variable 이 되어 무한 루프에 빠지지 않는다.
        int i;
        
        // 경우 2
        // 이 함수 바깥에서 선언한 i 라는 변수에 영향을 미친다. 그래서 무한루프에 빠진다.
        //i = 0;

        // 경우 3 
        // local scope 에서 선언한 i 에 i = 0 이 설정된다. 그래서 경우 1과 같다.
        //int i;
        //i = 0;
    }


    public static void main(String[] args) {
        // 경우 1
        // i = 0; 은 static 변수의 i 이다.
        for (i = 0; i < 5; i++) {
            a();
            System.out.println(i);
        }

        // 경우 2
        // for loop 안에서만 사용 가능한 i 변수이다 (int i = 0).
        for (int i = 0; i < 5; i++) {
            a();
            System.out.println(i);
        }
    }
}
