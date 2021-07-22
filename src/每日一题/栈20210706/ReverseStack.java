package 每日一题.栈20210706;

import java.util.Stack;

/**
 * @author hao.yang
 * @date 2021/7/7
 */
public class ReverseStack {
    // 1.递归函数移除一个栈栈底的元素并返回
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int res = stack.pop(); //res作为每一次递归的中间变量，通过压栈的方式可以帮我们保存下来
        //base case
        if (stack.isEmpty()) {
            return res;
        }
        //递归  递归函数执行完成之后会一层一层返回，每一层记录的res可以用于操作
        int last = getAndRemoveLastElement(stack);
        stack.push(res);
        return last;
        //
    }

    // 2.递归函数逆序一个栈
    public static void reverse(Stack<Integer> stack) {
        //base case
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        //递归reverse  每次压栈会保存i的值
        reverse(stack);
        //当栈空了之后刚好是原来栈的栈顶返回
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        reverse(stack);
        for (Object o : stack) {
            System.out.println(o);
        }
    }
}
