package ds.practice.model;

import java.util.Iterator;

//import com.williamfiset.datastructures.priorityqueue.BinaryHeap;
//import com.williamfiset.datastructures.unionfind;
//import com.williamfiset.datastructures.unionfind.UnionFind;
import com.williamfiset.datastructures.binarysearchtree.BinarySearchTree;
import com.williamfiset.datastructures.binarysearchtree.TreeTraversalOrder;
public class ExecuteResults {
	
	public static void main(String args[]) 
	{
		System.out.println("Hello World");
		try {
		//DoublyLinkedList ddList = new DoublyLinkedList();
		//ddList.addAt(2, 3);
		
		//Dynamic Array
//		DynamicArray<Integer> dArr = new DynamicArray<Integer>(4);
//		dArr.add(1);
//		dArr.add(2);
//		dArr.add(3);
//		String outPut = dArr.toString();
//		System.out.println("Array is - " + outPut);
//		
		//Doubly Linked List
//		DoublyLinkedListR<Integer> dLst = new DoublyLinkedListR<Integer>();
		
//		dLst.addFirst(10);
//		dLst.addLast(20);
//		dLst.add(30);
//		dLst.add(40);
//		dLst.add(50);;
//		dLst.add(60);
//	    dLst.addAt(2, 100);	
//		System.out.println(dLst.toString());
//		System.out.println(dLst.size());
//		dLst.removeAt(2);
//		int returnVal = dLst.removeFirst();
//		System.out.println(dLst.toString());
//		System.out.println(returnVal);
//		
//		IntStack sT = new IntStack(5);
//		sT.push(10);
//		sT.push(20);
//		sT.push(30);
//		sT.pop();
//		System.out.println(sT.toString());
//		
//		BinaryHeap<Integer> bHeap = new BinaryHeap<Integer>(6);
//		bHeap.add(5);
//		bHeap.add(7);
//		bHeap.add(1);
//		bHeap.add(2);
//		bHeap.add(3);
//		bHeap.add(9);
		//bHeap.add(2);
		
		//System.out.println("Heap is - "+bHeap.toString());
		//bHeap.removeAt(1);
		//System.out.println("Heap is - "+bHeap.toString());
//		UnionFind uf = new UnionFind(10);
//		System.out.println("Root -"+ uf.find(3));
//		uf.unify(2, 3);
//		uf.unify(3, 4);
//		uf.unify(7, 8);
//		uf.unify(8, 3);
//		System.out.println("Root -"+ uf.find(3));
		
		//UnionFind(10);
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(20);
		bst.add(15);
		bst.add(18);
		bst.add(21);
		bst.add(27);
		bst.add(6);
		bst.add(2);
		bst.add(5);
		
//		TreeTraversalOrder Lst= TreeTraversalOrder.PRE_ORDER;
		Iterator Lst = bst.traverse(TreeTraversalOrder.PRE_ORDER); 
		
		while(Lst.hasNext()) 
		{
			System.out.println(Lst.next() + ",");
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}

}
