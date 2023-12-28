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
