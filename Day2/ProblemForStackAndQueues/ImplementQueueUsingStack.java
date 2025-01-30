package Day2.ProblemForHashMapAndFunctions.ProblemForStackAndQueues;
import java.util.Stack;

class QueueUsingStack{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2= new Stack<>();
    //push operation
    public void enque(int data){
        stack1.push(data);
    }
    //pop operation
    public int deque(){
        if(stack1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }
    //peek operation
    public int peek(){
        if(stack1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int val= stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return val;
    }
}
public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        System.out.println("Peek is : " + queue.peek());
        System.out.println("Dequeue is :" + queue.deque());
        queue.enque(9);
        System.out.println("Peek is : " + queue.peek());
    }
}
