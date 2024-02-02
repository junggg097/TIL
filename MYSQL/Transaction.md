# Transaction
특정 작업을 하기 위해선 여러 SQL 문을 활용하게 된다.
- 이렇게 모인 SQL 단위 묶음
- 트랜잭션 실행 중 정상 실행이 불가해지면 그동안 있었던 변경을 되돌린다.

```sql
BEGIN TRANSACTION;

SELECT stock FROM item WHERE id = ?;

INSERT INTO order_item(order_id, item_id, count)
VALUES (?,?,?);

UPDATE item SET stock = stock - ?
WHERE  id = ?;

-- 여태 작업을 되돌린다.
ROLLBACK ;
-- 여태 작업을 실제 DB에 반영한다.
COMMIT;
```


# ACID
- 데이터 무결성 / 안정성을 위해 트랜잭션이 가져야 하는 특징 

### Atomicitiy (원자성)
- 트랜잭션은 하나의 작업이며 , 나누어 실행 할 수 없다 . 일부가 실패하면 전체 FAIL   

### Consistency (일관성)
- 트랜잭션 실행 전후로 DB 의 상태가 일관성(제약사항 등)을 유지해야 한다.  

### Isolation (격리성)
- 트랜잭션 각각이 다른 트랜잭션과 독립되어야 한다.   

### Durability (지속성)
- 트랜잭션이 마무리되면 결과가 영속성을 가져야 한다.