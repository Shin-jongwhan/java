### 231228
## collections and framework
### 배열을 사용할 때 불편한 점 : 배열에 몇 개까지 넣을 수 있는지 모른다는 점.
### ArrayList 를 쓰면 간편하다.
### 여기서 .add() 메쏘드에서 받는 인자는 Object 형 타입이기 때문에 어떤 타입도 수용이 가능한 것이다.
### Object 형은 다른 타입들의 부모 클래스이기 때문에 그 하위에 있는 타입들을 수용 가능하다.
```
import java.util.ArrayList;
 
public class ArrayListDemo {
 
    public static void main(String[] args) {
        String[] arrayObj = new String[2];
        arrayObj[0] = "one";
        arrayObj[1] = "two";
        // arrayObj[2] = "three"; 오류가 발생한다.
        for(int i=0; i<arrayObj.length; i++){
            System.out.println(arrayObj[i]);
        }
         
        ArrayList al = new ArrayList();
        al.add("one");
        al.add("two");
        al.add("three");
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i));
        }
    }
 
}
```
### <br/>

### 그런데 위 코드에서 String 형의 변수에 담으려고 하면 에러가 난다.
### 그래서 명시적 형 변환을 해주어야 한다.
### 근데 이것도 예전 방식이다.
```
for(int i=0; i<al.size(); i++){
    String val = al.get(i);  // 에러남
    String val = (String)al.get(i);
    System.out.println(val);
}
```
### <br/>

### 제네릭을 사용하면 명시해주지 않아도 된다.
### 근데 내가 보기엔 이것도... 
```
ArrayList<String> al = new ArrayList<String>();
al.add("one");
al.add("two");
al.add("three");
for(int i=0; i<al.size(); i++){
    String val = al.get(i);
    System.out.println(val);
}
```
### <br/>

## 프레임워크
### 프레임워크는 다음과 같은 hierarchy 를 가지고 있다.
### 가장 상위에 collections 와 map 이 있다.
### set 은 집합이다. 중복 데이터를 원하지 않는 경우 사용한다.
### key : value 형태의 데이터를 원한다면 map 을 사용한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/58c9b9a0-dfaa-4d11-a57b-657a0e29e98f)
### <br/>



