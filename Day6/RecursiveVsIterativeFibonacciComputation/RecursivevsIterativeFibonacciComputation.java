package Day6.RecursiveVsIterativeFibonacciComputation;

public class RecursivevsIterativeFibonacciComputation {
    public static int fibonacciRecursive(int n ){
        if(n<=1) return n;
        return  fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    public static int  fibonacciIterative(int n ){
        int a =0;
        int b =1;
        int sum;
        for(int i=2; i<=n; i++){
            sum = a+b;
            a= b;
            b= sum;
        }
        return b;
    }
    public static void main(String[] args) {
        long startTime , endTime ;
        startTime= System.nanoTime();
        int ans1= fibonacciRecursive(10);
        endTime= System.nanoTime();
        System.out.println("Fibonacci Recursive " + ans1 + " time :" + (endTime-startTime));
        startTime= System.nanoTime();
        int ans2 = fibonacciIterative(10);
        endTime= System.nanoTime();
        System.out.println("Fibonacci Iterative" + ans2 + "time :" + (endTime-startTime));

    }
}
