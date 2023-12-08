# Brute Force
- 순열
- 조합
- Powerset


## Brute Force

Brute -> 무분별한, 짐승의, Force -> 힘   
Brute Force 알고리즘 -> 무작정 가능한 모든 경우를 다 검사하는 알고리즘 !!!

방법 -> Simple!!  

모든 경우의 수 확인 -> 컴퓨터 (Force)
-  경우의 수가 상대적으로 작을 때 유용, 경우의 수가 늘어나기 시작하면 수행속도가 느려지기 시작
- 해답을 찾아내지 못할 가능성이 적기 때문에 문제 해답이 떠오르지 않을 때 우선 접근해볼 방법
  - 이후 다른 기법(Greedy, DP 등 ) 으로 최적화 가능


## 순열

![순열](순열.PNG)
  
주어진 요소들의 순서를 정하고 , 해당 순서의 비용이 최적인지 판단하는 알고리즘   
  
### 단순한 순열 제작 - for 반복문 활용

- 0 ~ 2 까지 숫자를 나열하는 경우
```java
public class Permutation {

    // 0 ~ 2 의 숫자로 만들 수 있는 숫자 나열 전부 출력하는 메서드
    public static void perSimple() {
        int first;
        int second;
        int third;
        // 0에서 2사이의 숫자를 차례대로 골라본다.
        for (int i =0; i < 3; i++) {
            // 첫 번째 숫자를 골랐음
            first = i;
            // 0에서 2사이의 숫자 중 , 아직 고르지 않은 숫자를 골라본다.
            for ( int j=0; j < 3; j++){
                // 이미 고른 숫자라면 나머지는 실행하지 않는다.
                if (j ==first) {
                    continue;
                }
                second = j;
                // 0 에서 2 사이의 숫자 중 , 아직 고르지 않은 숫자를 골라본다.
                for (int k =0; k < 3; k++) {
                    if (k== first || k == second) {
                        continue;
                    }
                    third = k;
                    System.out.println(first + " " + second + " " + third);
                }
            }
        }
    }

    public static void main(String[] args) {
        perSimple();
    }
}

```
```java
// 실행 결과
0 1 2
0 2 1
1 0 2
1 2 0
2 0 1
2 1 0
```
 - 0 ~ n -1 의 숫자로 나열 하려면 매개변수 n 추가 !
```java
// 0 ~ n -1  의 숫자로 만들 수 있는 숫자 나열 전부 출력하는 메서드
    public static void perSimple(int n) {
        int first;
        int second;
        int third;
        // 0에서 n사이의 숫자를 차례대로 골라본다.
        for (int i =0; i < n; i++) {
            // 첫 번째 숫자를 골랐음
            first = i;
            // 0에서 n사이의 숫자 중 , 아직 고르지 않은 숫자를 골라본다.
            for ( int j=0; j < n; j++){
                // 이미 고른 숫자라면 나머지는 실행하지 않는다.
                if (j ==first) {
                    continue;
                }
                second = j;
                // 0 에서 n 사이의 숫자 중 , 아직 고르지 않은 숫자를 골라본다.
                for (int k =0; k < n; k++) {
                    if (k== first || k == second) {
                        continue;
                    }
                    third = k;
                    System.out.println(first + " " + second + " " + third);
                }
            }
        }
    }

    public static void main(String[] args) {
        perSimple(9);
    }
}

```