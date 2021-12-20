# 获取栈中最小值

#### 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作

要求：

* pop、push、getMin操作的时间复杂度都是O(1)
* 设计的栈类型可以使用现成的栈结构

方法一：使用两个栈，一个栈正常记录数据，一个栈记录最小值。push操作时与最小栈栈顶元素比较，小于则压入最小栈，pop操作时与最小栈栈顶元素比较，相等则同步pop最小栈。getMin则直接peek最小栈即可。

方法二：使用两个栈，一个栈正常记录数据，一个栈记录最小值。push操作时与最小栈栈顶元素比较，小于则压入最小栈，否则重复压入最小栈栈顶元素，pop操作时同步pop最小栈。getMin则直接peek最小栈即可。

两种方法都可以实现题目要求。

代码实现：

```java
// 方法一
public static class MyStack1 {
    private final Stack<Integer> stackData;
    private final Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }
}

// 方法二
public static class MyStack2 {
    private final Stack<Integer> stackData;
    private final Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getmin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }
}
```

