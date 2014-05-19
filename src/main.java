import java.util.Scanner;
public class main {
	public static void main(String args[])
	{
		linkedlist list = new linkedlist();
		list.insertSort(6);
		list.insertSort(3);
		list.insertSort(7);
		list.insertSort(5);
		list.insertSort(1);
		list.insertSort(4);
		list.print();
		System.out.println();
		list = pairWiseSwap(list);
		list.adjustindex();
		list.print();
	}
	
	static linkedlist algo1(linkedlist list)
	{
		linkedlist evenlist = new linkedlist();
		int i = 1;
		Node temp = list.head;
		Node prev=null;
		while(temp!=null)
		{
			if(i%2 == 0)
			{
				Node arb = list.deleteByNode(temp);
				evenlist.insertAtStartByNode(arb);
				temp = prev;
			}
			i++;
			prev = temp;
			temp = temp.getNext();
		}
		list.tail = prev;
		list.adjustindex();
		list.tail.setNext(evenlist.head);
		list.tail = evenlist.tail;
		return list;
	}
	
	static linkedlist pairWiseSwap(linkedlist list)
	{
		int i=0;
		Node temp1 = list.head;
		Node temp2 = list.head.getNext();
		Node temp = new Node(Integer.MAX_VALUE);
		Node prev = null;
		while(temp1!=null && temp2!=null)
		{
			temp.setNext(temp2.getNext());
			temp2.setNext(temp1);
			if(temp1==list.head)
			{
				list.head = temp2;
			}
			if(prev!=null)
			{
				prev.setNext(temp2);
			}
			prev = temp1;
			temp1.setNext(temp.getNext());
			temp1 = temp1.getNext();
			if(temp1!=null)
			{
				temp2 = temp1.getNext();
			}
			
			temp.setNext(null);
		}
		return list;
	}
	
}
