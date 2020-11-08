package ds.practice.model;

public class IntStack implements Stack<Integer> {
	private int arr[];
	private int pos;
	
	public IntStack(int maxSize)
	{
		arr = new int[maxSize];
	}
	
	public int size() { return pos;}
	
	public boolean isEmpty() {return pos ==0;}
	
	public int peek() {return arr[pos-1];}
	
	public void push(int elem) {arr[pos++]=elem;}
	
	public int pop() {	return  arr[--pos];}
	
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		if(pos == 0)
			throw new RuntimeException("Empty stack");
		else
			sb.append("[");
		for(int i=0;i<pos;i++) 
		{
			sb.append(arr[i]);
			if(i< (pos -1))
				sb.append(",");				
		}
		sb.append("]");
		
		return sb.toString();
	}
}
