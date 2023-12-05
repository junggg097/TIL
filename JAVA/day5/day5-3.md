# Wrapper Class

```int```,```char```,```boolean```과 같은 자료형은 클래스가 아닌 원시타입니다.  
객체지향적 관점에서 활용할 수 있도록 해주는 클래스는 "Wrapper class" 라 한다.
  
```java
// String.format 같은 다양한 기능이 내장되어 있다.
Integer parsedInt = Integer.parseInt("1024");
Double infinity = Double.POSITIVE_INFINITY;
System.out.println(Character.isLetter('a'));
System.out.println(Character.isDigit('1'));
```
  
```class```의 개념을 가지고 만들어진 참조 타입이지만 , 원시 타입 자료형을 사용하듯 활용 가능하다.
  
```java
// 그냥 값을 할당할 수 있고,
Integer intWrapper = 10;
Double doubleWrapper = 2.5;

// 사칙연산도 가능하며
Integer result = intWrapper + 25;
Double doubleResult = (double) intWrapper / 5;

// 서로 상호 호환도 된다!
long longPrimitive = 100000L;
Long longWrapper = longPrimitive;
longPrimitive = longWrapper * 2;
```  

## 유용한 메서드들
| 메서드                                | 기능                                 |
|------------------------------------|------------------------------------|
| `Integer.parseInt(String s)`       | 문자열이 나타내는 정수를 반환한다.                |
| `Double.parseDouble(String s)`     | 문자열이 나타내는 실수를 반환한다.                |
| `Character.isDigit(char ch)`       | 문자가 숫자를 나타내는지 확인한다.                |
| `Character.isLetter(char ch)`      | 문자가 글자를 나타내는지 확인한다.                |
| `string.length()`                  | 문자열의 글자수를 반환한다.                    |
| `string.substring(int beginIndex)` | 문자열을 `beginIndex` 부터 자른 문자열을 반환한다. |
| `string.charAt(int index)`         | 문자열의 `index` 위치의 `char를` 반환한다.     |
| `string.indexOf(String str)`       | 주어진 문자열이 시작하는 `index를` 반환한다.       |
| `string.split(String regex)`       | 주어진 정규표현식을 기준으로 문자열을 나눠 배열로 반환한다.  |
