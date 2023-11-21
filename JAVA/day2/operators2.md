# 증감 연산자

어떤 작업을 반복하는 과정에서, 몇 번의 작업을 했는지를 파악하기 위해 값을 하나씩 증가시키거나 감소시키는 연산자

```++``` :  피연산자의 값을 1 증가  
```--```  : 피연산자의 값을 1 감소  

  
```java

    int count = 0;
    count++;
    System.out.println("현재 횟수 : " + count);
    count++;
    System.out.println("현재 횟수 : " + count);
    count--;
    System.out.println("현재 횟수 : " + count);
    ++count;
    --count;
    System.out.println("최종 " + count);
    
    /* 결과값
        현재 횟수 : 1
        현재 횟수 : 2
        현재 횟수 : 1
        최종 1
    */
```

피연산자의 앞, 뒤 에 붙을 경우 동작에 차이가 있다.  
```java

        count = 10;
        System.out.println(++count);  // 11 (출력 전에 1 증가, 값 11)
        System.out.println(count++);  // 11 (출력 후에 1 증가, 값 12)
        System.out.println(--count);  // 11 (출력 전에 1 감소, 값 11)
        System.out.println(count--);  // 11 (출력 후에 1 감소, 값 10)
```