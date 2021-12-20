# 栈和队列

#### 双向链表实现栈和队列

实现双端队列：可以从头进，从尾出，也可以从尾进，从头出。使用两个变量``head``，``tail``来记录头节点和尾节点。

* 从头进：如果当前头节点不为空，则将进来的元素next指向头节点，头节点last指向次元素，否则次元素即为头节点，``head``和``tail``指向新头节点和新头节点（如果原头节点为空）。
* 从头出：如果头节点不为空返回头节点数值，然后更新``head``和``tail``（如果只有一个元素）的指向。
* 从尾进：如果头节点不为空，``tail``next指向新进来的节点，新节点last指向``tail``，否则``head``和``tail``均指向新进来的节点。
* 从尾出：如果头节点不为空返回尾结点数值，然后更新``head``（如果只有一个元素）和``tail``的指向。

实现栈：先进后出，后进先出。使用刚刚的实现的队列的从头进、从头出即可实现栈的``push``和``pop``。

#### 数组实现栈和队列

栈：固定长度数组或者动态数组，定义一个变量index记录下一个要进来的元素下标，初始值为0，如果index==数组长度或者==-1，报异常。push操作index++，pop操作index--。

队列：使用循环数组（RingArray）实现。定义一个变量size记录数组长度，push操作size++，pop操作size--，0和数组长度是边界值。再定义两个变量记录push的位置和pop的位置，每次push后push位置变量进行++，遇到边界重新归位0，pop同理。

代码实现：

```java
// 数组实现栈
public static class MyStack {
    private final int limit;
    private final int[] arr;
    private int index;

    public MyStack(int limit) {
        this.limit = limit;
        this.arr = new int[this.limit];
        this.index = 0;
    }

    public void push(int num) {
        if (index == limit) {
            throw new RuntimeException("栈满啦！");
        }
        arr[index] = num;
        index++;
    }

    public int pop() {
        index--;
        if (index == -1) {
            throw new RuntimeException("栈空啦！");
        }
        return arr[index];
    }

}

// 数组实现队列（循环数组）
public static class MyQueue {
    private final int[] arr;
    private int pushi;// end
    private int polli;// begin
    private int size;
    private final int limit;

    public MyQueue(int limit) {
        arr = new int[limit];
        pushi = 0;
        polli = 0;
        size = 0;
        this.limit = limit;
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("队列满了，不能再加了");
        }
        size++;
        arr[pushi] = value;
        pushi = nextIndex(pushi);
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("队列空了，不能再拿了");
        }
        size--;
        int ans = arr[polli];
        polli = nextIndex(polli);
        return ans;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 如果现在的下标是i，返回下一个位置
    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }
}
```

