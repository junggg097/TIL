# Object class
- Object class
  - toStirng
  - equals
  - hashCode
- null
  

```object``` 는 클래스가 기본적으로 상속받는 클래스이다.  
아무것도 상속받지 않는 클래스를 만든다면 , 묵시적으로 ```Object``` 클래스를 상속받는다.
  
또한 ```Object``` 클래스는 여러가지 기능 (ex)문자열 변환) 을 위해 활용하는 메서드를 가지고 있으며,  
자식 클래스에서 오버라이드 하여 클래스가 의도대로 동작하도록 정의한다.
  
## toString
어떤 객체가 문자열로 어떻게 표현될 지 정의하는 메서드
  
자식 클래스에서 ```toString``` 을 오버라이드 하면 출력될 모습을 정의할 수 있다.  
```java
public abstract class Person implements Comparable{
    // ...
    @Override
    public String toString() {
        // name == "Alex", age == 20 일때
        // "Alex, age: 20"가 출력된다.
        return String.format("%s, age: %s", name, age);
    }
}
```

## equals

```==``` 는 일치 연산자로, 원시 타입 비교할 때는 괜찮지만 참조 타입을 비교할 땐 문제가 될 수 있다 .  
객체가 가지고 있는 속성의 일치가 아닌 , 실제로 동일하게 저장된 객체인지 비교하기 때문이다.  
```java
Person alex = new Student("Alex", 20, "CSE");
Person alex2 = new Student("Alex", 20, "CSE");

// 같은 값을 가지고 있어도 false
System.out.println(alex == alex2);
```  
각 객체가 가진 속성값을 기준으로 일치하는 지 비교하고 싶다면 ```equals``` 를 오버라이드 할 수 있다 .
```java
public abstract class Person {
    // ...
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
}

```

비교할 때 ```equals``` 호출
```java
Person alex = new Student("Alex", 20, "CSE");
Person alex2 = new Student("Alex", 20, "CSE");

// false
System.out.println(alex == alex2);
// true
System.out.println(alex.equals(alex2));
```

상속 관계가 있는 클래스의 ```equals``` 를 구현할 땐 주의 !!!  
부모 클래스 입장에선 동일하지만 자식 클래스 입장에선 동일하지 않을 수 있기 때문
  
```Person.equals()``` 를 자식 클래스 구분없이 일치하는 지 확인하도록 정의하고 
```java
// Person.java

@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return age == person.age && Objects.equals(name, person.name);
}
```
```Student.equals()``` 를 동일한 클래스일대만 일치하도록 정의하면
```java
// Student.java

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(major, student.major);
}
```
서로 다른 자식 클래스를 비교할 때 문제 발생할 수 있다.
```java
Person alex = new Student("Alex", 20, "CSE");
Person alex2 = new Lecturer("Alex", 20, "OOP");

System.out.println(alex.equals(alex2));  // false
System.out.println(alex2.equals(alex));  // true
```

## null
```null``` 은 존재하지 않는다는 것을 의미한다.  
어떤 참조 타입 변수에 값이 할당되지 않으면 , 해당 객체가 존재하지 않는다는 의미로 ```null``` 이 할당된다.
```java
// 속성을 할당하지 않는 기본생성자를 만들고
Person noNamePerson = new Student();
// 할당되지 않은 속성을 확인해보자.
System.out.println(noNamePerson.getName());  // null

```
만약 어떤 객체가 ```null``` 인 상태에서 메서드를 사용하려 하면 ,```NullPointerException``` 발생한다.
```java
Person noNamePerson = new Student();
// null
System.out.println(noNamePerson.getName());
// throws NullPointerException
System.out.println(noNamePerson.getName().equals("Alex"));

```
간단하게는 ```if``` 등의 조건문으로 방지하거나 , 분명히 ```null```이 아는 대상의 메서드 기준으로 동작시킬 수 있다.
```java
Person noNamePerson = new Student();
System.out.println(noNamePerson.getName());
// System.out.println(noNamePerson.getName().equals("Alex"));
System.out.println("Alex".equals(noNamePerson.getName()));

```