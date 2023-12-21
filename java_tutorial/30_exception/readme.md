### 321221
## 예외처리
### <br/>

### 자바는 에러가 exception 으로 나온다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/0d7d375f-8c2a-474a-a089-8b56636a12b1)
### <br/>

### 에러 처리는 try catch 구문으로 한다.
```
public void divide(){
    // 에러 처리 방법
    try {
        System.out.print("계산결과는 ");
        System.out.print(this.left/this.right);
        System.out.print(" 입니다.");
    } catch(Exception e){
        System.out.println("오류가 발생했습니다 : "+e.getMessage());
    }
}
```
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/0e5b1919-2aeb-48ef-8288-b292403d91fd)
### <br/>

### catch 안에는 예외클래스 인스턴스가 들어간다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/f950979d-ead4-4dbd-9328-6eaee9654c7d)
### <br/>

### 다중 catch 를 사용하여 맞는 exception 으로 빠지게 할 수 있다.
#### example2.java
```
class A{
    private int[] arr = new int[3];
    A(){
        arr[0]=0;
        arr[1]=10;
        arr[2]=20;
    }
    public void z(int first, int second){
        try {
            System.out.println(arr[first] / arr[second]);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch(ArithmeticException e){
            System.out.println("ArithmeticException");
        } catch(Exception e){
            System.out.println("Exception");
        }
         
    }
}


public class example2 {
    public static void main(String[] args) {
        A a = new A();
        a.z(10, 0);
        a.z(1, 0);
        a.z(2, 1);
    }
}

```
### <br/>

### finally
### try, catch 다음에 나와야 한다.
### finally 는 마지막에 항상 실행되는 구문이다.
```
class A{
    private int[] arr = new int[3];
    A(){
        arr[0]=0;
        arr[1]=10;
        arr[2]=20;
    }
    public void z(int first, int second){
        try {
            System.out.println(arr[first] / arr[second]);
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch(ArithmeticException e){
            System.out.println("ArithmeticException");
        } catch(Exception e){
            System.out.println("Exception");
        } finally {
            System.out.println("finally");
        }
    }
}


public class example2 {
    public static void main(String[] args) {
        A a = new A();
        a.z(10, 0);
        a.z(1, 0);
        a.z(2, 1);
    }
}

```
### <br/>

