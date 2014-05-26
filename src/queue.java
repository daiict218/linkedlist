
public class queue {
	int n;
	int head;
	int tail;
	int array[];
	public queue(int n)
	{
		this.n = n;
		this.head = 0;
		this.tail = 0;
		array = new int[n];
	}
	
	public boolean isEmpty()
	{
		if(head == tail)
		{
			return true;
		}
		return false;
	}
	
	public void enqueue(int data)
	{
		if((tail + 1) % n == head)
		{
			System.out.println("Queue Overflows");
			return ;
		}
		if(tail == n-1)
		{
			array[tail]=data;
			tail = (tail + 1) % n;
		}
		else
		{
			array[tail++]=data;
		}
	}
	
	public int dequeue()
	{
		if(head == tail)
		{
			System.out.println("Queue Underflows");
			return 0;
		}
		int x = array[head];
		if(head == n-1)
		{
			head = 0;
		}
		else
		{
			head++;
		}
		return x;
	}
}
