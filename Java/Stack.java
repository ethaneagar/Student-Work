import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
	
	 public static void main(String[] args) {
	
		// safer stack, as Deque class
		Deque<Integer> betterStack = new ArrayDeque<Integer>();
											
		// build stack
		for (int i = 0; i < 5; i++) {
			betterStack.push(i * 10);
		}
		
		// print stack
		System.out.println ("Stack = " + betterStack);
	
		// peek top value
		System.out.println ("Top value = " + betterStack.peek());
			
		// empty stack
	        while(!betterStack.isEmpty()) {
		        System.out.println("Popped value = " + betterStack.pop());
	        }		
				
		// using isEmpty method
		if (betterStack.isEmpty()) {
			System.out.println ("Stack is empty");
		}
		else {
			System.out.println ("Stack is not empty");			
		}
	}	
}
