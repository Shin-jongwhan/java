## Spring project
### Explorer에서 new - prject 생성을 누르면 spring 관련한 항목이 추가되어 있다.
#### ![image](https://github.com/user-attachments/assets/d79f7492-4100-408b-9190-1aa83cf4f797)
#### ![image](https://github.com/user-attachments/assets/67a66fa8-59a7-4932-bf23-1b4463ec7c84)
### <br/>

### java version을 한 번 체크해본다. 버전이 맞아야 에러가 나지 않는다.
```
java --version
```
#### ![image](https://github.com/user-attachments/assets/9fce8e92-ed22-48cb-a15c-1e54d3fa5a20)
#### ![image](https://github.com/user-attachments/assets/0ba0fa56-84ec-485e-a1f1-d2d910e44e7a)
### <br/>

### Run을 해보자. 그럼 console에 이렇게 출력될 건데, 8080으로 켜졌다고 한다.
#### ![image](https://github.com/user-attachments/assets/f8a86e12-4e8c-46ad-9ff7-bfd2eb170292)
#### ![image](https://github.com/user-attachments/assets/46e84062-4aac-4162-9c21-1807ac4a7b74)
### <br/>

### localhost:8080으로 접속해보자.
### 처음 페이지에는 아무것도 쓰지 않아서 이런 에러 페이지가 나온다. 정상이다.
#### ![image](https://github.com/user-attachments/assets/de62279a-1f97-4910-97f6-75375d588a08)
### <br/>

### 이제 controller라는 걸 만들어보자.
### 아래는 /home 경로를 만든 것이다.
```
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page!";
    }
}
```
#### ![image](https://github.com/user-attachments/assets/42f11183-5a7f-49e9-8dae-010fce6531c9)
### <br/>

### /home으로 이동하면 다음과 같이 나온다.
#### ![image](https://github.com/user-attachments/assets/6de4514a-131c-4d36-b3d8-3eacbb082a48)
