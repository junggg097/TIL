# Brute Force
- [순열](#순열)
- [조합](day17-1.md)
- [Powerset](day17-2.md)


## Brute Force

Brute -> 무분별한, 짐승의, Force -> 힘   
Brute Force 알고리즘 -> 무작정 가능한 모든 경우를 다 검사하는 알고리즘 !!!

방법 -> Simple!!  

모든 경우의 수 확인 -> 컴퓨터 (Force)
-  경우의 수가 상대적으로 작을 때 유용, 경우의 수가 늘어나기 시작하면 수행속도가 느려지기 시작
- 해답을 찾아내지 못할 가능성이 적기 때문에 문제 해답이 떠오르지 않을 때 우선 접근해볼 방법
  - 이후 다른 기법(Greedy, DP 등 ) 으로 최적화 가능


## 순열
- [for문 활용](#단순한-순열-제작---for-반복문-활용)
- [재귀함수 활용](#단순한-순열-제작---재귀함수-활용)

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
 - EX ) 야구 게임
```java
// 0 ~ n -1  의 숫자로 만들 수 있는 3가지 숫자 나열 전부 출력하는 메서드
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

### 단순한 순열 제작 - 재귀함수 활용
for 문을 활용하면 r 이 증가하면 for 반복을 동적으로 더 많이 만들어주어야 한다   
재귀함수를 활용하면 코드를 효율적으로 줄일 수 있다 !!
```java
    // 재귀함수로 더 많은 원소를 선택하는 순열을 만들어보자.
    public static void permRecurHelper(
            // 순열을 구할 때 필요한거 : 고르는 대상 , 고르는 갯수
            int n , int r,
            // 내가 지금 몇 번째 원소를 고르고 있는지
            int depth,
            // 어떤 요소들을 사용했는 지 저장하는 배열
            boolean[] used,
            // 결과를 저장하기 위한 배열
            int[] perm
    ) {
        // 내가 고른것의 갯수가 고를 것의 개수와 같아지면 중단.
        if (depth == r) {
            System.out.println(Arrays.toString(perm));
        }
        else {
            // n 개의 원소 중 하나를 선택하는 for
            for ( int i = 0; i < n; i++) {
                // 이미 선택했다면 스킵
                if (used[i]) continue;
                // 선택을 할 때 first = i; 의 형태로 작성했던 부분
                perm[depth] = i;
                // 내가 이번에 i 를 선택했다는 걸 기록
                used[i] = true;
                // 중첩된 for 대산 재귀 호출
                permRecurHelper(n, r, depth + 1, used, perm);
                // 이 i에서 출발하는 순열을 다 찾으면 , 다음 i 를 쓰기 위해 기록 변경
                used[i] = false;
            }
        }
    }

    // 사용성을 위해 실제 메서드를 분리한다. (n, r 만 있어도 실행 되게끔 )
    public static void permRecursive(int n , int r) {
        permRecurHelper(n , r , 0 , new boolean[n], new int[r]);
    }

    public static void main(String[] args) {
        permRecursive(4 ,2);
    }

```
```java
// 실행 결과
[0, 1]
[0, 2]
[0, 3]
[1, 0]
[1, 2]
[1, 3]
[2, 0]
[2, 1]
[2, 3]
[3, 0]
[3, 1]
[3, 2]
```


