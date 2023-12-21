//package 25_access_modifier;
// public, private 이 접근 제어자 (access modifier) 이다.

class A {
    public String y(){
        return "public void y()";
    }
    private String z(){
        return "public void z()";
    }
    public String x(){
        return z();
    }
}


public class example {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.y());

        // 아래 코드는 오류가 발생한다.
        //System.out.println(a.z());

        System.out.println(a.x());
    }
}
