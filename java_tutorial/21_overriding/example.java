//package 21_overriding;

class Calculator {
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public int avg() {
        return ((this.left + this.right) / 2);
    }
}
 
class SubstractionableCalculator extends Calculator {
    
    // 자식 클래스에서 재정의한 메쏘드. 부모 클래스보다 우선순위가 부여되서 이 메쏘드가 실행된다.
    public void sum() {
        System.out.println("실행 결과는 " +(this.left + this.right)+"입니다.");
    }
     
    public int avg() {
        // 이 함수는 부모 클래스의 메쏘드와 같은 기능을 하지만, 자식 클래스의 메쏘드를 실행하는 것이다.
        // 그래서 이 메쏘드에 코드를 좀 더 추가하는 등의 커스터마이징을 할 수 있다.
        return super.avg();
    }
     
    public void substract() {
        System.out.println(this.left - this.right);
    }
}


public class example {
    public static void main(String[] args) {
        SubstractionableCalculator c1 = new SubstractionableCalculator();
        c1.setOprands(10, 20);
        c1.sum();
        System.out.println("실행 결과는" + c1.avg());
        c1.substract();
    }
}
