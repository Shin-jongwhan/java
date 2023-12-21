### 231221
## exception2
### throws
### 메쏘드의 사용자에게 exception 에 대한 에러처리를 맡기는 것.
### 메쏘드를 선언할 때, 어떤 어떤 exception 을 맡길지 명시한다.
```
class B{
    // IOException, FileNotFoundException 을 throws 
    void run() throws IOException, FileNotFoundException{
        BufferedReader bReader = null;
        String input = null;
        bReader = new BufferedReader(new FileReader("31_exception/out.txt"));
        input = bReader.readLine();
        System.out.println(input); 
    }
}
class C{
    void run(){
        B b = new B();
        // run() 을 사용할 때 IOException, FileNotFoundException 에 대해 exception 을 만들어줘야 에러가 안 난다.
        try {
            b.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### <br/>



