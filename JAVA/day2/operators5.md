# 논리 연산자

- 참, 거짓 데이터에 대해 조건을 확인하기 위한 연산자
- 복수의 조건을 만족하거나, 하나의 조건을 만족하는지 여부에 대하여 동시에 만족하는지를 확인할때 주로 활용


```&&``` :  왼쪽의 피연산자와 오른쪽 피연산자가 모두 참일 때 참, 아니면 거짓을 반환한다.  
```||```  : 왼쪽의 피연산자와 오른쪽 피연산자 중 하나라도 참일 때 참, 아니면 거짓을 반환한다.  
```!``` : 피연산자가 참이면 거짓, 거짓이면 참을 반환한다.  

```java

int temperature = 36;
int age = 24;

// 체온은 35 이하
boolean notSick = temperature <= 35;
// 나이는 24 이상
boolean isOfAge = age >= 24;
// 입장 가능한가?
boolean canEnter = notSick && isOfAge;
System.out.println(canEnter);

// 결과값 : false
// notStick = 36 <= 35; ->false
// isOfAge = 24 >= 24; -> true
// canEnter = false && true
// so ... canEnter = false
// 모두 참이지 않기 때문에 false 로 반환

```
복수 논리 연산자가 조합되어 있다면 !!  
```!```  → ```&&```  → ```||``` 순으로 진행된다.

```java
boolean a = true;
boolean b = false;
boolean c = false;

System.out.println(a && b || !c);      // true
System.out.println(a && b || a && c);  // false
System.out.println(c || b && a || c);  // false
```