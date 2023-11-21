# 비교 연산자

```==``` :  왼쪽의 피연산자와 오른쪽 피연산자가 같으면 참, 다르면 거짓을 반환한다.  
```!=```  : 왼쪽의 피연산자와 오른쪽 피연산자가 다르면 참, 참이면 거짓을 반환한다.  
```>``` : 왼쪽의 피연산자가 오른쪽 피연산자보다 크면 참, 작거나 같으면 거짓을 반환한다.  
```>=``` : 왼쪽의 피연산자가 오른쪽 피연산자보다 크거나 같으면 참, 작으면 거짓을 반환한다.  
```<```  : 왼쪽의 피연산자가 오른쪽 피연산자보다 작으면 참, 크거나 같으면 거짓을 반환한다.  
```<=```  : 왼쪽의 피연산자가 오른쪽 피연산자보다 작거나 같으면 참, 크면 거짓을 반환한다.


```java
int small1 = 10;
int small2 = 10;
int big = 21;


System.out.println(small1 == small2);  // ( 10 == 10 ) true 
System.out.println(small1 == big);     // ( 10 == 21 ) false
System.out.println(small1 != small2);  // ( 10 != 10 ) false
System.out.println(small1 != big);     // ( 10 != 21 ) true
System.out.println(small1 > big);      // ( 10 > 21 ) false
System.out.println(small1 >= big);     // ( 10 >= 21 ) false
System.out.println(small1 >= small2);  // ( 10 >= 10 ) true
System.out.println(small1 < big);      // ( 10 < 21 ) true
System.out.println(small1 <= big);     // ( 10 <= 21 )true
System.out.println(small1 <= small2);  // ( 10 <= 10 )true

```