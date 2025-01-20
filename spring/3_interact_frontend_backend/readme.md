## front-end에서 back-end와 상호작용하기
### html 페이지 하나 만든다.
### 이제 index.html이 생성되었으니 localhost:8080에서 에러 페이지는 안 나올 것이다.
### `index.html`
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Button Interaction</title>
</head>
<body>
    <button id="myButton">Click me</button>

    <script>
        // 버튼 클릭 시 처리할 함수
        document.getElementById('myButton').addEventListener('click', function() {
            fetch('http://localhost:8080/api/greet')  // 백엔드 URL로 GET 요청
                .then(response => response.json())  // 응답을 JSON으로 변환
                .then(data => {
                    console.log(data.message);  // 백엔드에서 받은 메시지를 콘솔에 출력
                })
                .catch(error => {
                    console.error('Error:', error);  // 에러가 발생하면 콘솔에 출력
                });
        });
    </script>
</body>
</html>
```
#### ![image](https://github.com/user-attachments/assets/c7e78615-668d-4140-9a27-b02c3f688796)
### <br/>

### controller 하나 더 생성한다.
### 실제로 상호작용이 되고 있는 건지 확인하기 위해 브라우저랑 이클립스 콘솔 둘 다에서 출력이 되는지 확인해보았다.
### `GreetController.java`
```
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/api/greet")
    public Response greet() {
        // 백엔드에서 처리되는 부분에서 로그를 이클립스 콘솔에 출력
        System.out.println("Received request at /api/greet");  // 이클립스 콘솔에 출력
        
        // 응답 객체 반환
        return new Response("Hello from the backend!");
    }
    
    // 응답 객체 정의
    public static class Response {
        private String message;

        // init. class 호출 시 호출된다. 
        public Response(String message) {
            this.message = message;
        }

        // GET
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
```
#### ![image](https://github.com/user-attachments/assets/aa6c969b-3e60-4f50-bc7a-fa64e1392451)
### <br/>

### 버튼을 클릭하면 브라우저와 이클립스 콘솔 둘 다에서 출력이 된다.

https://github.com/user-attachments/assets/082308ea-c63d-4808-ba5b-a6d737c74a8e

