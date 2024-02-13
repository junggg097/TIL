# Querydsl
- 데이터를 조회하는 여러 맥락에 대해 같은 Java 코드로 데이터를 조회하는 것을 목표로 한다
  - JPA & SQL
  - Lucene (검색 엔진)
  - MongoDB (NoSQL DB 등)

```java
JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
QItem qItem = new QItem("item");
Item found = queryFactory.selectFrom(qItem)
        .where(qItem.name.eq("itemA"))
        .fetchOne();
```
- 문자열로 개발자가 직접 작성하는 부분이 거의 없다.
- 전부 Java 코드 - > 컴파일 단계에서 오류 발견 가능하다.
- 조회 조건을 따로 추출하는 것이 가능해 동적 쿼리를 만들기 유용하다.



