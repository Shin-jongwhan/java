//package 30_exception;


class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }


    public void divide(){
        // 에러 처리 방법
        try {
            System.out.print("계산결과는 ");        // 여기까지는 실행됨
            System.out.print(this.left/this.right);         // 여기서부터 에러
            System.out.print(" 입니다.");
        } catch(Exception e){
            // / by zero
            System.out.println("\n\ne.getMessage() : \n"+e.getMessage());
            
            // 좀 더 자세히
            // java.lang.ArithmeticException: / by zero
            System.out.println("\n\ne.toString() : \n"+e.toString());

            // 좀 더 자세히 2 
            /* 
             * java.lang.ArithmeticException: / by zero
                at Calculator.divide(example.java:16)
                at example.main(example.java:40)
             */
            System.out.println("\n\ne.printStackTrace() :");
            e.printStackTrace();
        }
    }


    public void divide2(){
        // 에러 처리 방법
        System.out.print("계산결과는 ");
        System.out.print(this.left/this.right);
        System.out.print(" 입니다.\n");
    }
} 


public class example {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOprands(10, 0);
        c1.divide();
         
        Calculator c2 = new Calculator();
        c2.setOprands(10, 0);
        //c2.divide2();
    }
}
