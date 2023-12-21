### 231221
## 인터페이스
### abstract, final 과 같이 규제의 역할을 한다.
### 클래스 안에 메쏘드들이 abstract 와 같이 정의되어 있고, 이렇게 정의된 메쏘드들을 정의하도록 강제한다.
```
package org.opentutorials.javatutorials.interfaces.example1;
 
interface I{
    public void z();
}
 
class A implements I{
    public void z(){}
}
```
### <br/><br/>

### 무언가 프로젝트를 진행할 때 무엇을 개발해야 할지 '기획'을 해야 한다.
### 그 기획 단계라고 보면 된다.
### 그리고 먼저 개발한 프로덕트 A 와 나중에 개발되는 B 가 있을 때, B 는 무엇을 개발해야 할지 혼동이 있을 수 있다.
### 이런 경우 어떤 것을 개발해야 할지 보여주는 것을 인터페이스가 그 역할을 해준다.
### 그래서 인터페이스는 그 '소통' 의 역할을 한다.
### <br/>

### 인터페이스에 있는 메쏘드는 꼭 public 이어야 한다.
```
public interface Calculatable {
    public void setOprands(int first, int second, int third) ;
    public int sum(); 
    public int avg();
}
```
### <br/>

