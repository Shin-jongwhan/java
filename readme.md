# 221206
## java 학습 스타트 !!
### <br/><br/><br/>

## 생활코딩 - java 수업
### https://opentutorials.org/course/1223
### <br/><br/><br/>

## 언어 소개
### 1995 년에 제임스 고슬링과 그 동료들이 만들었다. 가전제품을 제어하기 위해 만들어졌다.
### SI (System Integration) - 정보, 소프트웨어, 시스템 통합 등에 많이 쓰인다.
### 모바일 플랫폼이 많이 성공하면서 java 언어가 더욱 중요해지고 있다.
### 자바는 처음 프로그래밍을 배우는 데에.. 좋은 언어는 아니다. 하지만 처음에 배우면 안 된다는 이야기는 아니다.
### C 를 사용하였다면 객체 지향 개념이 어려울 수 있고, C++ 을 사용하였다면 조금 더 쉽게 느껴질 수도 있다.
### 모바일을 만들어야 한다면 java 를 배워야 한다.
### 생활코딩은 실습을 너무 중시하면 전체적인 숲을 못 보기 때문에 전체적인 수업을 빠른 속도로 한 번 쭉 훑어보는 것도 좋을 것이라고 하였다.
### 학습은 신속하고 기민하게 먼저 하고, 실습은 천천히 자세하게 익혀가자.
### <br/><br/><br/>

## Java 설치(인트로)
### 소스 코드를 작성하는 것은 설계도를 만드는 것이다.
### java 프로그램의 동작
#### ![image](https://user-images.githubusercontent.com/62974484/205825074-4bcd2dce-9183-47ef-91a2-fcbfaf732777.png)
### 소스 코드는 가장 안쪽에 있고, 자바라는 프로그램이 그 소스 코드를 실행한다.
#### ![image](https://user-images.githubusercontent.com/62974484/205824825-77ac9af2-abd3-4842-8c58-67bf6dc1647c.png)
### <br/><br/>

### java 용어
- java SE (java platform, Standard Edition) : java 의 기본적인 문법의 구성을 정의한다. java virtual machine 을 만든다. JAVA SE 7 은 JDK 1.7 이라고도 부른다.
- java JDK (Java Development Kit) : java SE 표준안에 따라서 개발에 필요한 여러가지 필수적인 툴 모음이다. 개발에 있어서 필수 요소이다.
- java JRE (Java Runtime Environment) : java virtual machine 을 실행하는 박스에 해당한다. JRE 는 JDK 에 속하기 때문에 JDK 를 설치하면 JRE 는 자동적으로 포함된다. 반대로 JRE 를 설치하면 JDK 를 사용할 수 없다. 실제로 프로그램이 돌아가는 데에는 JRE 가 가장 중요하다.
- java JVM (Java Virtual Machine) : 가상 컴퓨터라고 생각하면 될 것 같다. 소스 코드는 이 위에서 돌아간다. 소스 코드는 JVM 안에서 돌아가는 것을 보장한다 라는 것이 가장 중요한 특징이다.
#### ![image](https://user-images.githubusercontent.com/62974484/205826029-17ef51d6-3ed5-4df4-92d3-051cf925cd5d.png)
#### ![image](https://user-images.githubusercontent.com/62974484/205826562-03b7417f-e8fa-430d-bd86-7ffff28845ec.png)
### <br/>
### 그외
- java EE : 기업용 java 개발 환경
- java ME : 모바일용 java 개발 환경
### <br/><br/><br/>

## java 설치 (리눅스)
### 자바의 공식적인 주인은 오라클이다.
### 자바는 openJDK, IBM 등 다른 곳에서도 개발 환경을 개발하고 있다. 이번에는 오라클 것으로 설치할 것이다.
### 내가 사용하는 conda 환경에는 open JDK 버전으로 설치가 되어 있다.
#### ![image](https://user-images.githubusercontent.com/62974484/205841569-b1c3b9e0-3f63-47c3-928c-deed4131bb22.png)
### <br/>

### 나는 `도커 컨테이너` 에서 작업을 할 것이다.
### docker hub
#### https://hub.docker.com/_/openjdk

### Docker file 베이스. 여기서 추가적으로 수정한다.
#### https://github.com/docker-library/openjdk/blob/c0ad2e3351d64a0cb01344b6eff945f5d68387c7/20/jdk/oraclelinux7/Dockerfile
```
#
# NOTE: THIS DOCKERFILE IS GENERATED VIA "apply-templates.sh"
#
# PLEASE DO NOT EDIT IT DIRECTLY.
#

FROM oraclelinux:7-slim

RUN set -eux; \
# https://unix.stackexchange.com/a/477127/153467
	yum install -y --setopt=skip_missing_names_on_install=False \
		gzip \
		tar \
		\
# jlink --strip-debug on 13+ needs objcopy: https://github.com/docker-library/openjdk/issues/351
# Error: java.io.IOException: Cannot run program "objcopy": error=2, No such file or directory
		binutils \
# java.lang.UnsatisfiedLinkError: /usr/java/openjdk-12/lib/libfontmanager.so: libfreetype.so.6: cannot open shared object file: No such file or directory
# https://github.com/docker-library/openjdk/pull/235#issuecomment-424466077
		freetype fontconfig \
	; \
	rm -rf /var/cache/yum

ENV JAVA_HOME /usr/java/openjdk-20
ENV PATH $JAVA_HOME/bin:$PATH

# Default to UTF-8 file.encoding
ENV LANG en_US.UTF-8

# https://jdk.java.net/
# >
# > Java Development Kit builds, from Oracle
# >
ENV JAVA_VERSION 20-ea+26

RUN set -eux; \
	\
	arch="$(objdump="$(command -v objdump)" && objdump --file-headers "$objdump" | awk -F '[:,]+[[:space:]]+' '$1 == "architecture" { print $2 }')"; \
	case "$arch" in \
		'i386:x86-64') \
			downloadUrl='https://download.java.net/java/early_access/jdk20/26/GPL/openjdk-20-ea+26_linux-x64_bin.tar.gz'; \
			downloadSha256='70075a76ed683898d8d71852394c88ab73d8665b15accfafa85dac3be5fbf87e'; \
			;; \
		'aarch64') \
			downloadUrl='https://download.java.net/java/early_access/jdk20/26/GPL/openjdk-20-ea+26_linux-aarch64_bin.tar.gz'; \
			downloadSha256='041c2b0e7b68e58376d8b03db365434ceecd65671de20af28e6c32f47ccde94a'; \
			;; \
		*) echo >&2 "error: unsupported architecture: '$arch'"; exit 1 ;; \
	esac; \
	\
	curl -fL -o openjdk.tgz "$downloadUrl"; \
	echo "$downloadSha256 *openjdk.tgz" | sha256sum --strict --check -; \
	\
	mkdir -p "$JAVA_HOME"; \
	tar --extract \
		--file openjdk.tgz \
		--directory "$JAVA_HOME" \
		--strip-components 1 \
		--no-same-owner \
	; \
	rm openjdk.tgz*; \
	\
	rm -rf "$JAVA_HOME/lib/security/cacerts"; \
# see "update-ca-trust" script which creates/maintains this cacerts bundle
	ln -sT /etc/pki/ca-trust/extracted/java/cacerts "$JAVA_HOME/lib/security/cacerts"; \
	\
# https://github.com/oracle/docker-images/blob/a56e0d1ed968ff669d2e2ba8a1483d0f3acc80c0/OracleJava/java-8/Dockerfile#L17-L19
	ln -sfT "$JAVA_HOME" /usr/java/default; \
	ln -sfT "$JAVA_HOME" /usr/java/latest; \
	for bin in "$JAVA_HOME/bin/"*; do \
		base="$(basename "$bin")"; \
		[ ! -e "/usr/bin/$base" ]; \
		alternatives --install "/usr/bin/$base" "$base" "$bin" 20000; \
	done; \
	\
# https://github.com/docker-library/openjdk/issues/212#issuecomment-420979840
# https://openjdk.java.net/jeps/341
	java -Xshare:dump; \
	\
# basic smoke test
	fileEncoding="$(echo 'System.out.println(System.getProperty("file.encoding"))' | jshell -s -)"; [ "$fileEncoding" = 'UTF-8' ]; rm -rf ~/.java; \
	javac --version; \
	java --version

# "jshell" is an interactive REPL for Java (see https://en.wikipedia.org/wiki/JShell)
# CMD ["jshell"]

```
### 추가한 Dockerfile 소스코드
### \# 이 Dockerfile 에서 echo 안에 묶여 있어도 에러가 나서 따로 빼준다.
```
# PS1 settings. split echo because of '#' error
RUN echo -e "# set variable identifying the chroot you work in (used in the prompt below)\n\
if [ -z \"\${debian_chroot:-}\" ] && [ -r /etc/debian_chroot ]; then\n\
    debian_chroot=\$(cat /etc/debian_chroot)\n\
fi\n" \
>> ~/.bashrc
RUN echo -e "# set a fancy prompt (non-color, unless we know we \"want\" color)\n\
case \"\$TERM\" in\n\
    xterm-color|*-256color) color_prompt=yes;;\n\
esac\n" \
>> ~/.bashrc
RUN echo -e "# uncomment for a colored prompt, if the terminal has the capability; turned" >> ~/.bashrc
RUN echo -e "# off by default to not distract the user: the focus in a terminal window" >> ~/.bashrc
RUN echo -e "# should be on the output of commands, not on the prompt\n" >> ~/.bashrc
RUN echo -e "force_color_prompt=yes\n" >> ~/.bashrc
RUN echo -e "# We have color support; assume it's compliant with Ecma-48" >> ~/.bashrc
RUN echo -e "# (ISO/IEC-6429). (Lack of such support is extremely rare, and such" >> ~/.bashrc
RUN echo -e "# (ISO/IEC-6429). (Lack of such support is extremely rare, and such" >> ~/.bashrc
RUN echo -e "if [ -n \"\$force_color_prompt\" ]; then\n\
    if [ -x /usr/bin/tput ] && tput setaf 1 >&/dev/null; then\n\
    color_prompt=yes\n\
    else\n\
    color_prompt=\n\
    fi\n\
fi\n\
\n\
if [ \"\$color_prompt\" = yes ]; then\n\
    PS1='\${debian_chroot:+(\$debian_chroot)}\[\\033[01;32m\]\u@\h\[\\033[00m\]:\[\\033[01;36m\]\w\[\\033[00m\]\n\[\\033[01;33m\]$\[\\033[00m\] '\n\
else\n\
    PS1='\${debian_chroot:+(\$debian_chroot)}\u@\h:\w\\\$ '\n\
fi\n\
unset color_prompt force_color_prompt\n" \
>> ~/.bashrc
RUN echo -e "# If this is an xterm set the title to user@host:dir\n\
case \"\$TERM\" in\n\
xterm*|rxvt*)\n\
    PS1=\"\[\\e]0;\${debian_chroot:+(\$debian_chroot)}\u@\h: \w\\a\]\$PS1\"\n\
    ;;\n\
*)\n\
    ;;\n\
esac\n" \
>> ~/.bashrc
# alias
RUN echo -e "alias ls=\"ls --color=auto\"\n\
alias ll=\"ls -alF --color=auto\"\n\
alias vi=\"vim\"" \
>> ~/.bashrc
# .vimrc
RUN echo -e "set nu\n\
set ai\n\
set si\n\
set cindent\n\
set sts=4\n\
set ts=4\n\
set shiftwidth=4\n\
set wmnu\n\
set laststatus=2\n\
set ignorecase\n\
set hlsearch\n\
set nocompatible\n\
set ruler\n\
set fileencodings=utf-8,euc-kr\n\
set fencs=ucs-bom,utf-8,euc-kr\n\
set showmatch\n\
syntax on\n\
filetype indent on\n\
set bs=indent,eol,start\n\
set title\n\
color evening\n" \
> ~/.vimrc
RUN source ~/.bashrc
CMD ["bash"]
```
### <br/><br/>

### docker 접속
```
$ docker run -it -v /TBI/People/tbi/jhshin/script/docker/java/java:/root/project shinejh0528/java:latest
```
### hello world, java 실행 테스트
#### hello_world.java
```
class Helloworld {
    public static void main(String[] args){
        System.out.println("Hello world");
    }
}
```
### 컴파일
#### .java 파일을 바이트코드로 컴파일해주는 작업니다.
```
$ javac hello_world.java
```
### 실행
#### * 주의해야할 것은 뒤에 확장자 .class 를 빼고 실행한다.
```
$ java Helloworld
```
### 실행 결과
#### ![image](https://user-images.githubusercontent.com/62974484/205968657-d9d1cd9b-2da3-4fb6-8763-a20aa96b18cc.png)
#### ![image](https://user-images.githubusercontent.com/62974484/205968750-c1a8e08d-2ac0-44a5-b805-1effef1fc5e9.png)
### <br/><br/><br/>

## 개발도구와 이클립스
### 개발도구는 왜 써야 할까?
#### 땅은 손, 삽, 굴삭기 모두가 팔 수 있고 본질적인 기능은 같다.
#### 도구라는 것은 기능을 좀 더 쉽고 효율적으로 할 수 있게 만들어주는 것이다.
#### 개발 도구도 똑같다.
### <br/>

### 이클립스 (IDE)
#### IDE : 개발에 필요한 여러가지 도구들이 하나로 결합된 것. 파이썬 IDE 도 그런 기능 !
#### 소스 에디터, 컴파일러, 디버거, 실행까지 가능한 도구이다.
### 설치 방법
### http://www.eclipse.org/downloads/
### 이클립스 IDE 에서 Download Packages 를 선택
#### ![image](https://user-images.githubusercontent.com/62974484/210907534-ca4e619d-5440-480e-b0e4-76ad328e021f.png)
### 가장 위에 있는 installer 선택
#### ![image](https://user-images.githubusercontent.com/62974484/210907782-9bc492e7-9e6d-461a-9ca3-f167e8e48388.png)
### >> Select Another Mirror 를 클릭하고 가까운 KAIST 를 선택해서 다운로드
### ![image](https://user-images.githubusercontent.com/62974484/210907866-2ea6b61d-c2b9-47af-a118-43a5a41301ba.png)
### <br/>

### 이클립스로 리눅스 remote server 접속하기
### remote system explorer 를 이용하면 리눅스 서버로 접속할 수 있다.
### 다음의 사이트를 참고하였다.
- https://m.blog.naver.com/david_shkim/221825689740
- https://blog.naver.com/hang_sun/130088174568
### <br/>

### 폴더를 나누는 기준은 다음과 같다
- bin : .class 파일이 있는 binary 폴더
- src : .java 파일이 있는 source 폴더
#### ![image](https://github.com/Shin-jongwhan/java/assets/62974484/a95180fe-78d0-4cdb-a78e-b1e295d5a345)
### <br/><br/><br/>

## java 개발 시 알아두어야 할 점 (+ 이클립스)
### java 의 프로젝트는 다음과 같은 hierachy 로 만들어진다.
- project
  - package
    - class
### <br/>

### package 명은 도메인 네임 형식으로 만든다. 그렇게 해야만 package 가 만들어지는 것은 아니지만, 도메인 네임은 유니크한 주소이기 때문에 도메인 네임 형식을 따르자고 개발자들끼리 정하였다.
### 그리고 도메인 네임으로 쓴 각 '.' 사이사이 이름들은 폴더로 구분된다.
### ex) org.opentutorials.javatutorials.eclips
### 만약 다음과 같이 되었다면 폴더 구조는 이렇게 된다.
- project : javatutorials
- package : org.opentutorials.javatutorials.eclips
- script name : Helloworld
- folder
  - javatutorials/bin/org/opentutorials/javatutorials/eclips/Helloworld.class
  - javatutorials/src/org/opentutorials/javatutorials/eclips/Helloworld.java
### <br/>

### 이클립스를 이용하면 프로젝트, 패키지, 소스코드를 bin, src 로 구분하여 저장해준다.
### 또한 javac 를 이용하여 별도의 컴파일 과정을 거치지 않고 실행 버튼만 누르면 자동 컴파일과 함께 실행을 해준다.
### <br/><br/><br/>




