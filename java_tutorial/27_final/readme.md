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
### <br/>

### 다른 블로그를 추가적으로 참고하였다.
#### https://makemethink.tistory.com/184
### 다음과 같이 선언 후 딱 한 번만 초기화를 할 수는 있다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/7f4f8f88-c1a5-4cf8-b902-b6d587a4b84d)
### <br/>

### static 은 한 번 선언하면 끝인데, final 은 초기화를 한 번 진행할 수 있어 인스턴스에서 값을 딱 한 번 지정해줄 수 있다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/52fbac4a-ed51-4919-8c2e-67899472d2a9)
### <br/>

### static 이랑 final 은 '한 번의' 초기화가 가능하냐 가능하지 않냐의 차이이다.
### 메모리 효율을 위해 static 이랑 final 은 자주 같이 쓰인다.
#### * static 을 사용하면 고정된 메모리 주소값을 계속 사용하는 것이다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/29843627-e885-4b19-821b-10ceeed2c947)

