### 231221
## exception 임의로 만들기
### if 문을 활용하여 입의로 raise exceiotion 을 만들 수 있다.
### 아래에서는 throw new IllegalArgumentException 으로 발생시켰다.
```
//package 32_exception;


class Calculator{
    int left, right;
    public void setOprands(int left, int right){
        if(right == 0){
            throw new IllegalArgumentException("두번째 인자의 값은 0이 될 수 없습니다.");
        }
        this.left = left;
        this.right = right;
    }
    public void divide(){
        try {
            System.out.print("계산결과는 ");
            System.out.print(this.left/this.right);
            System.out.print(" 입니다.");
        } catch(Exception e){
            System.out.println("\n\ne.getMessage()\n"+e.getMessage());
            System.out.println("\n\ne.toString()\n"+e.toString());
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();
        }
    }
} 


class Calculator2{
    int left, right;
    public void setOprands(int left, int right){
        this.left = left;
        this.right = right;
    }
    public void divide(){
        if(right == 0){
            throw new IllegalArgumentException("두번째 인자의 값은 0이 될 수 없습니다.");
        }
        try {
            System.out.print("계산결과는 ");
            System.out.print(this.left/this.right);
            System.out.print(" 입니다.");
        } catch(Exception e){
            System.out.println("\n\ne.getMessage()\n"+e.getMessage());
            System.out.println("\n\ne.toString()\n"+e.toString());
            System.out.println("\n\ne.printStackTrace()");
            e.printStackTrace();
        }
    }
} 



public class example {
    public static void main(String[] args) {
        //Calculator c1 = new Calculator();
        //c1.setOprands(10, 0);
        //c1.divide();

        Calculator2 c2 = new Calculator2();
        c2.setOprands(10, 0);
        // 다음과 같이 throw 로 받은 exception 을 호출할 수도 있다.
        try {
            c2.divide();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

```
### <br/>

### 예외에 대한 메쏘드이다.
|예외|사용해야 할 상황|
|---|---|
|IllegalArgumentException|매개변수가 의도하지 않은 상황을 유발시킬 때|
|IllegalStateException|메소드를 호출하기 위한 상태가 아닐 때|
|NullPointerException|매개 변수 값이 null 일 때|
|IndexOutOfBoundsException|인덱스 매개 변수 값이 범위를 벗어날 때|
|ArithmeticException|산술적인 연산에 오류가 있을 때|
### <br/><br/>

### 모든 exception 메쏘드들이 다 Throw 할 수 있는 건 아니다.
### 다음과 같이 부모가 RuntimeException 인 것 안에 있어야 가능하다.
### 이런 경우 예외 처리할 때는 throw 할 때 try catch 로 받아야 한다.
### 이렇게 바로 사용 가능한 것은 checked, throw 로 받아서 try catch 로 예외 처리해야하는 것은 unchecked exception 이라고 한다.
- checked exception
- unchecked exception
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/9a4b6fb3-11bb-4996-b3b1-7b0c4333bb0f)
### 부모 관계
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/dc05c9f0-6f73-4484-b046-6ecff9282427)
### <br/>


