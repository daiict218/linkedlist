
public class stack {
	int n;
	int top=-1;
	int array[];
	public stack(int n)
	{
		this.n = n;
		array = new int[n];
	}
	
	public boolean isEmpty()
	{
		if(top == -1)
		{
			return true;
		}
		return false;
	}
	
	public void push(int data)
	{
		if(top == n-1)
		{
			System.out.println("Stack Overflow error");
			return ;
		}
		array[++top] = data;
	}
	
	public int pop()
	{
		if(top == -1)
		{
			System.out.println("Stack Underflow error");
			return 0;
		}
		return array[top--];
	}
}
