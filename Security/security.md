# Spring Security

- 인증 (Authentication) : 사용자가 자신이 누구인 지를 증명하는 과정
- 권한 (Authorization) : 사용자가 어떤 작업을 수행할 수 있는 지를 결정하는 과정


# Form Login
## 로그인
### 가장 기본적인 사용자 인증 방식
1. 사용자가 로그인이 필요한 페이지로 이동
2. 서버는 사용자를 로그인 페이지로 이동
3. 사용자는 로그인 페이지를 통해 아이디, 비밀번호 전달
4. 아이디, 비밀번호 확인 후 사용자 인식
5. 이후 쿠키를 이용해 방금 로그인한 사용자를 세션을 이용해 기억한다.


## 쿠키 & 세션
HTTP 요청에는 상태가 없다
- 각 요청은 독립적으로 이뤄진다.
- 사용자의 브라우저는 인증 사실을 매번 서버에 알려줘야 한다.
- 이때 쿠키와 세션의 개념 등장

### 쿠키
- 서버에서 사용자의 브라우저로 보내는 작은 데이터

### 세션
- 쿠키에 저장된 ID를 바탕으로 상태가 유지되는 상태