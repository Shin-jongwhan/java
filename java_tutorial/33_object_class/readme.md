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

### 이러한 기본 라이브러리는 JRE 나 JDK 에 설치되어 있다. 
### Object.class 에 .toString() 에 대한 내용이 저장되어 있는데, 여기에 있는 코드를 수정하면 .toString() 에 대한 기능을 수정할 수 있다.
### <br/>

### 가비지 컬렉션 (garbage collection, GC)
### 아래 블로그를 참고하자
#### https://d2.naver.com/helloworld/1329
### GC 는 정말 중요한 개념이다. 하지만 간단하게 정리하자면, 안 쓰는 변수가 메모리에 저장되는데, 이를 다 썼는지 안 썼는지 체크해서 다 쓴 거면 제거해주는 것이다. 메모리 최적화 및 CPU 간 변수 참조 충돌을 막기 위해 사용하는 것이다. 
### 여기서 많은 CPU 와 시간을 잡아먹는다.
### <br/>

### 클론 (복제)
### 복제를 하려면 다음과 같은 과정을 거쳐야 한다.
- 복제할 수 있는 클래스라고 알려줘야 한다. 그래서 implements Cloneable 를 해야 한다.
  ```
  class Test implements Cloneable {

  }
  ```
- .clone() 메쏘드를 이용한다.

#### <br/>
### 여기서 몇가지 주의 사항이 있는데, Cloneable 은 인터페이스로, 그냥 비어 있다. 
### 그래서 복제할 수 있도록 .clone() 메쏘드를 사용해야 한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/df6532bf-af5f-413d-a60c-c42774a42433)
### java API 문서에서 보면 .clone() 메쏘드는 throws CloneNotSupportedException 를 강제한다. 즉, 복제시 try catch 구문을 사용해야 한다.
### 또한 클래스가 Object 이기 때문에 복제시 ([class_name]) 으로 명시해줘야 한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/364970e8-074d-4916-b99d-bc75d33b9c45)
#### <br/>

### 
