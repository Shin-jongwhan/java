### 231221
## 다형성 (polymorphism)
### 오버로딩도 다형성의 한 종류이다.
### 같은 조작 방법으로 다른 기능들이 있는 것을 의미한다.
### <br/>

### 아래는 A 라는 데이터 타입으로 new B() 를 만든 것이다.
### 이 경우 B 클래스에 있는 y() 는 에러가 난다.
### 왜냐면 데이터 타입이 A 라서...
### 하지만 오버라이딩을 하는 경우에는 클래스 B 에 있는 메쏘드가 출력이 된다.
```
class A{
    public String x(){return "x";}
}
class B extends A{
    public String y(){return "y";}
}
public class PolymorphismDemo1 {
    public static void main(String[] args) {
        A obj = new B();
        obj.x();
        obj.y();
    }
}
```
### <br/>

### 오버라이딩 할 경우
```
class A{
    public String x(){return "A.x";}
}
class B extends A{
    public String x(){return "B.x";}        // 오버라이딩을 하였음
    public String y(){return "y";}
}
public class PolymorphismDemo1 {
    public static void main(String[] args) {
        A obj = new B();
        System.out.println(obj.x());        // B 클래스에서 오버라이딩한 x() 메쏘드가 출력됨
    }
}
```
### <br/>

