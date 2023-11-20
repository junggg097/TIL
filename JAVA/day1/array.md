# 배열

**하나의 변수에 여러 데이터** 를 저장하기 위해 주로 활용

```java
        int[] scores = {85, 75, 90};

        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);
```
배열은 변수를 선언할 때, 자료형 뒤에 [] 를 덧붙이면 배열이 만들어지고, 그 뒤 {} 를 이용해 저장할 복수의 값을 넣어준다.  
이렇게 저장된 데이터는 다시 <변수명>[] 를 이용해 가져온다.  
이때 [] 안에는 순서를 나타내는 0 이상의 정수가 들어간다.
  
기본적으로 첫번째 숫자는 **0** 에서부터 시작한다.

```java
    String[] names = new String[4];
    names[0] = "yujin";
    System.out.println(names[0]);
```
아직 배열에 들어갈 값이 정해지기 전이라면 , 배열의 크기가 얼마인지 먼저 결정할 수 있다.

```java
        int students = 10;
        String[] names = new String[students];
        int[] scores = new int[students];

```
만들고자 하는 배열의 크기를 변수로도 전달할 수 있다.