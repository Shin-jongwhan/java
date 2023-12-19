class Calculator3{
    // 클래스 메쏘드를 구현할 경우 메쏘드에 static 이라고 붙여준다.
    public static void sum(int left, int right){
        System.out.println(left+right);
    }
     
    public static void avg(int left, int right){
        System.out.println((left+right)/2);
    }
}

public class class_method {
    public static void main(String[] args) {
        // 클래스 변수를 쓰면 인스턴스를 선언하지 않아도 쓸 수 있다.
        // 새로이 인스턴스를 생성하지 않아도 되니 메모리를 절약할 수 있다는 장점이 있다.
        Calculator3.sum(10, 20);
        Calculator3.avg(10, 20);
         
        Calculator3.sum(20, 40);
        Calculator3.avg(20, 40);
        
        // 물론 클래스 메쏘드를 인스턴스 선언 후 사용할 수도 있다.
        Calculator3 c1 = new Calculator3();
        c1.sum(20, 40);
    }
}
