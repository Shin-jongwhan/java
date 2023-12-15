import java.util.Scanner;

public class param_2 {
    public static void main(String[] args) {
        // Scanner : CLI 창에서 input 을 입력 받아서 쓸 수 있게 한다.
        Scanner sc = new Scanner(System.in);        // 객체 생성
        int i = sc.nextInt();
        System.out.println(i * 1000);
        sc.close();
    }
}
