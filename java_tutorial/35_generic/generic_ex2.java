class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T, S>{
    public T info;
    public S id;
    Person(T info, S id){ 
        this.info = info;
        this.id = id;
    }
    public <U> void printInfo(U info){
        System.out.println(info);
    }
}


public class generic_ex2 {
    public static void main(String[] args) {
        EmployeeInfo e = new EmployeeInfo(1);
        Integer i = new Integer(10);

        // 제네릭을 쓴 형태를
        Person<EmployeeInfo, Integer> p1 = new Person<EmployeeInfo, Integer>(e, i);
        // 이렇게 생략할 수 있다.
        Person p2 = new Person(e, i);

        // 제네릭을 쓴 형태를
        p1.<EmployeeInfo>printInfo(e);
        // 이렇게 생략할 수 있다.
        p1.printInfo(e);
        p1.printInfo(i);
    }
}
