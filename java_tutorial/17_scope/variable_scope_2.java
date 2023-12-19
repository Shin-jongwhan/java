class C {
    int v = 10;
 
    void m() {
        int v = 20;
        System.out.println(v);      // 이 메쏘드의 지역 변수 출력

        System.out.println(this.v);     // 클래스 변수 출력
    }
}


public class variable_scope_2 {
    public static void main(String[] args) {
        C c1 = new C();
        c1.m();
    }
}
