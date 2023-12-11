# 미니스타크래프트

## jQuery
javaScript를 보다 쉽고 간결하게 사용할 수 있다 !
```
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
crossorigin="anonymous"></script>
스크립트 추가하고 사용해준다
```

### 장점
1. 간결한 문법
2. 편리한 API
3. 크로스 브라우징

### 기본 문법
- > $(선택자).행위;
  
```javascript
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
        crossorigin="anonymous">
</script>
<textarea id="content">jQuery를 배워보자</textarea>
<script>
$('#content').val();
</script>
```


## jQuery Event

```javascript
<body>
    <h1>jQuery 이벤트</h1>
    <button id="click">클릭</button>
    <script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"></script>
    <script>
        // hello 함수
        function hello() {
            console.log('hello');
        }
        // 'click' id를 가진 button을 .click() 클릭하면 hello 함수 실행
        $('#click').click(hello);
    </script>
</body>
```


## 익명함수 
-  한 번만 사용하는 거라면 함수 생성하고 호출하는 게 너무 비효율적이다 !
-  그래서 **따로 정의하고 호출하지 않고 익명 함수로 한 번에 가능**하다 !

```javascript
<script>
    // 익명함수 !! 
    $('#click').click(funciton() {
    console.log('hello');
}   
</script>
```

## 드론을 클릭했을 때 침을 발사해라 !

```javascript
<body>
    <h1 id='hp'>HP: 3</h1>
    <div class='background'>
        <img id='drone' src="drone.png" alt="drone">
        <img id='spit' src="spit.png" alt="spit">
        <img id='bunker' src="bunker.png" alt="bunker">
    </div>
    <script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
    <script>
        //$() .click() 익명함수
        $('#drone').click(function() {
            console.log('침 캌 퉤 !!');
        })    
    </script>
</body>
```
## 침 이미지 나타나기
### .fadeIn(duration, complete) : 나타내기
- > duration : 얼마나 지속되는 지
- > complete : 완료됐을 때 무엇을 할 건지
- > 둘 다 선택사항 이기 때문에 .fadeIn() 만 사용가능 !
```javascript
$('#drone').click(function (){
    // 침 나타내기
    $(#'spit').fadeIn();
})
```

## 침이 목표물까지 이동해라 !!

### .animate(properties, [duration], [easing], [complete])
- properties : 변화할 css가 들어간다  ( 필수 사항 )
- duration : 지속 시간 ( 선택 사항 )
- easing : transtion 형태가 어떻게 되는 지 ( 선택 사항 )
- complete : 완료 됐을 때 무엇을 할 지 ( 선택 사항 )


```javascript
$('#drone').click(function (){
    $(#'spit').fadeIn();
    // 침 이동하기
    $(#'spit').animate({
        // 현재 위치에서 왼쪽 간격을 250 늘려줌
        left : '+=250'
    });
})
```

## 침이 목표물에 닿으면 없어져라 !!
### .fadeOut() : 사라지기


```javascript
$('#drone').click(function (){
    $(#'spit').fadeIn();
    $(#'spit').animate({left : '+=250'});
    // 침 사라지기
    $(#'spit').fadeOut();
})
```

## 한 번 나간 침을 다시 원래 자리로 복구 시켜라 !! ( 다시 쏴야하니. . . )

### .css() 
- > 변경하고 싶은 css를 입력하면 애니메이션 없이 바로 변경 가능


```javascript
$('#drone').click(function (){
    $(#'spit').fadeIn();
    $(#'spit').animate({left : '+=250'});
    $(#'spit').fadeOut();
    // spit  css left 값 : 150px
    // 이기 때문에 설정을 그대로 해주면 
    // 침이 다시 그 자리에 돌아옴
    $(#'spit').css({left: '150px'});
})
```

## 침이 벙커에 맞을 때마다 HP 깎여라!!

```javascript
<script>
    // 기본 설정 hp
    var hp = 3;
    $('#drone').click(function (){
    $(#'spit').fadeIn();
    $(#'spit').animate({left : '+=250'});
    // fadeOut 이 끝나고 난 후에 피 깎기
    // fadeIn, fadeOut은 동작이기 때문에 시간이 걸린다.
    // 반면 hp깎이는 코드는 바로 실행되기 때문에
    // fadeOut complete로 익명함수 콜백함수로
    // fadeOut이 완료되면 피 깎이는 코드가 실행되게 한다.
    $(#'spit').fadeOut(function(){
        // 피가 -1 씩 
        hp = hp -1;
        //hp 텍스트를 바꿔준다
        $('#hp').text('HP : ' + hp);
    });
    $(#'spit').css({left: '150px'});
    
})
</script>
```

## 벙커에 HP 0 되면 벙커 사라져라 !
```javascript
<script>
    // 기본 설정 hp
    var hp = 3;
    $('#drone').click(function (){
    $(#'spit').fadeIn();
    $(#'spit').animate({left : '+=250'});
    $(#'spit').fadeOut(function(){
        hp = hp -1;
        $('#hp').text('HP : ' + hp);
        // HP 가  0 이 되면
        // bunker가 fadeOut() 사라진다.
        if (hp == 0) {
            $('#bunker').fadeOut();
        }       
    });
    $(#'spit').css({left: '150px'});
    
})
</script>
```
