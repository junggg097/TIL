# 자료형


## 정수 
- ```int``` - 정수형 데이터를 저장하는 자료형
- ```long``` - 큰 정수형 데이터를 저장하는 자료형

## 실수
- ```double``` - 실수형 데이터를 저장하는 자료형 (유효자리수 16)
- ```float``` - 실수형 데이터를 저장하는 자료형 (유효자리수 7)

## 문자
- ```char``` - 글자 데이터를 저장하는 자료형

## 문자열
- ```String``` - 문자형 데이터를 저장하는 자료형
- ```boolean``` - 참/거짓 데이터를 저장하는 자료형

```java

        int integer = 10;
        integer = -10;
        integer = 0;
        long longInteger = 100000000;
        short smallInteger =  10000;
        byte reallySmallInteger = 127;

        //실수형 자료형
        float floatPoint = 2.718F;
        // 거의 double 만 쓴다.
        double doublePoint = 3.14159265359;
        // 진짜 긴 소수는 ?
        double longPi = 3.14159265358979323846;
        System.out.println(longPi);

        // 불린형 자료형 ( 참 또는 거짓 )
        boolean success = false;
        boolean willSuccess = true;
        success = true;
        System.out.println(success);

        // 문자와 문자열
        char alphabet = 'a';
        char digit = '1';
        // char isString = "1"; // 한글자라고 해도 큰 따옴표는 문자가 아닌 문자열

        String world = "Hello";
        String sentence = "this is a String Variable";
```

