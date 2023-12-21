### 231221
## final
#### https://opentutorials.org/course/1223/6145
### 코드를 변경하지 못 하게 강제하는 것.
### 이 경우 같은 클래스 내에서도 값을 변경하지 못 한다.
### 클래스, 메쏘드, 변수 모두에 사용 가능하다.
### <br/>

### 사용 방법
- class : final class C
- method : final void b(){}
- variable : static final double PI = 3.14;
### <br/>

### 예제 코드
```
package org.opentutorials.javatutorials.finals;
 
class Calculator {
    static final double PI = 3.14;
    int left, right;
 
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
        //Calculator.PI = 6;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
 
public class CalculatorDemo1 {
 
    public static void main(String[] args) {
 
        Calculator c1 = new Calculator();
        System.out.println(c1.PI);
        //Calculator.PI = 10;
 
 
    }
 
}
```
