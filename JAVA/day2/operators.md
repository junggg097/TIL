# 산술 연산자 

흔히 하는 사칙연산, 즉 간단한 수학 연산을 하는 연산자 

```+``` :  왼쪽의 피연산자에서 오른쪽 피연산자를 더한 값을 반환한다.  
```-```  : 왼쪽의 피연산자에서 오른쪽 피연산자를 뺀 값을 반환한다.  
```*``` : 왼쪽의 피연산자에서 오른쪽 피연산자를 곱한 값을 반환한다.  
```/``` : 왼쪽의 피연산자에서 오른쪽 피연산자를 나눈 값을 반환한다.  
```%```  : 왼쪽의 피연산자에서 오른쪽 피연산자로 나눈 나머지를 반환한다. (모듈러)

## 형변환 ( Type Casting )
- 묵시적 형변환
    더 작은 자료형 -> 더 큰 자료형
    ```byte``` -> ```short``` -> ```int``` -> ```long``` -> ```float``` ->```double```
- 명시적 형변환
    더 큰 자료형 -> 작은 자료형
    ( 억지로 작은 공간의 자료형으로 옮기기 때문에 데이터 손실 우려)
    수동으로 변환해줘야 함
```java
    // 1. 데이터를 받는 애를 int가 아니라 double로 해보자.
    double doubleDivide = 21 / 10;
    System.out.println(doubleDivide);

    // 결과값 : 2.0
```


```java
    // 2. 나누기 전에 실수로 만들어 주자.
    // 피연산자 중 하나라도 double이면 결과도 double
    doubleDivide = 21 / 10.0;
    System.out.println(doubleDivide);
    
    // 결과값 : 2.1
```
  
```java
    // 피연산자 둘다 정수 변수면?
    // 형변환(Type Casting)
    int intResult = (int) 2.1;
    
    System.out.println(intResult);
    // 결과값 : 2
```
  
```java
    // 선 변환을 통한 나누기 연산
    int left = 21;
    int right = 10;
    double castedResult = (double) left / right;
    System.out.println(castedResult);
    
    // 결과값 : 2.1
```
  
```java
    // 명시적 형변환 데이터 손실
    long bigInt = 4294967296L;
    System.out.println((int) bigInt);
    
    // 결과값 : 0
```

## char 형 변환

```java
    int asciiA = 65;
    System.out.println((char) asciiA);
    System.out.println((char) (asciiA + 10));
    
    // 결과값 : A
    // 결과값 : K
```
  
```java
    // String 덧셈
    // String Concatenation
    System.out.println("여기에 10을 입력하시오: " +10);
    System.out.println(10 + "+" + 10 + "=" + 20);
    String formula = 10 + " + " + 10 + "=" + 20;
    
    char largeA = 'A';
    char ten = 10;
    System.out.println((char) (largeA + ten));
    
    /* 결과값
        여기에 10을 입력하시오: 10
        10+10=20
        K
     */

```
