
public class linkedlist {
	Node head;
	Node tail;
	public linkedlist()
	{
		head = null;
		tail = null;
	}
	
	public void insertSort(int data)
	{
		Node nodetoadd = new Node(data);
		int y = 0;
		if(head == null)
		{
			head = nodetoadd;
			tail = nodetoadd;
			nodetoadd.setIndex(y);
		}
		else
		{
			if(head == tail)
			{
				if(nodetoadd.getData() < head.getData())
				{
					insertAtStart(data);
				}
				else
				{
					insertAtEnd(data);
				}
			}
			else
			{
				if(tail.getData() < nodetoadd.getData())
				{
					insertAtEnd(data);
				}
				else
				{
					Node temp = head;
					Node prev = temp;
					int x = 0;
					while(temp!=null)
					{
						
						if(nodetoadd.getData()>temp.getData())
						{
							x++;
							prev = temp;
							temp = temp.getNext();
							continue;
						}
						else
						{
							if(x==0)
							{
								insertAtStart(data);
								break;
							}
							prev.setNext(nodetoadd);
							nodetoadd.setNext(temp);
							break;
						}
					}
				}
			}
		}
		adjustindex();
	}
	
	public void insertAtStart(int data)
	{
		int y = 0;
		Node nodetoadd = new Node(data);
		if(head==null)
		{
			head = nodetoadd;
			tail = nodetoadd;
			nodetoadd.setIndex(y);
		}
		else
		{
			nodetoadd.setNext(head);
			head = nodetoadd;
			adjustindex();
		}
	}
	
	public void insertAtStartByNode(Node x)
	{
		int y = 0;
		if(head==null)
		{
			head = x;
			tail = x;
			x.setIndex(y);
		}
		else
		{
			x.setNext(head);
			head = x;
			adjustindex();
		}
	}
	
	public int adjustindex() 
	{
		Node temp = head;
		int x = 0;
		while(temp!=null)
		{
			temp.setIndex(x);
			x++;
			temp = temp.getNext();
		}
		return x;
	}

	public void insertAtEnd(int data)
	{
		int y = 0;
		Node nodetoadd = new Node(data);
		if(head==null)
		{
			nodetoadd.setIndex(y);
			head = nodetoadd;
			tail = nodetoadd;
		}
		else
		{
			tail.setNext(nodetoadd);
			tail = nodetoadd;
			adjustindex();
		}
	}
	
	public void insertAtIndex(int index,int data)
	{
		int number = adjustindex();
		if(index > number)
		{
			System.out.println("You can not insert at this location");
			return;
		}
		else if(index!=number)
		{
			Node temp = head;
			Node nodetoadd = new Node(data);
			Node prev = null;
			while(temp.getIndex()!=index)
			{
				prev = temp;
				temp = temp.getNext();
			}
			prev.setNext(nodetoadd);
			nodetoadd.setNext(temp);
			adjustindex();
		}
		else
		{
			insertAtEnd(data);
		}
	}
	
	public Node Search(int data)
	{
		int i=0;
		int y=0;
		Node temp = head;
		while(temp!=null)
		{
			if(temp.getData()==data)
			{
				y=1;
				System.out.println("Data found at index "+i);
				return temp;
			}
			temp = temp.getNext();
			i++;
		}
		if(y==0)
		{
			System.out.println("Data not found");
		}
		return null;
	}
	
	public Node deleteByNode(Node x)
	{
		Node prev = null;
		Node temp = head;
		while(temp!=null)
		{
			if(temp.getData() == x.getData())
			{
				if(temp == head)
				{
					head =temp.getNext();
					return temp;
				}
				prev.setNext(temp.getNext());
				temp.setNext(null);
				return temp;
			}
			prev = temp;
			temp = temp.getNext();
		}
		adjustindex();
		return temp;
	}
	
	public Node delete(int data)
	{
		Node prev = null;
		Node temp = head;
		while(temp!=null)
		{
			if(temp.getData()==data)
			{
				if(temp == head)
				{
					head = temp.getNext();
					return temp;
				}
				prev.setNext(temp.getNext());
				temp.setNext(null);
				return temp;
			}
			prev = temp;
			temp = temp.getNext();
		}
		adjustindex();
		return temp;
	}
	
	public void smartDelete(int data)
	{
		Node x = Search(data);
		if(x == tail)
		{
			delete(data);
			return ;
		}
		x.setData(x.getNext().getData());
		x.setNext(x.getNext().getNext());
		adjustindex();
	}
	
	public void print()
	{
		Node temp = head;
		while(temp!=null)
		{
			System.out.println(temp.getIndex()+": "+temp.getData());
			temp = temp.getNext();
		}
	}
	
	public boolean isEmpty()
	{
		if(head == null)
		{ 
			return true;
		}
		return false;
	}

}
