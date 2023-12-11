# 기념일 계산기

## 객체 (Object) 알아보기

```javascript
var person = {
    name : 'yujin',
    age: 24,
    sayHello : function () {
        console.log('hello')
    }
}
```
- name , age  : 속성, 키 (KEY) , 속성명
- yujin , 24 : 값 (Value), 속성값 
- 값 (Value) 에 들어갈 수 있는 것들 
  - 문자열 , 숫자 , 배열 , 객체 , 함수 ( 메서드 method ) . . . 
  
## 객체.키;
```javascript
// 객체에 접근하여 빼오기
person.name;
person.age;
person.sayHello();
// 콘솔에 hello 가 찍힘
```


## Date 객체 알아보기
현재 날짜 기준으로  ` var now = new Date(); `

```javascript
<script>
    //1. Date 객체 생성
    var now = new Date();
    //2. 연도를 가져오는 메서드 .getFullYear()
    console.log(now.getFullYear())
    //3. 월 정보를 가져오는 메서드 .getMonth() {0: 1월, 1: 2월, ... 10: 11월, 11: 12월}
    // 0이 1월을 나타내기 때문에 +1을 해줘야한다.  
    console.log(now.getMonth()+ 1)
    //4. 일 정보를 가져오는 메서드 .getDate()
    console.log(now.getDate())
    //5. 1970년 1월 1일 00:00:00을 기준으로 흐른 시간을 밀리초로 표시하는 메서드 .getTime()
    console.log(now.getTime())
    //6. 특정 일의 Date 객체 생성
    var christmas = new Date('2023-12-25');
    //7. 특정 ms의 Date 객체 생성
    var ms = new Date(1000);
    console.log(ms); 
</script>
```

## 우리 며칠 째 ?

- 만난 밀리초 = 오늘.getTime() - 사귄날.getTime()
- 만난 일  = 만난 밀리초를 일로 환산

```javascript
<section class='photos'>
  <img id='duhee' src="duhee.jpeg" alt="duhee">
    <img id='heart' src="heart.png" alt="heart">
      <img id='jisook' src="jisook.jpeg" alt="jisook">
</section>
<div class='container d-flex flex-column justify-content-center align-items-center mt-3'>
  <h3>두희♥지숙</h3>
  <h3 id='love'>0일째</h3>
  <h4 class="date">2020.6.30</h4>
</div>
<script>
        var now = new Date();
        var start = new Date('2020-06-30');
        //현재 시간 - 시작한 날 시간 = 만난 기간이 밀리초로 나온다
        var timeDiff = now.getTime() - start.getTime();
        // 밀리초를 날로 바꾸기
        // 밀리세컨드라 1000
        // 60 = 1초
        // 60 = 1시간
        // 24 = 1일 
        // 1을 더한 이유 : 사귄 날을 보통 1일으로 하기 때문에
        // 결과값이 소수점으로 나오기 때문에
        // 소수점을 버리는 Math.floor 활용
        var day = Mate.floor(timeDiff / (1000 * 60 * 60 * 24) + 1);
        $('#love').text(day + '일째');
</script>
```

## 기념일까지 남은 날짜는 ?
- 남은 밀리초 = 기념일.getTime() - 오늘.getTime()
- 만난 일 = 만난 밀리초를 일로 환산
```javascript
<section class='special-day'>
    <h3 class='title'>크리스마스</h3>
    <div class='date-box'>
        <p id='xmas' class='days-left'>0일 남음</p>
        <p class='date'>2021.2.14</p>
    </div>
</section>
<script>
  var xmas = new Date('2023-12-25');
  var timeDiff2 = xmas.getTime() - now.getTime();
  
  var day2 = Mate.floor(timeDiff2 / (1000 * 60 * 60 * 24) + 1);
  #('#xmas').text(day2 + '일 남음 ');
</script>
```

## 1000일은 언제인가 ?
- 1000일의 밀리초 = 사귄날 .getTime() + 999일의.getTime()
- 1000일 = new Data(1000일의 밀리초)
```javascript
<section class='special-day'>
    <h3 class='title'>1000일</h3>
    <div class='date-box'>
        <p id='thousand' class='days-left'>0일 남음</p>
        <p id='thousand-date' class='date'>0000.00.00</p>
    </div>
</section>
<script>
  // 1000일의 밀리초 계산
  var ms = start.getTime() + 999 * (1000 * 60 * 60 * 24);
  var thousand = new Date(ms);
  var thousandDate = 
    thousand.getFullYear() + '.' 
  + (thousand.getMonth()+1) + '.' 
  + thousand.getDate();
  $('#thousand-date').text(thousandDate);
</script>
```

## 1000일까지 남은 날짜는 ?
```javascript
var timeDiff3 = thousand.getTime() - now.getTime();
var day3 = Math.floor(timeDiff3 / (1000 * 60 * 60 * 24) + 1);
$('#thousand').text(day3 + '일 남음');
```

## 정리하기
```javascript
<body class="container">
    <section class='photos'>
        <img id='duhee' src="duhee.jpeg" alt="duhee">
        <img id='heart' src="heart.png" alt="heart">
        <img id='jisook' src="jisook.jpeg" alt="jisook">
    </section>
    <div class='container d-flex flex-column justify-content-center align-items-center mt-3'>
        <h3>두희♥지숙</h3>
        <h3 id='love'>0일째</h3>
        <h4 class="date">2023.6.30</h4>
    </div>
    <hr/>
    <section class='special-day'>
        <h3 class='title'>크리스마스</h3>
        <div class='date-box'>
            <p id='xmas' class='days-left'>0일 남음</p>
            <p class='date'>2023.12.25</p>
        </div>
    </section>
    <hr/>
    <section class='special-day'>
        <h3 class='title'>1000일</h3>
        <div class='date-box'>
            <p id='thousand' class='days-left'>0일 남음</p>
            <p id='thousand-date' class='date'>0000.00.00</p>
        </div>
    </section>
    <hr/>
    <script>
        var now = new Date();
        var start = new Date('2023-06-30');

        //우리 몇 일째?
        var timeDiff = now.getTime() - start.getTime();
        var day = Math.floor(timeDiff / (1000 * 60 * 60 * 24) + 1);
        $('#love').text(day + '일째');

        //기념일까지 남은 날짜는?
        var xmas = new Date('2023-12-25');
        var timeDiff2 = xmas.getTime() - now.getTime();
  
        var day2 = Mate.floor(timeDiff2 / (1000 * 60 * 60 * 24) + 1);
        #('#xmas').text(day2 + '일 남음 ');

        //천일은 언제인가?
        var thousand = new Date(start.getTime() + 999 * (1000 * 60 * 60 * 24));
        var thousandDate = thousand.getFullYear() + '.' + (thousand.getMonth()+1) + '.' + thousand.getDate();
        $('#thousand-date').text(thousandDate);

        //기념일까지 남은 날짜는?
        var timeDiff3 = thousand.getTime() - now.getTime();
        var day3 = Math.floor(timeDiff3 / (1000 * 60 * 60 * 24) + 1);
        $('#thousand').text(day3 + '일 남음');
    </script>
</body>

```