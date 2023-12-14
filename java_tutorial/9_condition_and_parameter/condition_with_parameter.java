public class condition_with_parameter {
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];

        System.out.println(a);
        if(a.equals("1")){
            System.out.println(b);
        }
    }
}
