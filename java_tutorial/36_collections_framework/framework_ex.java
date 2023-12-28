import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class framework_ex {
    public static void main(String[] args) {
        // HashSet
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        Iterator hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }
        
        // 이미 마지막에 도달하였기 때문에 첫 실행에서 false 
        // 다시 하려면 초기화 해야 함
        // hi = A.iterator();
        while(hi.hasNext()) {
            System.out.println(hi.next());
        }

        ////////////////////////////////////////////////////
        // ArrayList
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);

        Iterator hi_B = B.iterator();
        while(hi_B.hasNext()) {
            System.out.println(hi_B.next());
        }

        ////////////////////////////////////////////////////
        // Collection
        // Collection 은 인터페이스이고 HashSet, ArrayList 의 부모이다.
        // Collection 에는 add, remove, Iterator 메쏘드가 포함되어 있다.
        // 그래서 호출이 가능하다.
        // 또한 부모 인터페이스로 구현되어 있기 때문에 Collection 으로 호출해도 된다.
        Collection<Integer> C = new ArrayList<Integer>();
        C.add(1);
        C.add(2);
        C.add(3);

        Iterator hi_C = C.iterator();
        while(hi_C.hasNext()) {
            System.out.println(hi_C.next());
        }
    }
}
