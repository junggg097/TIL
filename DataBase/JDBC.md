# JDBC

- 데이터베이스는 파일의 형태로 데이터를 효율적으로 저장하기 위한 프로그램
- Java 가 데이터베이스와 소통할 수 있도록 해주는 API

### Build
Java Development Kit ( JDK )
- Java를 개발하기 위한 도구 모음집
- Java 언어를 Java Bytecode로 변환하는 **컴파일러 (javac)**

### Build Automation Tool

Gradle & Maven
- Build Automation Tool
- Java 프로젝트를 빌드하는데 사용되는 대표적인 도구
- 소스코드 컴파일, 단위 테스트 , 버전관리 , JAR 생성 . . .
- JAR 파일 : 배포를 위해 Java Class 를 부수 정보와 함께 압축하는 형태

### Dependency Management
프레임워크나 라이브러리(의존성)을 사용한다.
- 다른 개발자가 이미 만들어 놓은 것을 활용한다.
- 해당 라이브러리 코드도 우리가 가져와 설정해야 한다.
- Maven 과 Gradle 은 인터넷에 연결되어 있으면 , **라이브러리를 자동으로 가져온다.**

```build.gradle
dependencies {
    runtimeOnly '~~~'
    implementation '~~~'
    ...
}
```