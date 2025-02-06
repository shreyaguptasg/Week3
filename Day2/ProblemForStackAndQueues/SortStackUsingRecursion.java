package Day2.ProblemForHashMapAndFunctions.ProblemForStackAndQueues;
import java.util.Stack;

class SortStack{
    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int temp = stack.pop();
            sortStack(stack);
            insertSortStack(stack, temp);
        }
    }
    public  static void insertSortStack(Stack<Integer> stack, int elemnet){
        if(stack.isEmpty() || stack.peek()<=elemnet){
            stack.push(elemnet);
        }
        else{
            int temp = stack.pop();
            insertSortStack(stack, elemnet);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println(stack);
        System.out.println("Original Stack: " + stack);
        SortStack.sortStack(stack);
        System.out.println("Sorted Stack: " + stack);

    }
}
