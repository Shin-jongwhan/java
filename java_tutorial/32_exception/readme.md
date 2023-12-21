### 231221
## exception 임의로 만들기
### if 문을 활용하여 입의로 raise exceiotion 을 만들 수 있다.
### 아래에서는 throw new IllegalArgumentException 으로 발생시켰다.
```
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
public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.setOprands(10, 0);
        c1.divide();
    }
}
```
### <br/>

### 예외에 대한 메쏘드이다.
|예외|사용해야 할 상황|
|IllegalArgumentException|매개변수가 의도하지 않은 상황을 유발시킬 때|
|IllegalStateException|메소드를 호출하기 위한 상태가 아닐 때|
|NullPointerException|매개 변수 값이 null 일 때|
|IndexOutOfBoundsException|인덱스 매개 변수 값이 범위를 벗어날 때|
|ArithmeticException|산술적인 연산에 오류가 있을 때|