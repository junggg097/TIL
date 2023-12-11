# 자소서 글자수 계산기 

## DOM ?
DOM ( Document Object Model)
: 웹 화면을 구성하는 HTML 코드를 쉽게 접근할 수 있게 만든 모델 !


### .length
- > 문자열의 길이

```javascript
<body class="container">
    <h1>자기소개</h1>
    <textarea class="form-control" rows="3" id="jasoseol">저는 인성 문제가 없습니다.</textarea>
    <span id="count">(0/200)</span>
    <script>
        // 'jasoseol' 이라는 id를 가진 요소의 .value 값을 content에 저장
        var content = document.getElementById('jasoseol').value;
        // 'count' id가진 요소의 span태그 안쪽의 담긴 값을 가져온다 '='부호기준 오른쪽 내용이 들어간다.
        document.getElementById('count').innerHTML = '(' + content.length + '/200)' ;
    </script>

```

## 글자를 입력할 때마다 번거롭게 매번 다 써야하나 ?!
## 함수를 이용해라 !

### 함수 -> 명령 모음
- > ```
  > function 함수이름() {
  > 명령 1;
  > 명령2;
  > }

```javascript
<script>
    function counter() {
        var content = document.getElementById('jasoseol').value;
        document.getElementById('count').innerHTML = '(' + content.length + '/200)' ;
    };
    counter();
</script>
```

## 키보드를 누를 때마다 글자 수를 세어라 !!
## 이벤트를 활용해서 !!

### 이벤트 핸들링 
이벤트 : 키보드를 누를 때마다   
이벤트 핸들링 : 글자 수를 세줘라 

ex) <textarea 이벤트=이벤트핸들링></textarea>

**onKeyDown** : 키보드를 누를 때마다 !
```javascript
<textarea onKeyDown='counter();' class="form-control" rows="3" id="jasoseol">저는 정유진입니다.</textarea>
```

## 200 자 넘으면 더이상 안써지도록 하자 !

### if문 활용 하고 200 글자 이후는 잘라버리기 !

### .substring()
- > 문자열 자르기

```javascript
<script>
        var content = document.getElementById('jasoseol').value;
        // content.length 가 200이 넘으면
        if (content.length > 200) {
            //0에서 200글자 (띄어쓰기 포함) 까지 잘라 content 저장
            content = content.substring(0,200);
            // 'jasoseol' id 가진 요소에 content 값 저장
            document.getElementById('jasoseol').value = content;
        }
</script>
```

## 정리하기
```javascript
<body class='container'>
    <h1>자기소개</h1>
    
    // 이벤트핸들링을 활용해 키보드를 누를때마다 실행된다.
    <textarea class="form-control" rows="3" id="jasoseol" onkeydown="counter();">저는 인성 문제가 없습니다.</textarea>
    <span id="count">(0/200)</span>
    <script>
        
        // 함수를 만들어 여러 줄의 코드를 한 번에 실행 할 수 있게 해준다.
        function counter() {
            var content = document.getElementById('jasoseol').value;
            // 조건문을 활용해 200 글자 제한 (substring())
            if (content.length > 200) {
                content = content.substring(0,200);
                document.getElementById('jasoseol').value = content;
            }
            document.getElementById('count').innerHTML = '(' + content.length + '/200)';
        }
        counter();
    </script>
</body>
```