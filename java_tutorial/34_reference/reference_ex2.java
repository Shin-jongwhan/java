class A{
    public int id;
    A(int id){
        this.id = id;
    }
}


public class reference_ex2 {
    public static void runValue(){
        int a = 1;
        int b = a;
        b = 2;
        System.out.println("runValue, "+a);     // 1
    }
    

    public static void runReference(){
        A a = new A(1);
        A b = a;
        b.id = 2;
        System.out.println("runReference, "+a.id);      // 2
    }


    public static void main(String[] args) {
        runValue();
        runReference();
    }
}
