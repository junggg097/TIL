# 생성자
- 정보를 한 번 전달하게 하자 !

```java
public class Person {
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
생성자 : 객체를 만들 때 호출되는 메서드
생성자 메서드 -> 접근제어자 메서드이름() {}
메서드 이름은 클래스 이름과 동일하게 !

```java
public static void main(String[]args){
        Person me = new Person();
}
```
따로 만들지 않으면 값을 받지 않는 기본 생성자가 생성된다.
생성자를 만들면 기본 생성자는 없어진다.
-> 생성자도 메서드고, 메서드 오버로딩이 된다.

```java
public class Person {
    // 생성자에서 할당 후 다시 변경 불가
    private final String name;
    // 이후에도 변경 가능
    private int age;
}
```
