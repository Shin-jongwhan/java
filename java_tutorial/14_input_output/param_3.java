import java.util.Scanner;

public class param_3 {
    public static void main(String[] args) {
        // Scanner : CLI 창에서 input 을 입력 받아서 쓸 수 있게 한다.
        Scanner sc = new Scanner(System.in);        // 객체 생성
        while (sc.hasNextInt()) {       // 다음 input 이 있는지 확인한다. 그런데 int 이어야 true 를 return.
            System.out.println(sc.nextInt() * 1000);
        }
        sc.close();
    }
}
