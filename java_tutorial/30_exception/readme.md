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

