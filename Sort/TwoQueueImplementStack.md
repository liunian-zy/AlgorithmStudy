# 两个队列实现栈

使用两个队列来回倒，一个push队列，一个pop队列。push时就正常向push队列存数据，pop时将push队列所有元素只留一个其余全部pop出来并push到pop队列中，剩余的就是要返回的数据，返回后将push、pop队列交换一下以便下次继续执行。

* 面试会考使用队列实现图的深度优先遍历

代码实现：

```java
public static class TwoQueueStack<T> {
    public Queue<T> queue;
    public Queue<T> help;

    public TwoQueueStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(T value) {
        queue.offer(value);
    }

    public T poll() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T ans = queue.poll();
        Queue<T> tmp = queue;
        queue = help;
        help = tmp;
        return ans;
    }

    public T peek() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T ans = queue.poll();
        help.offer(ans);
        Queue<T> tmp = queue;
        queue = help;
        help = tmp;
        return ans;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

}
```

