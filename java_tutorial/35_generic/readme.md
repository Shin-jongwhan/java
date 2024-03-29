### 231228
## 제네릭
### 클래스의 인스턴스를 생성할 때 데이터 타입을 지정해줄 수 있게 한다.
### 다음과 같은 프로세스로 흘러간다.
### Person<String> p1 = new Person<String>(); 와 같이 <> 안쪽에 데이터 타입을 지정해주면 Person 클래스 안에서
### T 라는 데이터 타입으로 선언된 변수가 String 으로 된다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/82e323c5-417f-4e8c-8924-08cdcc8faa19)
### <br/>

### 제네릭은 왜 쓸까?
### 제네릭은 최근 도입된 기능이다.
### 아래 코드에서 클래스들은 중복 기능을 제공한다.
```
package org.opentutorials.javatutorials.generic;
class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class StudentPerson{
    public StudentInfo info;
    StudentPerson(StudentInfo info){ this.info = info; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class EmployeePerson{
    public EmployeeInfo info;
    EmployeePerson(EmployeeInfo info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        StudentInfo si = new StudentInfo(2);
        StudentPerson sp = new StudentPerson(si);
        System.out.println(sp.info.grade); // 2
        EmployeeInfo ei = new EmployeeInfo(1);
        EmployeePerson ep = new EmployeePerson(ei);
        System.out.println(ep.info.rank); // 1
    }
}
```
### 아래와 같이 기능적으로 묶을 수 있는 클래스 (초록색 박스)이고, 검은색 화살표로 연결된 클래스는 동일한 기능을 한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/075e58d8-717a-4a53-9b74-c367b7f7e76e)
### <br/>

### 이런 경우 공통의 조상을 가진 class 를 선언해주면 코드 중복을 피할 수 있을 것이다.
### <br/>

### 다음의 코드는 일부 코드 중복을 피하려고 작성한 코드인데, "부장"은 String 이다. 
### 그런데 컴파일 시 에러가 안 나는 문제가 발생한다.
### 이러한 경우는 '데이터 타입이 안전하지 않다.' 라고 한다.
```
class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person{
    public Object info;
    Person(Object info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person("부장");
        EmployeeInfo ei = (EmployeeInfo)p1.info;
        System.out.println(ei.rank);
    }
}
```
### 다음과 같이 int 를 출력해야 하는데, String 으로 되어 있다.
### 이러한 경우를 피하기 위해 데이터 타입을 뭘로 써야 할지 명시해줘야 하는데, 이 때 제네릭을 사용한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/52197fc5-9a77-4708-8354-009f1608063e)
### <br/>

### 제네릭은 참조 데이터 타입에 대해서만 사용할 수 있다. 기본 데이터 타입에서는 사용할 수 없다.
### 예를 들어 아래와 같이 바로 1 을 사용할 수 없다.
```
Person<EmployeeInfo, int> p1 = new Person<EmployeeInfo, int>(new EmployeeInfo(1), 1);
```
### 대신에 참조 데이터 타입 형태로 선언해준 후 넣어줄 수 있다.
### generic_ex.java 참고
```
Integer i = new Integer(10);
Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
```
### <br/>

## 제네릭의 생략
### 제네릭의 명시는 생략할 수 있다.
```
// 이것을
Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
// 이렇게 생략 가능하다.
Person p2 = new Person(e, i);
```
### <br/>

## 제네릭의 제한
### 제네릭은 데이터 타입은 인스턴스를 생성할 때 지정해줄 수 있다는 장점이 있지만, 아무 데이터 타입을 허용해준다는 의미도 된다.
### 그래서 이러한 것을 강제할 수 있다.
### extends 를 사용해서 강제할 수 있다.
### abstract 로 해도 되고...
```
abstract class Info{
    public abstract int getLevel();
}
class EmployeeInfo extends Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person(new EmployeeInfo(1));
        Person<String> p2 = new Person<String>("부장");
    }
}
```

### interface 로 해도 된다.
```
interface Info{
    int getLevel();
}
class EmployeeInfo implements Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person p1 = new Person(new EmployeeInfo(1));
        Person<String> p2 = new Person<String>("부장");
    }
}
```
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/2d42254f-f67d-48cb-bb1d-b916c29f0afd)
