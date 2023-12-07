# Queue
- [Queue](#queue-)
- [LinkedList](day16-2.md)
- [BreadthFirstSearch](day16-3.md)
  
## Queue  
대기열처럼 작동하는 자료구조
- 자료가 일렬로 놓인 산형 자료구조
- 제일 먼저 추가된 자료가 먼저 나오는 선입선출 자료구조 (First In First Out)

  
### 스택과 Queue 의 차이점
- 스택 : 후입선출 LIFO  
- Queue : 선입선출 IFO

  
## Queue 의 기본 기능 
- enQueue : 데이터 추가
- deQueue : 데이터 회수
- isEmpty : 비었는 지 확인
- peek : 제일 앞에 있는 데이터를 확인
- isFull : 가득 차있는 지 확인 ( 고정된 배열을 사용하는 경우 )
- 

## 선형 Queue 
```java

public class MyQueue {
    //데이터를 담기 위한 배열
    private int[] arr = new int[16];
    //제일 앞의 데이터가 어딘지 front(데이터를 뺄 때 어디의 데이터를 뺄지를 결정하는)
    private int front = -1;
    //제일 뒤의 데이터가 어딘지 reer(데이터를 넣을 때 어디에 데이터를 넣을지를 결정하는)
    private int rear = -1;

    //데이터를 큐에 담기 위한 enQueue
    public void enQueue (int x){
        //넣어줄 공간을 설정하고,
        rear++;
        //해당 위치에 넣어준다.
        arr[rear] = x;
    }
    //데이터를 큐에서 꺼내기 위한 deQueue
    public int deQueue(){
        //데이터를 가져올 공간을 설정하고,
        front++;
        //해당 위치에서 가져온다.
        return arr[front];
    }
    //큐가 비어있는지 확인하기 위한 isEmpty()
    public boolean isEmpty(){
        return this.front ==this.rear;
    }

    //큐가 채워져있는지를 확인하기 위한 isFull()
    public boolean isFull(){
        //front가 이동한 상황은 고려가 되지 않는다.
        return this.rear ==arr.length -1;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(10);
        myQueue.enQueue(11);
        myQueue.enQueue(12);
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.isEmpty());

        for (int i = 0; i <13 ; i++) {
            myQueue.enQueue(i);
        }
        //들어있는 데이터는 12개
        System.out.println(myQueue.deQueue());
        //남은 공간이 4칸이어도 가득찼다고 인식한다.
        System.out.println(myQueue.isFull());

    }
```

문제점 !  
front 와 rear 가 뒤쪽까지 이동하면서 앞쪽의 공간이 남았지만 가득 찼다고 인식한다.  
즉, 큐의 앞부분에 공간이 있음에도 불고하고 `rear` 이 배열 끝에 도달하면 더 이상 새 요소를 추가할 수 없다 !
  
## 원형 Queue
![원형queue](원형%20queue.png)  

- enQueue -> rear 에 (rear + 1) % size 후 arr[rear] 에 할당
- deQueue -> front 에 (front + 1) % size 후 arr[front] 에 할당

실제 사이즈보다 배열의 크기가 하나 더 커야 한다 .
가득 찼는지 알기 위해 front 의 위치를 비워두어야 하기 때문이다

-> isFull()을 구현한다면 ( rear + 1 ) % size가 front 와 동일한 지 비교하면 된다.  

```java
public class MyCyQueue {
    //크기를 4로 먼저 만들어보자.
    private int size = 4;
    //실제로 만들 배열의 크기는 size +1

    private int offset = size +1;
    //데이터를 담기 위한 배열
    private int[] arr = new int[offset];
    // 앞쪽과 뒤쪽 데이터를 구분하기 위한 front와 rear
    private int front =0;
    private int rear = 0;

    //데이터를 넣기 위한 enQueue
    public void enQueue(int x){
        arr[rear] = x;
        //위치 재설정
        rear = (rear+1)% offset;
    }
    //데이터를 빼기 위한 deQueue
    public int deQueue(){
        //현재 위치의 값을 회수
        int value = arr[front];
        //위치 재설정
        front = (front+1) % offset;
        return value;
    }
    //큐가 비어있는지 확인하기 위한 isEmpty( )
    public boolean isEmpty(){
        return rear == front;
    }
    //큐가 가득 차있는지를 확인하기 위한 isFull()
    public boolean isFull(){
    //다음번에 넣을 곳이 front라면 가득 차있는 상태이다.
        return (rear + 1) % offset == front;
    }
    public static void main(String[] args) {
    }
```
