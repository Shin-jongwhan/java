### 231221
## 접근 제어자 (access modifier)
### public, private 으로 써진 것이 접근 제어자라는 것이다.
### <br/>

### 다음과 같은 코드가 있다.
```
class A {
    public String y(){
        return "public void y()";
    }
    private String z(){
        return "public void z()";
    }
    public String x(){
        return z();
    }
}


public class example {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.y());

        // 아래 코드는 오류가 발생한다.
        //System.out.println(a.z());
        
        System.out.println(a.x());
    }
}

```
### 여기서 private String z() 은 객체를 통해 직접 호출하려고 하면 에러가 난다.
### 하지만 public String x() 는 객체를 통해 호출이 가능하다.
### <br/>

### 접근 제어자는 왜 사용할까?
### 공통적으로 사용해야 하는 메쏘드가 있다.
### 이것은 내부적으로만 사용하는 것이고, 사용자가 직접적으로 호출하지 않아도 되는 메쏘드라면 private 으로 지정해도 된다.
### 하지만 사용자가 직접 사용해야 하는 경우라면, public 으로 지정해줘야 한다.
### 또한 내부적인 클래스를 의도적으로 변경하지 않도록 한다.
### 그리고 메쏘드의 사용을 제한함으로써, 전체 클래스의 틀을 유지하는 기능도 한다.
### <br/>

### 클래스 / 메쏘드의 캡슐화를 할 때는 어디까지 접근 가능한지 이해하면 좋다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/4a0451bf-3ffc-4cc3-b9db-df694efabd0c)
