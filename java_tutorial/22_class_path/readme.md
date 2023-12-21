### 231220
## class path
### java 파일을 컴파일하면 class 마다 하나씩 class 파일이 생성된다.
```
javac example1.java
```
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/97c88805-becb-41bf-b025-819f85609c0b)
### 그리고 실행하면 example1.class 는 '현재 경로' 에서 class 를 찾는다.
### <br/>

### 그래서 필요한 class 가 있는 경로에서 java 를 실행하면 실행이 된다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/32bfc3d9-5f33-4301-aa49-339a9daed8c7)
### <br/>

### 만약 다른 경로에서 실행하려고 하면 class 를 못 찾았다고 한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/83f1fb63-a967-4887-89af-a50790552d5c)
### <br/>

### 그래서 java 옵션으로 -classpath 을 붙여주면 실행이 된다.
### * -classpath "." 은 현재 경로를 추가해준 것이다.
### * -classpath ".;dir/" 이렇게 입력하면 순차적으로 우선순위를 두게 해서 classpath 를 추가할 수 있다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/decd11b6-a310-4956-831d-476817017fdb)
### <br/>

### ambiguous class
### 만약 같은 이름을 가진 class 가 2 개 이상 있다면 어떤 class 를 인식할지 모른다.
### 이런 경우에는 직접 패키지가 어디에 있는지 path 까지 명시해주어야 한다.
```
package org.opentutorials.javatutorials.packages.example3;
import org.opentutorials.javatutorials.packages.example1.*;
import org.opentutorials.javatutorials.packages.example2.*;
 
public class D {
    public static void main(String[] args) {
        org.opentutorials.javatutorials.packages.example2.B b = new org.opentutorials.javatutorials.packages.example2.B();
    }
}
  
```
### <br/>

