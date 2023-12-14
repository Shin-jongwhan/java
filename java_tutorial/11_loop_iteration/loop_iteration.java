//package 11_loop_iteration;

public class loop_iteration {
    public static void main(String[] args) {
        /*
         * while (조건) {
         *     실행 영역
         * }
         */
        
        int a = 0;
        // 무한 루프
        //while (true) {
        //    System.out.println(a);
        //}
        
        System.out.println("while 조건문으로 빠져나오는 방법 1");
        // 20 까지 출력이 된다.
        while (true) {
            System.out.println(a);
            a++;
            
            if (a > 10) {
                break;
            }
        }

        // 19 까지 출력이 된다.
        System.out.println("\nwhile 조건문으로 빠져나오는 방법 2");
        a = 0;
        // 조건문으로 빠져나오는 방법 1
        while (a < 10) {
            System.out.println(a);
            a++;
        }

        /*
         * for 문
         * for(초기화; 종료조건; 반복실행){
         * 반복적으로 실행될 구문
         * }
         */
        System.out.println("\nfor 문 예제 1");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        /*
         * 반복문 제어 방법
         * break : 반복문을 깨고 나온다. 보통 if 등의 조건 등과 함께 사용한다.
         * continue : 한 반복의 실행 구문을 끝내고 다음 반복 실행 구문을 실행한다.
         */
        System.out.println("\nfor 문 예제 2, break");
        // 5 까지 출력된다.
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                break;
            }
        }

        System.out.println("\nfor 문 예제 2, continue");
        // 5 만 출력된다.
        for (int i = 0; i < 10; i++) {
            if (i != 5) {
                continue;
            }
            else {
                System.out.println(i);
            }
        }

        System.out.println("\nfor 문 예제 2, 반복문의 중첩");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i : " + i + ", j : " + j);
            }
        }
    }
}
