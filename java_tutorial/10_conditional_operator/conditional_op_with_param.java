public class conditional_op_with_param {
    public static void main(String[] args) {
        // id 와 password 를 받아서 맞는지 확인하는 예제
        // cmd 창에서 다음과 같이 입력한다.
        // java conditional_op_with_param test 111111
        String id = args[0];
        String password = args[1];
        
        if (id.equals("test") && password.equals("111111")) {
            System.out.println("right");
        } else {
            System.out.println("wrong");
        }
    }
}
