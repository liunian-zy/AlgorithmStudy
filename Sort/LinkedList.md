# 链表

#### 单链表

```java
public class Node {
    public int value;
    public Node next;
    public Node(int data) {
        value = data;
    }
}
```

#### 双链表

```java
public class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        value = data;
    }
}
```

#### 简单练习

```java
// 单链表的反转
public static Node reverseLinkedList(Node head) {
    Node pre = null;
    Node next = null;
    while (head != null) {
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
}

// 双链表的反转
public static DoubleNode reverseDoubleList(DoubleNode head) {
    DoubleNode pre = null;
    DoubleNode next = null;
    while (head != null) {
        next = head.next;
        head.next = pre;
        head.last = next;
        pre = head;
        head = next;
    }
    return pre;
}

// 删除给定链表中所有值为num的元素
public static Node removeValue(Node head, int value) {
    // 先确定头节点，即排除掉头节点即为value的情况
    while (head != null) {
        if (head.value != value) {
            break;
        }
        head = head.next;
    }
    // 遍历
    Node pre = head; // 上一个节点
    Node current = head; // 当前节点
    while (current != null) { // 当前节点有值
        if (current.value == value) { // 当前节点为欲删除值
            pre.next = current.next; // 将上一个节点的next赋值为下一节点
        } else {
            pre = current;
        }
        current = current.next; // 当前节点继续向后走
    }
    return head;
}
```

