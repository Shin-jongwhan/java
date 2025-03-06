## vs code
### 요즘에는 이클립스보다 vs code 로 이동하는 추세이다.
### 둘 다 써봤는데, remote server 접속이나 실행, 환경 설정 등에서도 vs code 가 편한 것 같다.
### <br/>

### remote 로 접속하고, vs code 로 java 를 실행하려면 ctrl + shift + p 를 누른 후 java 를 입력하고 아래 창과 같이 선택한다.
### 그리고 remote 에서 java 프로젝트가 있는 경로를 선택한다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/c17cd827-ccc2-4b1b-acc2-f3a34271ce1d)
### 그리고 F5 를 누르면 실행된다.
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/bdfa4f1f-2da2-47cc-9d7e-08a2d871850e)
### <br/><br/><br>

### main java 스크립트를 클릭하고 F5를 누르면 실행이 된다.
#### ![image](https://github.com/user-attachments/assets/889059fe-2408-4bb7-854d-021f29edfd22)
#### ![image](https://github.com/user-attachments/assets/e1677f07-7351-4d52-9ec2-541f3ab3f7cc)
### <br/>

### vscode 최상단 폴더에 .vscode/launch.json이라는 파일이 하나 생성 되는데, 여기에 args 등 실행에 필요한 설정을 할 수 있다.
### 그래서 'open folder' 할 때에는 .gradle/ 등이 있는 폴더를 root folder로 지정하여 여는 것이 편하다.
### 아래에서는 profiles라는 파라미터에 dev라는 값을 설정하였다. 나머지는 기본으로 자동으로 세팅된 것이다.
#### ![image](https://github.com/user-attachments/assets/2ac6633b-d856-4625-be44-af1a4fbc12ad)

### <br/><br/><br>

## build 방법
### 환경 변수에 들어가서 build 하는 JDK 버전이 맞아야 한다.
#### 내가 하는 프로젝트는 gradle이 JDK 17을 요구하고 있어서 JDK 17을 설치해주었다.
### C:\Program Files\Java 경로를 확인해보면 다음과 같이 있다.
#### ![image](https://github.com/user-attachments/assets/4295472b-8bfb-4e75-ae88-ff50fcf94a14)
#### ![image](https://github.com/user-attachments/assets/96e68009-2adf-4e37-92eb-40a528f50ef5)
### <br/>

### 환경 변수를 설정하고 vs code를 다시 실행한다.
### JDK 버전이 맞으면 extention을 인식해서 사이드바에 gradle 버튼이 보이고, build 버튼을 누르면 build를 진행한다.
#### ![image](https://github.com/user-attachments/assets/40010b02-1c1f-44b9-ab24-5a553b7aa571)
### 또는 다음의 명령어로 build 할 수 있다.
```
.\gradlew clean build
```
