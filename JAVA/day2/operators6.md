# 비트 연산자

Java 데이터는 전부 비트로 표현할 수 있다.  
1 과 0 기준으로 두 숫자를 계산하는 연산이 가능 => 비트 연산
  
example)
```
11 -> 1011
05 -> 0101
```

```&``` : 두 수 각 자리의 비트가 둘 다 1 이면 결과 자리의 비트도 1 (AND 연산)  
```|```  : 두 수 각 자리의 비트가 둘 중 하나라도 1이면 결과 자리의 비트도 1(OR 연산)  
```^``` : 두 수 각 자리의 비트가 서로 다르면 결과 자리의 비트가 1(XOR 연산)  
```~``` : 각 자리의 비트를 1이면 0으로, 0이면 1로 (NOT 연산)  
```<<```  : 오른쪽 피연산자의 수만큼 비트를 왼쪽으로 이동(LEFT SHIFT 연산)  
```>>```  : 왼쪽 피연산자의 수만큼 비트를 오른쪽으로 이동,부호 변동 X (RIGHT SHIFT 연산)  
```>>>```  : 왼쪽 피연산자의 수만큼 비트를 오른쪽으로 이동,새로운 비트는 0 (RIGHT SHIFT 연산)

  

## AND 연산 ```&```
두 수 각 자리의 비트가 둘 다 1 이면 결과 자리의 비트도 1, 하나라도 0이면 0

```java
/*
    1011 = 11
AND 0101 = 5
--------
    0001 = 1
*/
System.out.println(11 & 5);  // 1
```

  
## OR 연산 ```|```
두 수 각 자리의 비트가 둘 중 하나라도 1이면 결과 자리의 비트도 1, 둘 다 0이면 0
```java
/*
    1011 = 11
OR  0101 = 5
--------
    1111 = 15
*/
System.out.println(11 | 5);  // 15
```
  
## XOR 연산 ```^```
각 자리의 비트를 비교해 둘의 자리 수가 다른 경우 1, 같은 경우 0
```java
/*
    1011 = 11
XOR 0101 = 5
--------
    1110 = 14
*/
System.out.println(11 ^ 5);  // 14
```
  
## NOT 연산 ```~```
하나의 숫자에 대해서, 비트가 0이면 1, 1이면 0 ( 기존 숫자의 반대로 )
```java
/*
NOT 0000 1011 = 1111 0100 = -12
NOT 0000 0101 = 1111 1010 = -6
*/
System.out.println(~11);  // -12
System.out.println(~5);   // -6
```
  
## SHIFT 연산 ```<<```, ```>>```,```>>>```
하나의 숫자의 비트를 주어진 숫자만큼 화살표 방향으로 이동하는 연산
```java
/*
0000 1011 SHIFT LEFT  2 = 0010 1100 = 44
0000 1011 SHIFT RIGHT 2 = 0000 0010 = 2
*/
System.out.println(11 << 2);  // 44
System.out.println(11 >> 2);  // 2

```

## 삼항 연산자

삼항 연산자는 하나의 조건에 대해서, 참인지 거짓인지에 따라 어떤 값이 될지를 결정  
불린형 변수 또는 데이터 뒤에 물음표 (?) 와 참일때의 값과 거짓일때의 값을 콜론 (:) 으로 연결

```java
int temperature = 37;
String message = temperature < 38 ? "OK" : "Feverish";

//결과값 : OK
// temperature < 38 -> true 이기 때문에 Ok 값이 출력된다.
// 만약 temperature < 38 -> false 라면 Feverish 가 출력된다.
```