### 231228
## 참조
### new 라고 쓰여지는 것들은 참조형 데이터 타입이다.
### <br/>

## 참조 예제 1
### 아래 코드에서, b 는 a 의 값을 변경하지 않는다.
```
public class reference_ex {
    public static void runValue(){
        int a = 1;
        int b = a;

        // b = a 이고, b 값을 바꾸면 a 값은 어떻게 되는가를 알아보기 위한 것
        b = 2;
        // a 는 1 로 출력이 된다.
        System.out.println("runValue a, "+a); 
        System.out.println("runValue b, "+b); 
    }

    public static void main(String[] args) {
        runValue();
    }
}

```
### <br/>

## 참조 예제2
### 아래 예제 코드에서, b 는 a instance 의 주소값을 가지고 오기 때문에 b 가 바뀌면 a 도 바뀐다.
```
class A{
    public int id;
    A(int id){
        this.id = id;
    }
}


public class reference_ex2 {
    public static void runValue(){
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue, "+a);     // 1
    }
    

    public static void runReference(){
        A a = new A(1);
        A b = a;
        b.id = 2;
        System.out.println("runReference, "+a.id);      // 2
    }


    public static void main(String[] args) {
        runValue();
        runReference();
    }
}

```
### new 로 객체를 만든 타입은 같은 인스턴스를 참조한다.
### b 는 a 가 어디에 있는지 참조한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/eaf07ec3-d96e-4a62-b589-6ebc824972cb)
### <br/>


