package ds.practice.model;

import java.util.Iterator;

public class DoublyLinkedListR <T> implements Iterable <T> {

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int size;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	public static class Node<T>
	{
		private T data;
		private Node<T> prev,next;
		
		public Node(T data, Node<T> prev,Node<T> next) 
		{
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		@Override
		public String toString() 
		{
			return data.toString();
		}
	}
	
	public void clear() {
		Node<T> trav = head;
		while(trav != null) 
		{
			Node<T> next = trav.next;
			trav.data = null;
			trav.next = trav.prev = null;
			trav = next;
		}
		head = tail = null;
		size = 0;
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size ==0;}
	
	public void add(T elem) {
		addLast(elem);	
	}
	
	public void addLast(T elem) 
	{
		if(isEmpty()) 
		{
			tail = head = new Node<T>(elem,null,null);
		}
		else 
		{
			tail.next = new Node<T>(elem,tail,null);
			tail = tail.next;
		}
		size++;
		
	}
	
	public void addFirst(T elem) 
	{
		if(isEmpty()) {
			head = tail = new Node<T>(elem,null,null);			
		}
		else {
			head.prev = new Node<T>(elem,null,head);
			head = head.prev;			
		}
		size ++;
	}
	
	public void addAt(int index, T elem) throws Exception
	{
		if(index <0 || size < index)
			throw new Exception("Invalid index"); 
		else if(isEmpty())
			head =tail = new Node<T>(elem,null,null);
		else if(index == 0)
			addFirst(elem);
		else if(index == size-1)
			addLast(elem);
					
		else{			
			
			int i;
			Node<T> trav;
			if(index <=size/2)
			{
			trav= head;
			for(i=0;i!=index;i++) {
				trav = trav.next;
			}			
			
			}
			else {	
				trav = tail;
				for(i=size;i!=index;i--) {
					trav = trav.prev;
				}
				
			}
			Node<T> new_Node = new Node<T>(elem,trav,trav.next);
			trav.next.prev= new_Node;	
			trav.next=new_Node;
			}
		size++;
		}
	public boolean removeAt(int index) 
	{
		if(isEmpty())
			return true;
		Node<T> trav;
		int i;
		if(index <= size/2) 
		{
			trav = head;
			for(i=0;i<index;i++) 
			{
				trav = trav.next;
			}
		}
		else 
		{
			trav= tail;
			for(i=0;i!=index;i--) 
			{
				trav= trav.prev;
			}
		}
		remove(trav);
		return true;
	}
	
	public T removeFirst() 
	{
		if(isEmpty()) throw new RuntimeException("List is empty");
		
		T Data = head.data;
		head= head.next;
		--size;
		
		if(isEmpty()) tail = null;
		else head.prev = null;
		
		return Data;
	}
	
	public T removeLast() 
	{
		if(isEmpty()) throw new RuntimeException("List is empty");
		
		T Data = tail.data;
		tail = tail.prev;
		--size;
		
		if(isEmpty()) head = null;
		else tail.next =null;
		return Data;
	}
	public T remove(Node<T> node) {
		if(node.next == null)
			removeLast();
		else if(node.prev == null)
			removeFirst();
		
		node.next.prev = node.prev;
		node.prev.next = node.next;
		--size;
			
		T Data = node.data;
		node = node.prev = node.next = null;
		return Data;
	}
	
	
	
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Node<T> trav = head;
		while(trav != null) {
			sb.append(trav.data);
			if(trav.next != null)
				sb.append(", ");
			trav = trav.next;
		}
		sb.append(" ]");
		return sb.toString();
	}
	}


