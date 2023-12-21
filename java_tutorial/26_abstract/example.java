//package 26_abstract;

/*
 * abstract
 * 클래스가 abstract class 형식으로 선언되어 있는 경우,
 * 그 클래스를 상속 받아서 쓸 때에는 먼저 abstract 메쏘드를 overriding 해서 사용해야 한다.
 * abstract 를 선언하는 것은 return 값을 명시하고 메쏘드처럼 선언하는데,
 * {
 *     System.out.println("test");
 * };
 * 와 같은 형식이 없다. 
 * 그냥 public abstract int b(); 이렇게만 선언한다.
 */

abstract class A{
    public abstract int b();
    public void d(){
        System.out.println("world");
    }
}
class B extends A{
    public int b(){return 1;}
}


public class example {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj.b());
    }
}
