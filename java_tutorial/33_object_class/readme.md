### 231222
## 오브젝트
### 클래스 상속 구조
### 모든 클래스는 공통 조상인 Object() 라는 것이 있다. 상속을 하지 않았어도 자동으로 상속되는 것이다.
### <br/>

### 아래는 같은 의미이다.
```
class O {}
```
```
class O extends Object {}
```
### <br/>

### 오브젝트 클래스를 println 하는 것은 .toString() 을 자동으로 쓰는 것이다.
### 아래와 같은 코드가 있을때,,
```
class Calculator{
    int left, right;
      
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void sum(){
        System.out.println(this.left+this.right);
    }
      
    public void avg(){
        System.out.println((this.left+this.right)/2);
    }
}
  
public class CalculatorDemo {
      
    public static void main(String[] args) {
          
        Calculator c1 = new Calculator();
        c1.setOprands(10, 20);
        System.out.println(c1);
    }
  
}
```
### 아래 두 코드는 같은 의미이다. 
### * 어떻게 이렇게 기능을 할 수 있는 것인가?? 그것은 바로 overriding 으로 인한 것 !
```
System.out.println(c1);
System.out.println(c1.toString());
```
### <br/>


