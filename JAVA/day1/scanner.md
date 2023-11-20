# Scanner

## 데이터 입력받기

```java
        Scanner scanner = new Scanner(System.in);
        String scannedLine = scanner.nextLine();
        System.out.println(scannedLine);
```
  Scanner 는 사용자의 입력을 일부 해석해서 데이터를 돌려준다  
  입력된 데이터를 받을때, 한 줄의 입력을 문자열 데이터로 해석해서 할당할 때 사용하는게 scanner.nextLine() 이다.  
  그 외의 자료형을 입력받을 때는 각자 다른 방법을 사용한다.
  
## 정수형

```java
        int scannedInt = scanner.nextInt();
        long scannedLong = scanner.nextLong();
        System.out.println(scannedInt);
        System.out.println(scannedLong);
```

## 실수형

```java
        float scannedFloat = scanner.nextFloat();
        double scannedDouble = scanner.nextDouble();
        System.out.println(scannedFloat);
        System.out.println(scannedDouble);
```

## 불린형

```java
        boolean scannedBool = scanner.nextBoolean();
        System.out.println(scannedBool);
```

## 문자열 응용

### Escape Sequence
```java
        // 내일 봐 ~ 하고 말하였다.
        String quote = "\"내일 봐\" 하고 말하였다.";
        System.out.println(quote);

        char quotation = '\'';
        System.out.println(quotation);

        String doubleBack = "\\ is backslash";
        System.out.println(doubleBack);
        
        // 엔터키 (개행문자) , 백스페이스, 탭키
        System.out.println("개행문자 : \n이 다음은 다음 줄에 표현된다");
        System.out.println("name\tscore");
        System.out.println("Alex\t3.5");
        System.out.println("Thomas\t4.0");
        System.out.println("백스페이스: \b앞의 문자를 하나 지운다.");

```

### String Formatting

```java
//231117의 날씨
        String message = "미세먼지 농도 : 10 (좋음)";
        //231118의 날씨
        message ="미세먼지 농도 : 11 (좋음)";

        // 문자열 포맷팅 - String Formatting
        int dust = 35;
        String status = "나쁨";
        String msgTemplate = "미세먼지 농도: %d (%s)";
        // System.out.println(String.format("미세먼지 농도: %d (%s)", dust, status));
        System.out.println(String.format(msgTemplate, dust, status));

```

대치하고 싶은 일부분을 % 로 시작하는 포맷 코드를 추가하여 작성한 문자열을, String.format() 에 넣어주고, `,`로 구분하여 대입하고 싶은 데이터를 넣어준다.  
이때 대입할 데이터가 어떤 자료형인지에 따라 다른 코드를 넣어줄 수 있다.  
또한 문자열에 들어가있는 포맷 코드의 갯수만큼은 데이터를 제공해 주어야 한다.

```%s```  문자열(String)  

```%c```  문자(char)  

```%d```  정수(int)  

```%f```  부동소수(float, double