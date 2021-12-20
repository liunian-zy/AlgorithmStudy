public class ArrayToStack {

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

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        try {

            myStack.push(1);
            myStack.push(2);
            myStack.push(3);
            myStack.push(4);
            myStack.push(5);
            myStack.push(6);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================");
        try {
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}
