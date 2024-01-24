# Validation (사용자 입력 검증)

## 예외 처리
### throw new ResponseStatusException();
- 어디서든 간편하게 사용할 수 있는 예외
```java
Optional<User> optionalUser
        = repository.findFirstByUsername(username);
        if (optionalUser.isEmpty())
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
```
- 별도의 작업 없이 간편하게 사용 가능
- 똑같은 코드를 여러 번 반복하게 되는 단점 존재

# 유효성 검사 (Validation)
- 사용자가 입력한 데이터가 허용된 형태인지 검사하는 과정

# 사용자 지정 유효성 검사
