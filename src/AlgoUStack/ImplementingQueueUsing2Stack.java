//package AlgoUStack;
//
//public class ImplementingQueueUsing2Stack {
//	public static void main(String[] args) {
//		Stack<Integer> input = new Stack<Integer>(); 
//	    Stack<Integer> output = new Stack<Integer>(); 
//	    
//	    /*The method pop which return the element poped out of the stack*/
//	    int dequeue()
//	    {
//		    // Your code here
//		    while(!input.empty()){
//		        output.push(input.pop());
//		    }
//		    int ans = output.pop();
//		    while(!output.empty()){
//		        input.push(output.pop());
//		    }
//		    return ans;
//	    }
//		
//	    /* The method push to push element into the stack */
//	    void enqueue(int x)
//	    {
//		    // Your code here
//		    input.push(x);
//	    }
//	}
//}
