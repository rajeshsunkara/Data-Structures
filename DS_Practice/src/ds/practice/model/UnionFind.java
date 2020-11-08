package ds.practice.model;

public class UnionFind {
	
	private int size;
	private int sz[];
	private int id[];
	private int numComponents;
	
	public UnionFind(int Size) 
	{
		if(size<0) throw new IllegalArgumentException();
		
		this.size = this.numComponents = Size;
		sz = new int[Size];
		id= new int[size];
		
		for(int i=0;i<Size;i++) 
		{
			id[i]= i;
			sz[i] =1;
		}
	}
	
	public int Find(int p)
	{
		int root = p;
		
		while(root != id[root]) root=id[root];
		
		while(p!=root)
		{
			int next = id[p];
			id[p] = root;
			p= next;
		}
		return root;
	}
	
	public void Unify(int p,int q) 
	{
		int root1= Find(p);
		int root2 = Find(q);
		
		if(root1 == root2) return;
		
		if(sz[root1] < sz[root2]) 
		{
			sz[root2] += sz[root1];
			id[root1] = root2;
		}
		else 
		{
			sz[root1] += sz[root2];
			id[root2] = root1;
		}
		numComponents --;
	}
	
	public boolean Connected(int p, int q) 
	{
		return Find(p) == Find(q);
	}
	
	public int componentSize(int p)
	{
		return sz[p];
	}
	
	public int components() 
	{
		return numComponents;
	}
	
	public int size() 
	{
		return size;
	}

}
