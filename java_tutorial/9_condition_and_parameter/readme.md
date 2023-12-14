### 231214
## 조건문, parameter
### <br/><br/><br/>

### parameter 를 쓰려면 args 를 쓴다. 먼저 컴파일을 하고 입력하면 된다.
```
public class condition_with_parameter {
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];

        System.out.println(a);
        if(a.equals("1")){
            System.out.println(b);
        }
    }
}

```
### <br/>

### 컴파일
```
javac condition_with_parameter.java
```
### <br/>

### cmd 창에서 명령어 입력
```
java [java_class_name] 1 2
```
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/85351c10-fd5d-47b2-9b3c-7e18cb8fec13)
