# 로또 생성 추첨기 만들기

## 공부터 뽑아 보자!
### Math.random();  
- > 0이상 ~ 1 미만 실수 (float);

### Math.random() * 45 + 1;
로또 번호는 1부터 45까지 이기 때문에 !!
- > 1 이상 ~ 46미만 실수 (float)

### parseInt();
- > 우리는 소수점 필요 없으니까 ! 정수로 변환 !

### parseInt(Math.random() * 45 + 1)
- > 1이상 ~ 45 이하 정수 (int)
- > 이걸 사용해준다 !
  
이걸 활용하여 1부터 45까지 중 로또 번호 한 개 뽑는 코드 작성해보기 !
```javascript
<script>
        var num = Math.random() * 45 + 1;
        var balls = parseInt(num);
        document.write(balls);
</script>
```

## 1부터 45 까지 중 6개 공 뽑기

### 배열 (Array) 을 활용하자

### .push()
- > 마지막 값 추가

### 빈 배열에 push를 이용해 랜덤으로 숫자 뽑아보기
```javascript
<script>
    var lotto = [];
    // 6개 뽑아야 하니까 !
    lotto.push(parseInt(Math.random() * 45 + 1));
    lotto.push(parseInt(Math.random() * 45 + 1));
    lotto.push(parseInt(Math.random() * 45 + 1));
    lotto.push(parseInt(Math.random() * 45 + 1));
    lotto.push(parseInt(Math.random() * 45 + 1));
    lotto.push(parseInt(Math.random() * 45 + 1));
    document.write(lotto);
</script>
```

이렇게 똑같은 코드를 반복한다 ?
### for , while 반복문 을 활용해 코드를 정리해준다 !

```javascript
for ( var i = 0; i < 6; i++ {
    /*
    시작 : var i = 0;
     끝  : i < 6;
    증가 :  i++
     */
    반복하려는 코드
})
```
```javascript
<script>
        var lotto = [];
        for (var i = 0; i < 6; i++){
            lotto.push(parseInt(Math.random() * 45  + 1));
        }
        document.write(lotto);
</script>
```

## 배열에 중복된 값은 들어갈 수 없다 !
## 조건문을 활용해 중복된 값은 들어갈 수 없게 해주자 !

```javascript
if (조건 ){
    참일 경우
    // 만약 중복이 아니라면 .push();
}
```
### .indexOf(값)
- > 값이 있으면 위치 , 없으면 -1

```javascript
<script>
        var lotto = [];
        for (var i = 0; i < 6; i++){
            var num = parseInt(Math.random() * 45  + 1);
            if (lotto.indexOf(num) == -1 {
                lotto.push(num);
            }
        }
        document.write(lotto);
</script>
```

### for 문은 특정 횟수 만큼 반복 !
### while 문은 특정 조건까지 만큼 반복이다 !

```javascript
while(조건) {
    반복하려는 코드
    // 조건 : 공이 6개가 될떄까지
}
```

### .length
- > 배열의 길이
- > 배열.length 를 통해 배열에 몇 개가 들어갔는 지 확인한다 


```javascript
<script>
        var lotto = [];
        // while .length
        while (lotto.length < 6) {
            var num = parseInt(Math.random() * 45 + 1);
            if (lotto.indexOf(num) == -1) {
                lotto.push(num);
            }
        }
        document.write(lotto);
</script>
```

## 번호가 뒤죽박죽 순서 없이 나온다 !!
## 오름차순으로 정리해주자 !

### .sort()
- > 배열 값 정렬
```javascript
var lotto = [ 1,2,3,33,22,11];
lotto.sort();
document.write(lotto);

// 실행 결과
1,11,2,22,3,33

/*
.sort()는 사전순으로 맨 앞자리 숫자 기준으로 정렬한다
 */

```
그래서 숫자의 크기로 정렬하려면!!

### .sort((a,b) => a-b) 
- > 오름차순 정렬 

### .sort((a,b) => b-a)
- > 내림차순 정렬 

```javascript

## 두둥 로또 번호 추첨기 정리하기
<script>
        // lotto라는 배열 생성 
        var lotto = [];
        // for문으로 6번 반복해주지만
        // 중복되는 경우 하나씩 빠져줘야해서
        // while문 사용
        // while .length
        while (lotto.length < 6) {
            // 1~45까지 랜덤으로 뽑고 정수형으로 변환 하여 num에 저장
            var num = parseInt(Math.random() * 45 + 1);
            // 배열에 들어있는 값을 indexOf를 활용해 검사 
            if (lotto.indexOf(num) == -1) {
                // == -1 값이 없다면 .push 를 활용해 값을 추가
                lotto.push(num);
            }
        }
        // .sort를 활용하여 lotto배열 안에 있는 값들을 (a,b) => a-b 활용해 오름차순 정렬
        lotto.sort((a,b) => a-b);
        // 화면에 출력 
        document.write(lotto);
</script>
```