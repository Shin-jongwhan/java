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
