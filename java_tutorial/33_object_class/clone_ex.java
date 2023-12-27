
/*
 * Cloneable 인터페이스를 implements 해서 복제가 가능한 클래스라고 알려줘야 복제할 수 있다.
 * 하지만 Cloneable 인터페이스는 그냥 비어 있다.
 * 
    // Source code is decompiled from a .class file using FernFlower decompiler.
    package java.lang;

    public interface Cloneable {
    }
 * 
 * 그래서 복제를 하려면 복제하는 메쏘드를 만들어줘야 한다. 그게 .clone() 이다.
 * .clone() 은 protected 접근 제어자를 가지고 있는 메쏘드이다.
 * protected 는 서로 다른 패키지에서는 호출할 수 없다.
 * 하지만 서로 다른 패키지라고 할지라도 상속은 가능하다.
 */

// 1. implements Cloneable 로 복제 가능한 클래스라고 명시한다.
class Student implements Cloneable{
    String name;
    Student(String name){
        this.name = name;
    }

    // 2. implements Cloneable 는 비어 있는 인터페이스이기 때문에 복제 메쏘드를 따로 생성해줘야 한다.
    // 3. .clone() 은 throws CloneNotSupportedException 을 강제한다.
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}


public class clone_ex {
    public static void main(String[] args) {
        Student s1 = new Student("egoing");
        // 4. .clone() 은 throw 를 강제하기 때문에 try catch 구문을 써야 한다.
        try {
            //5. .clone() 이 Object return 하기 때문에 (Student) 로 명시해줘야 한다.
            Student s2 = (Student)s1.clone();
            System.out.println(s1.name);
            System.out.println(s2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
