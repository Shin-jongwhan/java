## connect DB
### dependencies 설치, html, javascript에서 호출할 버튼, db 연결, sql 호출하면 된다.
### <br/>

### 먼저 build.gradle에 dependencies 추가
```
dependencies {
	  // JDBC Starter 의존성 (Spring Boot JDBC 지원)
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'

    // MySQL 드라이버 의존성
    implementation 'mysql:mysql-connector-java:8.0.29'
}
```
#### ![image](https://github.com/user-attachments/assets/bfc05217-6e67-49f3-aec0-30bd3f3d8e91)
### <br/>

### index.html을 수정한다. 
```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Button Interaction</title>
</head>
<body>
    <button id="myButton">Click me (Greet)</button>
    <button id="dbButton">Click me (DB Query)</button>

    <script>
        // 첫 번째 버튼 클릭 시 처리
        document.getElementById('myButton').addEventListener('click', function() {
            fetch('http://localhost:8080/api/greet')  // 백엔드 URL로 GET 요청
                .then(response => response.json())  // 응답을 JSON으로 변환
                .then(data => {
                    console.log('Response from backend:', data.message);  // 백엔드에서 받은 메시지를 콘솔에 출력
                })
                .catch(error => {
                    console.error('Error:', error);  // 에러가 발생하면 콘솔에 출력
                });
        });

        // 두 번째 버튼 클릭 시 DB에서 데이터를 호출하는 요청
        document.getElementById('dbButton').addEventListener('click', function() {
            fetch('http://localhost:8080/api/db-query')  // DB 쿼리 요청 URL
                .then(response => response.json())  // 응답을 JSON으로 변환
                .then(data => {
                    console.log('DB Response:', data);  // DB에서 받은 응답을 콘솔에 출력
                })
                .catch(error => {
                    console.error('Error:', error);  // 에러가 발생하면 콘솔에 출력
                });
        });
    </script>
</body>
</html>
```
### <br/>

### DB 연결
### application.properties에 DB 연결 정보를 추가한다. ip, port, db_name, user, password는 자신의 db에 맞게 수정한다.
```
# 데이터베이스 연결 정보
spring.datasource.url=jdbc:mysql://<ip>:<port>/<db_name>
spring.datasource.username=<user>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.maximum-pool-size=10
```
#### ![image](https://github.com/user-attachments/assets/7ef5451b-98a4-4a85-a6b6-87e4a861a468)
### <br/>

### DBController.java를 새로 작성한다.
```
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/api/db-query")
    public Object executeQuery() {
    	System.out.println("Received request at /api/db-query");
        String sql = "select * from analysis_log limit 1";  // 여기에 쿼리를 넣으세요
        
        // 예시: 쿼리 실행 및 결과 가져오기
        try {
            // 데이터베이스에서 결과 조회 (실제 SQL을 작성하세요)
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            return "Error: " + e.getMessage();  // 오류 발생 시 메시지 반환
        }
    }
}

```
### <br/>

### 새로운 dependencies를 추가하기 위해 import를 눌러야 한다. 그리고 root proejct directory는 project 최상위 경로를 넣으면 된다. 그리고 next 쭉 누르면 끝난다.
#### ![image](https://github.com/user-attachments/assets/e8b261bb-5424-4681-a039-e6ea35829e82)
#### ![image](https://github.com/user-attachments/assets/334ca81e-65e7-4fef-a7f5-cb708ec59e0e)
#### ![image](https://github.com/user-attachments/assets/b6eea272-ec57-4955-b02c-4bdacc0b0506)
### <br/>

### DB 호출 테스트

https://github.com/user-attachments/assets/51c07c2b-6810-4a05-a1aa-cbdae25b242d


