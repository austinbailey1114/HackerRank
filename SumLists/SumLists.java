package linkedlists;

public class SumLists {
	
	public static int sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		
		int sum = 0;
		
		int counter = 0;
		//cycle through each list, since we know the digits go in ascending order, add by 10^position
		//this allows for lists (ints) of different lengths unlike a stack solution
		while (!list1.isEmpty()) {
			sum += list1.head.data * (Math.pow(10, counter));
			list1.removeHead();
			counter++;
		}
		
		counter = 0;
		while (!list2.isEmpty()) {
			sum += list2.head.data * (Math.pow(10, counter));
			list2.removeHead();
			counter++;
		}		
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list1 = new LinkedList<Integer>(7);
		list1.insert(1);
		list1.insert(6);
		list1.insert(1);
		
		LinkedList<Integer> list2 = new LinkedList<Integer>(5);
		list2.insert(9);
		list2.insert(2);
		
		System.out.println(sumLists(list1, list2));
		
		
	}

}
