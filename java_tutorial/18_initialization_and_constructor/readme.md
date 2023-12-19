### 231219
## 초기화, 생성자 (매우 중요)
### <br/><br/><br/>

## 초기화 방법
### 클래스 선언 시 클래스 변수를 선언한다.
### 클래스를 선언하면, \[class_name\] 과 같은 명으로 클래스 안에 메쏘드를 \[class_name\] 과 같은 이름으로 하나 생성한다.
### 그 다음 파라미터를 주고, this.~ 을 이용해서 변수에 값을 준다.
```
class Calculator {
    int left, right;

    public Calculator(int left, int right) {
        this.left = left;
        this.right = right;
    }
 
    public void sum() {
        System.out.println(this.left + this.right);
    }
 
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}
```
### <br/><br/><br/>

## initialization_ex.java
### vs code 에서 초기화 예제 스크립트를 실행하려 하면 에러가 난다. 
### 그래서 터미널에서 컴파일 후 실행해보니 잘 실행이 된다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/eb8f8534-b833-49b5-b04b-a50ee21856ca)
### <br/>
