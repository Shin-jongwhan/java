class Calculator {
    // 클래스 변수를 호출하고 싶다면 static 을 써야 한다.
    static double PI = 3.14;        // static 이라고 붙이면 클래스 변수가 된다.
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}

public class class_variable {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);
 
        Calculator c2 = new Calculator();
        System.out.println(c2.PI);
 
        System.out.println(Calculator.PI);      // 클래스로부터 직접 클래스 변수 호출 가능

        // static 이 아니기 때문에 바로 호출 불가하다.
        //System.out.println(Calculator.left);
    }
}
