# MBTI
- [HTML](index.html)
- [CSS](style.css)
- https://mbtitest10101010.netlify.app/


### MBTI
: 4가지 알파벳으로 16가지 성격 유형 표현

1. E(외향) / I(내향)
2. S(감각) / N(직관)
3. T(사고) / F(감정)
4. P(판단) / J(인식)


# 로직 구성하기

1. 4가지 유형 각각 마다 3문제씩 내기
2. E/I 이면 앞쪽 유형에만 점수 주기
3. 점수가 2점 이상인 유형을 택하기
4. 4가지 유형 결과값 추출하기


## javaScript 객체 
- 자료를 담는 형태 ! 

`var jsObject = { key : value }`

`jsObject[key] => value`

### ex

```javascript
var q = {
    1: {"title":"문제 1번", "type":"EI" , "A:E", "B":"I"},
    2: {"title":"문제 2번", "type":"SN" , "A:S", "B":"N"}
}
```
- > var q 객체 생성
- > 각 문제 번호를 key 로 하는 요소 추가
- > 각 문제의 value로 또 다른 객체 정보를 추가

- **Q1. q[1]["title"]**
- > 문제 1번
- **Q2. Q[2]["type"]**
- > SN
- **Q3. 문제 2번의 A대답을 가져오려면 ?**
- > q[2]["A"]



## E/I 이면 앞쪽 유형에만 점수 주기
```html
<article class="question">
    <div class="progress mt-5">
        <!--진행 바 표시-->
        <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
    </div>
    <!--문제 id 주기-->
    <h2 id="title" class="text-center mt-5">문제</h2>
    <input id="type "type="hidden" value="EI">
    <button id="A" type="button" class="btn btn-outline-primary mt-5">Primary</button>
    <button id="B" type="button" class="btn btn-outline-primary mt-5">Primary</button>
</article>
<!--값을 저장할 공간을 hidden으로 화면에 보이지 않게 가지고 있기-->
<input type="hidden" id="EI" value="0">
<input type="hidden" id="SN" value="0">
<input type="hidden" id="TF" value="0">
<input type="hidden" id="JP" value="0">
```

```javascript
<script>
        <!--문제 번호-->
        var num = 1;
        <!--객체 q에 key num 에 value값 주기-->
        var q = {
            1: {"title":"문제 1번", "type":"EI" , "A":"E", "B":"I"},
            2: {"title":"문제 2번", "type":"EI" , "A":"E", "B":"I"},
            3: {"title":"문제 3번", "type":"EI" , "A":"E", "B":"I"},
        }

        <!--id A 를 클릭했을 때의 함수-->
        $("#A").click(function() {
            <!--id type 값을 type에 저장-->
            var type = $("#type").val();
            <!--type 의 값을 preVaule 에 저장-->
            var preValue = $("#"+type).val();
            <!--점수를 주기 위해 정수형으로 변환하고 +1을 한다-->
            $("#"+type).val(parseInt(preValue)+1);
            next();
        });
        <!--id B를 클릭했을 때의 함수-->
        $("#B").click(function() {
            <!--점수를 주지 않기 때문에 next() 만 이뤄진다-->
            next();
        });

        <!--다음 문제로 넘어가는 함수-->
        function next() {
            $("#title").html(q[num]["title"]);
            $("#type").val(q[num]["type"]);
            $("#A").html(q[num]["A"]);
            $("#B").html(q[num]["B"]);
            num++;
        }

    </script>
```


## 진행바 표시
```html
<div class="progress mt-5">
    <div class="progress-bar" role="progressbar" style="width: calc(100/12*1%)" ></div>
</div>
```
진행바는 width 값으로 움직인다.   
- > 100 진행률 12문제중 문제 수
  
##  .attr 

: 태그를 바꿔주는 속성

```javascript
function next() {
    
    <!--attr 속성을 이용하여 바꿔줄 'style' , '어떻게바꿔주냐' 적고
        문제 수 마다 진행률이 바뀌기 때문에 num 을 넣는다
    -->
        $(".progress-bar").attr('style','width: calc(100/12*' + num + '%)');
        $("#title").html(q[num]["title"]);
        $("#type").val(q[num]["type"]);
        $("#A").html(q[num]["A"]);
        $("#B").html(q[num]["B"]);
        num++;
    }
```

# MBTI 핵심 로직
```html
<input type="hidden" id="EI" value="0">
<input type="hidden" id="SN" value="0">
<input type="hidden" id="TF" value="0">
<input type="hidden" id="JP" value="0">
```

모든 문항의 설문이 끝났을 때
id 에 해당하는 value 가 과반수 이상이면 과반수 이상인 값들 나열

```javascript
if($("#EI").val() < 2) {
    mbti = mbti + "I";
} else {
    mbti = mbti + "E";
}
```
이렇게 4가지 문항을 다 하기엔 코드가 길어진다 .  
그래서 삼항 연산자를 이용하도록 한다 !!

```javascript
var mbti = "";
($("#EI").val() < 2) ?  mbti += "I" : mbti += "E";
($("#SN").val() < 2) ?  mbti += "N" : mbti += "S";
($("#TF").val() < 2) ?  mbti += "F" : mbti += "T";
($("#JP").val() < 2) ?  mbti += "P" : mbti += "J";
```

## 결과화면에 결과 도출하기 !

- 각 항목들에 id를 지정해준다
```html
<article class="result">
    <img id="img" class="rounded-circle mt-5" src="lion.jpg" alt="사자!">
    <h2 id="animal" class="text-center mt-5">동물 이름</h2>
    <h3 id="explain" class="text-center mt-5">설명</h3>
</article>
```

- 결과 도출할 js
```javascript
var result = {
    "ISTJ": {"animal": "하마", "explain": "하마 설명", "img": "lion.jpg"},
    "ISFJ": {"animal": "부엉이", "explain": "부엉이 설명", "img": "lion.jpg"},
    "INFJ": {"animal": "물소", "explain": "물소 설명", "img": "lion.jpg"}
}

function next() {
    // ...
    $("#img").attr("scr", result[mbti]["img"]);
    $("#animal").html(result[mbti]["animal"]);
    $("#explain").html(result[mbti]["explain"]);
}
```
- 결과값 result = mbti : { mbti 동물이름 , 설명 , 이미지 정보 값 }
- > `$("#img").attr("scr", result[mbti]["img"]);`
- result 라는 Object 에서 [key] mbti 에 해당하는 value img, animal, explain 을 가져와서  
 #img, #animal, #explain 에 넣는다.