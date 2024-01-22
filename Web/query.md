# Query Component
URL 의 구성 요소 중 `?` 뒤의 요소
```
http://example.com/path?query=keyword&limit=20
```
- 요구하는 자원에 대한 동적인 조건을 전달하는 용도로 사용
- ? 뒤에 `key(인자이름) = value(값)` 형식으로 사용, 각 인자는 `&` 으로 구분
  - query:keyword
  - limit:20