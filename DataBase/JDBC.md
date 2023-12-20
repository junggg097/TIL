# JDBC 사용법

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
# Statement & ResultSet

### JDBC

Java에서 직접적으로 사용하는 건 JDBC API.
- JDBC 는 데이터 베이스와 소통하기 위한 드라이버가 필요하다.
- 드라이버를 관리해주는 클래스가 DriverManager

## Statement
SQL 을 전달하는데 사용할 수 있다 !
- DriverManager 한테 받은 Connection 객체를 활용
- execute() 메서드로 SQL 쿼리 실행
```java
    // 1. 어떤 데이터베이스에 연결할지를 String로 작성
    String connectionString = "jdbc:sqlite:db.sqlite";
    
    
    // 2. 해당 데이터베이스에 연결
    try (Connection connection = DriverManager.getConnection(connectionString)) {
        System.out.println("Connection Success ! ");
        
        // 3. 데이터 베이스 연결 객체로부터 Statement 객체를 받는다.
        Statement statement = connection.createStatement();
        // 4. execute 를 이용해 간단한 SQL 문을 사용한다.
        statement.execute("""
        CREATE TABLE user(
            id INTEGER PRIMARY KEY AUTOINCREMENT
        );
        """);
    } catch (SQLException e) {
        System.out.println(e.getErrorCode());
        System.out.println(e.getMessage());
        throw new RuntimeException(e);
    }
```

```java
// Update
String updateSql = """
    UPDATE user
    SET first_name = 'dukong'
    WHERE id = 1;
""";
// executeUpdate 는 내가 실행한 SQL문의 결과로 바뀐 줄의 갯수를 반환한다.
int rows = statement.executeUpdate(updateSql);
System.out.println("rows affected : " + rows);

```

## ResultSet
SELECT의 결과를 ResultSet 객체로 반환
- `next()` : 결과 테이블의 다음 줄로
- `get{type}()` : type형으로 컬럼 데이터를 회수하기 위해 사용

```java
// Select
String selectSql = """
SELECT * FROM user WHERE id = 1;
""";
// 조회하는 쿼리는 ResultSet으로 데이터를 받는다.
// ResultSet은 결과 테이블을 살펴볼 수 있게 도와주는 interface
ResultSet resultSet = statement.executeQuery(selectSql);
if (resultSet.next()){
    System.out.println(resultSet.getString("username"));
    System.out.println(resultSet.getString("first_name"));
    System.out.println(resultSet.getString("email"));
}
// 다음 줄이 없으면 next() 는 false 반환
else {
    System.out.println("Could not find");
}
```
