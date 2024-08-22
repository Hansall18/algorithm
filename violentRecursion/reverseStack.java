package violentRecursion;

import java.util.Stack;

//逆序栈，要求只能使用递归，不能使用其他空间
public class reverseStack {
    //获取并删除栈中的最底层元素
    public static int getAndRemoveLastData(Stack<Integer> stack){
        int res = stack.pop();
        if (stack.isEmpty()) return res;
        int last = getAndRemoveLastData(stack);
        stack.push(res);
        return last;
    }
    //递归pop，空返回
    //每一次返回后，将获取的最底层元素重新push
    public static void process(Stack<Integer> stack){
        if (stack.isEmpty()) return;
        int tmp = getAndRemoveLastData(stack);
        process(stack);
        stack.push(tmp);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        process(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
