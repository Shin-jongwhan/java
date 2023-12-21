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
