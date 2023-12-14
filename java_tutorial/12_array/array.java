//package 12_array;

public class array {
    public static void main(String[] args) {
        /*
         * 배열
         * 데이터를 여러개의 변수를 담은 변수
         */ 
        
        // String 배열 선언
        // 배열 크기 미지정(동적 할당)한 경우
        // 4 byte 크기만큼, 약 20억 정도의 변수가 들어갈 수 있다.
        String[] arStr = {"a", "b", "c"};

        System.out.println(arStr);
        // arStr.length = 3
        for (int i = 0; i < arStr.length; i++) {
            System.out.println(arStr[i]);
        }

        // for each
        // for each 는 반복문에 들어 있는 각 변수를 넣어준다.
        // 위에서 값을 초기화하고, 언제 빠져나오고, 값을 변화시키고 이러한 과정을 간결과한 것이다.
        System.out.println("\nfor each");
        // i 에 arStr[0], arStr[1] ... 이 하나씩 반복문에서 들어간다.
        for (String i : arStr) {
            System.out.println(i);
        }
        
        // 참고 1
        // 다음과 같이 배열의 길이를 초과하는 인덱스로 조회하는 경우 에러가 난다.
        // System.out.println(arStr[3]);
        
        // 참고 2
        // 배열의 길이를 초과해서 선언을 하는 것도 에러가 난다.
        String[] arrStr_2 = new String[3];      // 길이가 3인 배열 선언
        arrStr_2[0] = "a";
        arrStr_2[1] = "b";
        arrStr_2[2] = "c";
        //arrStr_2[3] = "d";      // 배열의 길이를 초과하기 때문에 에러
    }
}
