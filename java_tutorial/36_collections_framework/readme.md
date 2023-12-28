### 231228
## collections and framework

## 리스트
### 배열을 사용할 때 불편한 점 : 배열에 몇 개까지 넣을 수 있는지 모른다는 점.
### ArrayList 를 쓰면 간편하다.
### 여기서 .add() 메쏘드에서 받는 인자는 Object 형 타입이기 때문에 어떤 타입도 수용이 가능한 것이다.
### Object 형은 다른 타입들의 부모 클래스이기 때문에 그 하위에 있는 타입들을 수용 가능하다.
### <br/>
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

## 집합
### 집합은 순서가 없다.
### collection_set_ex2.java 
### 강의에 있는 코드를 일부 변경하였다.
```
import java.util.HashSet;
 
import java.util.Iterator;

public class collection_set_ex2 {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
         
        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);
         
        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);
        
        // 부분집합 체크
        System.out.println(A.containsAll(B)); // false
        System.out.println(A.containsAll(C)); // true
        
        // 합집합
        HashSet<Integer> AB = new HashSet<Integer>();
        AB.addAll(A);
        AB.addAll(B);
        System.out.println("AB union : " + AB);
        
        // 교집합
        HashSet AB_inter = new HashSet(A);
        AB_inter.retainAll(B);
        System.out.println("AB intersect : " + AB_inter);

        // 차집합
        HashSet AB_diff = new HashSet(A);
        AB_diff.removeAll(B);
        System.out.println("AB difference : " + AB_diff);

        Iterator hi = A.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
}

```
### 부분집합 (subset)
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/8ca3c9bc-921b-4c6e-9350-d9fa5ba92654)

### 합집합 (union)
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/2b69486b-7419-4ba5-9ae9-567e6dd0b6c9)

### 교집합 (intersect)
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/18e387c3-a261-40e9-896b-eafc16fc7312)

### 차집합 (difference)
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/6e9f3c41-40fb-48d4-a699-5e8692575068)
### <br/>

### 프레임워크의 전체적인 hierarchy 는 다음과 같다.
- 하늘색 : 인터페이스
- 파란색 : 클래스
### 모든 클래스는 상위 인터페이스에 있는 add, remove 등을 가지고 있다 (최상단 collection 인터페이스 참고).
### 집합은 순서에 대한 기능이 없다.
### 리스트는 순서에 대한 기능이 구현되어 있다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/2b68da0a-2af8-4774-970e-0cfbcaad3ade)
### <br/>

### collection 인터페이스에 보면 iterator 가 있다.
### 구글에 java iterator API 라고 치면 다음의 사이트를 찾을 수 있다.
#### https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/fa806cf3-25c4-407d-9eb0-b92024aca3df)
### <br/>

### 다음과 같은 예제가 있다.
### hi.hasNext() 는 boolean 값을 return 한다.
### hi.next() 는 true 를 체크했으므로 다음 값이 있어서 바로 다음 값을 출력한다.
### hi.hasNext() 가 false 가 된 경우 다시 사용하려면 다시 초기화해야 한다.
```
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class framework_ex {
    public static void main(String[] args) {
        // HashSet
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        Iterator hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }

        // 이미 마지막에 도달하였기 때문에 첫 실행에서 false 
        // 다시 하려면 초기화 해야 함
        // hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }
    }
}

```
### <br/>

### 인터페이스는 집합, 리스트의 공통 부모이기 때문에 Collection 으로 오브젝트 선언이 가능하다.
```
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class framework_ex {
    public static void main(String[] args) {
        // HashSet
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        Iterator hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }
        
        // 이미 마지막에 도달하였기 때문에 첫 실행에서 false 
        // 다시 하려면 초기화 해야 함
        // hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }

        ////////////////////////////////////////////////////
        // ArrayList
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);

        Iterator hi_B = B.iterator();
        while(hi_B.hasNext()) {
            System.out.println(hi_B.next());
        }

        ////////////////////////////////////////////////////
        // Collection
        // Collection 은 인터페이스이고 HashSet, ArrayList 의 부모이다.
        // Collection 에는 add, remove, Iterator 메쏘드가 포함되어 있다.
        // 그래서 호출이 가능하다.
        // 또한 부모 인터페이스로 구현되어 있기 때문에 Collection 으로 호출해도 된다.
        Collection<Integer> C = new ArrayList<Integer>();
        C.add(1);
        C.add(2);
        C.add(3);

        Iterator hi_C = C.iterator();
        while(hi_C.hasNext()) {
            System.out.println(hi_C.next());
        }
    }
}

```
### <br/>

## map
### map 은 key : value 형태로 구성된 컨테이너다. 파이썬에서는 딕셔너리와 같다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/d3a30a41-2823-4469-bb77-44135d4d5662)
### <br/>

### 예제
```
import java.util.HashMap;

public class collection_map_ex {
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        // key, value
        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);

        // value 가져오기
        System.out.println(a.get("one"));
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));
    }
}
```
### <br/>

### 예제 2
### map 에 있는 모든 key : value 를 조회하는 방법 2 가지
- Map.Entry() 로 구하는 방법
- Iterator() 로 구하는 방법
```
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class collection_map_ex {
    public static void main(String[] args) {
        HashMap<String, Integer> a = new HashMap<String, Integer>();
        // key, value
        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);

        // value 가져오기
        System.out.println(a.get("one"));
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));

        // 모든 값을 반복해서 구하는 방법 2 가지
        iteratorUsingForEach(a);
        iteratorUsingIterator(a);
    }


    static void iteratorUsingForEach(HashMap map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        // entries 안에 있는 하나하나의 값을 entry 에 넣음
        // Map.Entry 로 key, value 각각을 구함
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
     
    static void iteratorUsingIterator(HashMap map){
        // Iterator 로 구하는 방법
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> i = entries.iterator();
        while(i.hasNext()){
            Map.Entry<String, Integer> entry = i.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}

```
### <br/>

## 정렬
### sort() 메쏘드를 구현하기 위해서는 implements Comparable 을 먼저 해야 한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/b13b392f-1719-41da-bf6c-8cb352cf0f12)
### 그리고 sort() 에서는 compareTo() 메쏘드가 내부적으로 돌아가는데, 값을 비교할 수 있게 메쏘드를 만들어줘야 한다.
### 값을 비교하기 위해서다. 값이 큰지 작은지 판단하고, 0 이 나오면 값이 같은 것...
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/7bc00496-c92d-466e-b91c-e6d17a9fc281)
```
import java.util.*;
 
class Computer implements Comparable{
    int serial;
    String owner;
    Computer(int serial, String owner){
        this.serial = serial;
        this.owner = owner;
    }
    public int compareTo(Object o) {
        return this.serial - ((Computer)o).serial;
    }
    public String toString(){
        return serial+" "+owner;
    }
}
 
public class CollectionsDemo {
     
    public static void main(String[] args) {
        List<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer(500, "egoing"));
        computers.add(new Computer(200, "leezche"));
        computers.add(new Computer(3233, "graphittie"));
        Iterator i = computers.iterator();
        System.out.println("before");
        while(i.hasNext()){
            System.out.println(i.next());
        }
        Collections.sort(computers);
        System.out.println("\nafter");
        i = computers.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
 
}
```
### 정렬 결과
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/473e6b5b-8e58-48d8-8748-3d912f7256a9)
