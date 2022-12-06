# create at 221206
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
### `도커 컨테이너`
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
CMD ["jshell"]
```
### <br/><br/><br/>


