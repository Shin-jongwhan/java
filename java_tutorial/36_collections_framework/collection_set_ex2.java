import java.util.HashSet;
 
import java.util.Iterator;

public class collection_set_ex2 {
    public static void main(String[] args) {
        HashSet<Integer> A = new HashSet<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
         
        HashSet<Integer> B = new HashSet<Integer>();
        B.add(3);
        B.add(4);
        B.add(5);
         
        HashSet<Integer> C = new HashSet<Integer>();
        C.add(1);
        C.add(2);
        
        // 부분집합 체크
        System.out.println(A.containsAll(B)); // false
        System.out.println(A.containsAll(C)); // true
        
        // 합집합
        HashSet<Integer> AB = new HashSet<Integer>();
        AB.addAll(A);
        AB.addAll(B);
        System.out.println("AB union : " + AB);
        
        // 교집합
        HashSet AB_inter = new HashSet(A);
        AB_inter.retainAll(B);
        System.out.println("AB intersect : " + AB_inter);

        // 차집합
        HashSet AB_diff = new HashSet(A);
        AB_diff.removeAll(B);
        System.out.println("AB difference : " + AB_diff);

        Iterator hi = A.iterator();
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
}
