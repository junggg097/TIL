# Class

```java
Person me = new Person();
```
- Person : 클래스
- me : 객체 , Person의 인스턴스  
  
새로운 인스턴스를 만들 때에는 ```new``` keyword 사용


## 속성 ( attribute)
Person 클래스가 가져야 하는 정보 = 속성
```java
public class Person {
    public String name;
    public int age;
}
```
- 메서드가 아닌 클래스의 영역에서 선언한다.
- 만들어진 객체마다 별도로 가지고 있다.
```java
public static void main(String[]args){
        Person me = new Person();
        me.name = " 정유진 ";
        me.age = "24";
        System.out.println{
            String.format("이름 : %s , 나이 : %d", me.name, me.age)
        };
}
```
- 속성에 ```.``` 를 이용해 접근하여 데이터를 가져오거나 할당하거나 변수를 쓰는 것과 동일하게 사용 가능하다.
  
## 메서드(methods)

Person 객체의 **기능**을 정의한다.
```java
public class Person {
    public String name;
    public int age;

    // 자기소개 기능
    public void hello() {
        System.out.println(
                String.format("Hello, my name is " + name + "!")
        );
    }
}
```
각 객체가 수행할 수 있는 기능
- 객체가 가지고 있는 속성을 활용
- 그에 따라 각 객체마다 동작 다를 수 O
- 어떤 객체가 호출했는 지에 따라 ```name``` 부분의 출력 결과가 다름

```java
public static void main(String[]args){
        Person me = new Person();
        me.name = " 정유진 ";
        me.age = "24";
        me.hello();
}
```
속성과 마찬가지로 ```.``` 을 이용해 호출한다.

## 정적(static) 제어자

속성, 메서드 앞에 **static** 을 추가하면 정적 속성, 메서드가 된다.
```java

public class Person {
    public static String country = "대한민국";
    public String name;
    public int age;
    
    //...
}
```

정적 - 움직이지 않는다.
- 객체에 속한 속성이 아닌 클래스에 속한 속성
- 인스턴스를 만들지 않고 클래스에서 접근한다.


## 접근 제어자
- 속성, 메서드에 붙혀 접근에 대하나 권한 조절
- 정보 은닉 : 접근 제어자를 통해 객체의 구체적 정보 노출을 방지
```java
public class Person {
    public String name;
    public int age;
    //...
}
```
**public** - 공공의 , 아무나 접근 가능  
```java
public class Person {
    private String name;
    private int age;
    //...
}
```
**private** - 클래스 내부에서만 사용 가능

## Getter & Setter

- private 속성, 메서드는 클래스 내부에서만 접근 되는데 그럼 객체를 어떻게 쓰나 ?!  
      
    => public 메서드를 생성하여 private 속성에 접근해라 !

```java
public String getName() {
        return name;
    }
    
    // this-> 객체 자신을 가르키는 keyword
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
```
Getter/Setter 메서드는 직접적으로 해당 속성을 다룰 때 사용
- 객체의 속성은 객체의 상태를 나타낸다.
- 반드시 Getter/Setter 를 통해 변경 해야 하는 건 아니다

```java
public void age(int age) {
    this.age += 1;
}
```
기존 나이의 + 1 의 나이로 반환한다.

