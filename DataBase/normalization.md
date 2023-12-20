# Normalization ( 정규화 )

## JOIN 절

### RDB에서의 관계

### 1:1 One to One 관계
- 한 테이블의 레코드 하나가 다른 테이블의 레코드 하나와 연관된 관계
- 특정 데이터를 성능 또는 보안적 측면에서 나눌 때 사용

### N:1, Many to One 관계
- 한 테이블의 레코드 0개 이상이 다른 테이블의 레코드 하나와 연관된 관계
- 일반적인 데이터베이스의 가장 흔한 관계 (게시글 - 댓글 , 가게 - 상품 등)

### M:N, Many to Many 관계
- 한 테이블의 레코드 0개 이상이 다른 테이블의 레코드 0개 이상과 연관된 관계
- 양쪽 테이블의 PK를 Foreign Key 로 가진 Join Table, Associative Table 활용

## INNER JOIN
- ON 을 통해 어떤 컬럼이 일치해야 하는지
- 어떤 컬럼을 기준으로 JOIN을 하는 지를 전달

## OUTER JOIN
- INNER JOIN 에서는 한쪽에 없는 데이터는 나오지 않는다.
- OUTER JOIN 을 쓰면 한쪽에 데이터가 없어도 다 나온다. ( 순서에 따라 겹치는 데이터가 없어도 모든 데이터가 나오는 게 다르다.)

FROM A LEFT OUTER JOIN B
-> A 데이터 다 출력 
