# 마크다운을 연습해보자  

마크다운은 대표적인 마크업 언이 이다. 
#은 문단 제목, 문단 구분, 그 아래 작성되는 그냥 글은 문단 내용

두번째 문단을 만들어 보자 엔터 두번해야 새로운 문단이 된다.

세번째 문단은 이렇다. 스페이스 두개 후 엔터  
해도 줄은 바뀐다.

엔터 두 번 -> 문단 구분  
스페이스 두 번,  엔터 한 번 -> 줄 바꿈

## Heading 2
샵 (#)이 많을수록 더 낮은 레벨의 제목

### Heading 3
다른 말로 더 작은 문단 제목


## 글자 꾸미는 법 

1. 기울임  

*정유진* 별 1개  

2. 강조   

**정유진** 별 2개  

3. 둘 다    

***정유진*** 별 3개

4. 취소선    

~~정유진~~  취소선

## 목록 문법  

- 대시 하나 당
- 목록의 아이템을 추가
- 이걸 목록이라 부름 (List)
* 별도 목록 구성 가능
+ 플러스도 목록 구성 가능
- 섞어도 원칙적으로 상관 없음
* ~~하지만 하지말자~~
+ ~~하나로 통일할 것~~

1. 번호도 
2. 똑같음
3. 대시 , 번호 둘 다 문단 안에서 들여쓰기 느낌으로 기본 문단과 다름.

### 하위 목록 가능
1. 예를 들어    
    1.이렇게 탭을 이용하여  
    2.사용한다      
    3.탭 1 -> space 4칸 


## Markdown

문단 내부에 소스코드를 표현하고 싶다면 백틱을 써준다.

`System.out.println("Hello World!");` 그러면 동일 간격 글자로, 색을 바꿔 소스코드임을 markdown이 알려줌.

만약 여러줄의 코드로 표현하고 싶다면 세 개를 써보자.

```
public class Main {
    publci static void main() {
        System.out.println("Hello World!");
    }
}
```

Github 같은 경우 어떤 언어로 된 코드인지도 작성할 수 있다.

```java
public class Main {
    publci static void main() {
        System.out.println("Hello World!");
    }
}
```

## 링크

가장 간단한 링크 만들기 <https://www.naver.com>

문구에 링크 추가하기 [네이버(문구)](https://www.naver.com)

## 이미지

이미지는 다음과 같이 넣을 수 있습니다.

![컴퓨터 이미지](computer.png)

웹에서 가져온 이미지  

![Java](https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/120px-Spring_Boot.svg.png)