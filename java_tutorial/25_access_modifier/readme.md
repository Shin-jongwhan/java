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
