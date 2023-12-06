# 예외 처리
-  [try-catch-finally](#try-catch-finally)
- [Throwable & throws](#throwable--throws)

예외 ( ```Exception```)는 프로그램 실행 중 예상하지 못한 상황을 의미한다.  
예외처리는 이런 상황에 대처하여 원래의 흐름으로 복귀하는 기법을 의미한다 .

## try-catch-finally
다음 코드에서는 ```ArithmeticException``` 이 발생한다. ( 0으로 나누려고 하기 때문에 오류 발생 )
```java
public class ExceptionHandling {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        System.out.println(divide(a, b));
        System.out.println("Bye!");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

/// error code
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at d6.ExceptionHandling.divide(ExceptionHandling.java:18)
        at d6.ExceptionHandling.main(ExceptionHandling.java:13)

        Process finished with exit code 1
```

예외가 일어날 수 있는 코드는 ```try``` 로 묶은 다음 ,   
```catch``` 로 해당 예외를 특정지어 주면 어떻게 대처할 지 코드로 구현 할 수 있다.

```java
public static void main(String[] args) {
    int a = 10;
    int b = 0;
    try {
        System.out.println(divide(a, b));
        System.out.println("Bye!");
    } catch (ArithmeticException e) {
        System.out.println("Sorry, can't do that!");
    }
}

// 실행 결과
        Sorry, can't do that!
```

이때 "잡은" 예외의 정보를 ```e``` 에서 회수해 사용할 수 있다.
```java
public static void main(String[] args) {
    int a = 10;
    int b = 0;
    try {
        System.out.println(divide(a, b));
        System.out.println("Bye!");
    } catch (ArithmeticException e) {
        System.out.println(String.format(
            "Sorry, this happened: %s", e.getMessage()));
    }
}

// 실행 결과
        Sorry, this happened: / by zero
```

예외가 발생하든 안하든 실행하고 싶은 코드는 ```finally``` 를 추가해 실행한다.
```java
public static void main(String[] args) {
    int a = 10;
    int b = 0;
    try {
        System.out.println(divide(a, b));
    } catch (ArithmeticException e) {
        System.out.println(String.format(
            "Sorry, this happened: %s", e.getMessage()));
    } finally {
        System.out.println("Bye!");
    }
}

// 실행 결과
        // a == 10 , b == 2
        5
        Bye!
        
        // a == 10 , b == 0
        Sorry, this happened: / by zero
        Bye!
```

서로 다른 예외를 잡고 싶다면 ? ```catch``` 를 더한다.
```java
public static void main(String[] args) {
    Integer a = 10;
    Integer b = null;
    try {
        System.out.println(divide(a, b));
    } 
    catch (ArithmeticException e) {
        System.out.println(String.format(
            "Sorry, this happened: %s", e.getMessage()));
    }
    catch (NullPointerException e) {
        System.out.println("NPE!!!");
    }
    finally {
        System.out.println("Bye!");
    }
}

```

만약 여러 예외를 동일한 방식으로 처리하고 싶다면 ```|``` 를 사용한다.
```java
public static void main(String[] args) {
    Integer a = 10;
    Integer b = null;
    try {
        System.out.println(divide(a, b));
    } 
    catch (ArithmeticException | NullPointerException e) {
        System.out.println(String.format(
            "Sorry, this happened: %s", e.getMessage()));
    }
    finally {
        System.out.println("Bye!");
    }
}
```
내가 직접 예외 발생시키고 싶다면 ,```throw``` 활용해 새로운 예외 객체에 던진다.
```java
public static double divide(int a, int b) {
    if (b == 0) throw new ArithmeticException("Division by Zero");
    return (double) a / b;
}
```
## Throwable & throws

Java의 예외는 전부 ```Throwable``` 클래스의 자식 클래스며 ,  크게 두 종류로 나뉜다.
- ```Exception``` : 코드 실행 중 상황이 기대랑 다를 때 발생하는 예외
- ```Error``` : 더 이상 프로그램 실행이 불가능할 정도의 오류

예외는 다시 두 종류로
- ``` RuntimeException``` : 실행 중 발생하는 ```,``` 코드를 통해 예측 가능한 예외
- 그 외 : 실행 전에는 코드를 통해 예측이 불가한 예외
  
  
```RuntimeException```이 아닌 예외는, 예외처리가 잘 되지 않았다면 컴파일 불가다.
```java
public static void readFileContents(String filename) {
    File file = new File(filename);
    // `FileNotFoundException`이 발생할 수 있기 때문에 컴파일되지 않는다.
    Scanner scanner = new Scanner(file);
}

```
이는 ```try-catch``` 를 활용하거나
```java
 public static void readFileContents(String filename) {
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            // Scanner 활용!
        } catch (FileNotFoundException e) {
        System.out.println("File Not Found!");
        }
}
```
```throws``` 를 메서드에 추가해 , 예외를 발생시킬 수 있음을 알린다.
```java
public static void readFileContents(String filename) 
        throws FileNotFoundException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
}
```
여러 종류의 예외는 ```,``` 로 구분이 가능하다.
```java
public static void readFileContents(String filename)
        throws FileNotFoundException, AccessDeniedException {
    File file = new File(filename);
    Scanner scanner = new Scanner(file);
}
```
