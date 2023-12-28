import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class collection_set_ex {
    public static void main(String[] args) {
        // ArrayList 로 추가하는 경우
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        System.out.println("-----array-----");
        Iterator ai = al.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }
        
        // HashSet 으로 추가하는 경우
        HashSet<String> hs = new HashSet<String>();
        hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        Iterator hi = hs.iterator();
        System.out.println("\n-----hashset-----");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
}
