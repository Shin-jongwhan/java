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
