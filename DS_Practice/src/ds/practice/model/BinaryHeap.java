package ds.practice.model;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap <T extends Comparable<T>>{
	private int heapCapacity =0;
	private int heapSize =0;
	
	private List<T> heap= null;
	public BinaryHeap(int sz) {
		heap = new ArrayList<>(sz);
	}
	
	public void add(T elem) 
	{
		if(elem == null) throw new IllegalArgumentException();
		
		if(heapCapacity<heapSize)
			heap.set(heapSize,elem);
		else 
		{
			heap.add(elem);
			heapCapacity++;
		}
		
		Swim(heapSize);
		heapSize++;
	}
	
	public void Swim(int k) 
	{
		int parent = (k-1)/2;
		
		while(k>0 && Less(k,parent)) 
		{
			Swap(k,parent);
			k= parent;
			
			parent = (k-1)/2;
		}
	}
	
	public boolean Less(int i, int j) 
	{
		T node_i = heap.get(i);
		T node_j = heap.get(j);
		
		return node_i.compareTo(node_j) <=0;
	}
	
	public void Swap(int i, int j) 
	{
		T elem_i = heap.get(i);
		T elem_j = heap.get(j);
		
		heap.set(i,elem_j);
		heap.set(j, elem_i);
	}
	
	public T removeAt(int pos) 
	{
		if(isEmpty())
			return null;
		heapSize--;
		
		T removed_Data = heap.get(pos);
		Swap(pos,heapSize);
		heap.set(heapSize, null);
		
		if(heapSize == pos) return removed_Data;
		
		int right_child = (pos*2) + 2;
		int left_childe = (pos*2) + 1;
		
		while(Less(pos,right_child)) {
		Swim(pos);
		
		}
		return removed_Data;
		
	}
	
	public boolean isEmpty() 
	{
		return heapSize ==0;
	}
	
	@Override
	public String toString() 
	{
		return heap.toString();
	}

}
