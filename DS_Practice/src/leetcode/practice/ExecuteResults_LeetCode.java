package leetcode.practice;

public class ExecuteResults_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode();
		node.val = 1;
		node.next = new ListNode(0);
		node.next.next = new ListNode(1);
		node.next.next.next = new ListNode(0);
		
//		@SuppressWarnings("unused")
		
		int decimalVal = getDecimalValue(node);
		int decimalValB = getDecimalValue_Binary(node);
		System.out.println(decimalVal);
		System.out.println(decimalValB);
		
		int maxPower = maxPower_Cons("aabcbbcccdc");
		System.out.println("max :"+maxPower);

	}

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	// To print the decimal value using shit left operator
	    public static int getDecimalValue(ListNode head) {
	       int num = head.val;
	        while (head.next != null) {
	            num = (num << 1) | head.next.val;
	            head = head.next;    
	        }
	        return num; 
	    }
	    // To print the decimal value using arithmetic operations 
	    public static int getDecimalValue_Binary(ListNode head) 
	    {
	    	int num = head.val;
//	    	int base = 1;
	    	
	    	while(head.next != null) 
	    	{
//	    		base = base*2;
	    		num = num*2 + head.next.val;
	    		
	    		head = head.next;
	    	}
	    	
	    	return num;
	    }
	    
	    //Fist try - prints the max count of characters in the entire string 
	    public static int maxPower(String s) {
	        	int maxVal;
	        	
	        	int[] power = new int[s.length()];
	        	char[] ch = new char[s.length()];
	        	
	        	for(int i=0;i<s.length();i++) 
	        	{
	        		power[i] = 1;
	        		int index = contains(s.charAt(i),ch);
	        		if(index > -1) 
	        		{
	        				power[index] ++;
	        			
	        		}
	        		else {
	        			power[i] ++;
	        		}
	        		ch[i] = s.charAt(i);
	        	}
	        	maxVal = power[0]; 
	            for(int i=1;i < power.length;i++){ 
	              if(power[i] > maxVal){ 
	                 maxVal = power[i]; 
	              } 
	            } 
	        	return maxVal;
	            
	        }
	    static int contains(char c, char[] array) {
	            int index = -1;
	            int previous = 0;
	        	for (int i=0;i<array.length;i++) 
	        	{
	        		if(i>0 && array[i] == c && array[i--] ==c) {
	        			return index = i;	        		
	        		
	        		}
	        
	        	}
	            return index;
	        }
	    
	    //Prints max count of consecutive characters
	    public static int maxPower_Cons(String s) {
	    	int maxVal =0;
        	int count = 1;
        	char[] ch = new char[s.length()];
        	
        	for(int i=0;i<s.length();i++) 
        	{
        		ch[i] = s.charAt(i);
        		
        		if(i > 0) 
        		{
        			if(ch[i-1] == s.charAt(i))
        				count ++;
        			else 
        				count =1;
        			if(count > maxVal)         			
        				maxVal = count;      			
        		}
        		else 
        			maxVal = count;
        		
        	}
        	return maxVal;
	    }
}

