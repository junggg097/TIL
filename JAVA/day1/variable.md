# 변수 (Variable)

변수 : 일종의 데이터를 담는 상자 !

```
int a = 50;
System.out.println(a);
String b = "Hello World!";
System.out.println(b);


실행값
50
Hello World

```

- 변수는 값(데이터)를 저장한다.
- = 는 할당 연산자이며 , 변수에 값을 대입할 때 사용할 수 있다.
- 변수는 <자료형> <이름> = <값>; 의 형태로 만든다.
  변수를 만드는 행위를 **변수를 선언한다** 고 한다.
- 선언된 변수는, 이후 저장된 값을 대신해 사용 가능하다.
- 이미 값이 할당된 변수에도 값을 다시 할당 할 수 있다.

```
int a = 50;
System.out.println(a);

a = 100;
System.out,println(b);

실행화면
50
100
```
- 값을 다시 재활용할 수 있다.

## 변수를 사용한 예제
```
        int americano = 1500;
        int cappuccino = 2500;
        int caffeLatee = 3000;
        int caffeMocha = 4000;
        // 아메리카노 5잔 가격 출력
        // 카푸치노 3잔 + 카페라떼 2잔 가격 출력
        // 카페모카 1잔 + 아메리카노 3잔 가격 출력
        System.out.println(americano * 5);
        System.out.println(cappuccino * 3 + caffeLatee * 2);
        System.out.println(caffeMocha + americano * 3);
```

- 가격은 변수 선언 시 한 번만 할당하기 때문에, 오타가 줆
- 어떤 메뉴를 주문했는 지 직관적으로 확인 가능
- 메뉴 가격이 변경되면, 변수 선언 부분만 수정해 사용 가능

```
        // 변수 선언
        int frappe;
        // 여기서 뭔가 한다 . . . 계산이라든지

        frappe = 10000;

        // 한 줄에 여러 변수 선언 및 할당
        int hotTea = 1000, iceTea = 1500;
```

이처럼 변수 선언하고 차후 값을 할당하거나 한 줄에 여러 개의 변수를 동시에 선언할 수 있다.

