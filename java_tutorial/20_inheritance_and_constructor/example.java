//package 20_inheritance_and_constructor;

/*
 * 생성자와 함께 상속을 하는 방법
 * 1. 상속을 할 클래스를 생성한다(Calculator).
 * 2. 클래스 안에 기본 생성자를 선언한다. public Calculator(){}
 * 3. 그리고 새로운 생성자를 만들고 파라미터를 넣어주고 this.[var_name] 로 변수에 값이 들어갈 수 있도록 한다.
 * 4. 상속을 받을 클래스를 선언한다.
 * 5. 생성자를 만들어준다. 근데 여기서는 super() 를 이용하여 상속 클래스에 변수를 넘겨줄 수 있도록 한다.
 */

class Calculator {
    int left, right;
     
    public Calculator(){}
     
    public Calculator(int left, int right){
        this.left = left;
        this.right = right;
    }
     
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


class SubstractionableCalculator extends Calculator {
    public SubstractionableCalculator(int left, int right) {
        super(left, right);
    }
 
    public void substract() {
        System.out.println(this.left - this.right);
    }
}


public class example {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator(10, 20);
        c1.sum();
        c1.avg();
        c1.substract();
    }
}
