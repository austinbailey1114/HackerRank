package sortstack;
import java.util.*;
public class SortStack {
	
	public static void sortstack(Stack<Integer> stack) {
		//create temporary stack
		Stack<Integer> tempStack = new Stack<Integer>();
		//track number of iterations
		int count = 0;
		//constant size of stack
		int size = stack.size();
		
		//while the number of iterations is less than the size of the stack
		while (count < size) {
			//set min to top by default
			int min = stack.peek();
			//find the min in the unsorted part of the stack while pushing it back over
			for(int i = 0; i < size - count; i++) {				
				Integer temp = stack.pop();
				
				if (temp < min) min = temp;
				tempStack.push(temp);
				
			}
			
			//push the min onto the bottom of the stack
			stack.push(min);
							
			//put all elements back on the stack except the min, because it is already there. this part builds the unsorted part of the stack
			while (!tempStack.isEmpty()) {
				int temp = tempStack.pop();
				if (temp != min) stack.push(temp);
			}
			
			count++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(6);
		stack.push(12);
		stack.push(1);
		stack.push(52);
		stack.push(9);
		
		System.out.println("Before sort: " + stack);
		
		sortstack(stack);
		
		System.out.println("After sort: "  + stack);
		
	}

}
