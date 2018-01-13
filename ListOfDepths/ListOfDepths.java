package lisftofdepths;
import java.util.*;

public class ListOfDepths {
	
	public static void findDepths(Node root, HashMap<Integer, LinkedList> map, int depth) {
		//use preorder traveral to build linkedlists at depth
		if (map.get(depth) == null) {
			map.put(depth, new LinkedList(root.data));
		} else {
			LinkedList list = map.get(depth);
			list.add(root.data);
		}
		
		if (root.left != null) {
			findDepths(root.left, map, depth + 1);
		}
		if (root.right != null) {
			findDepths(root.right, map, depth + 1);
		}
		
		
	}

	public static void main(String[] args) {
		
		//instantiate and build tree
		Tree tree = new Tree(5);
		int[] data = {-5, 1, 8, 3, 4, 7, 12, 6, 2};
		for (int point: data) {
			tree.insert(point);
		}
		//hashmap of linkedlists
		HashMap<Integer, LinkedList> map = new HashMap<Integer, LinkedList>();
		
		findDepths(tree.root, map, 0);
		
		Set<Integer> keys = map.keySet();
		for(Integer key: keys) {
			System.out.println(map.get(key).toString());
		}
		
		System.out.println("--Done--");
		
 		
	}

}
