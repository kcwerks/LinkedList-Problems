package ListProblems;
import java.util.*;
/**
 * Given a linked list and a number n, write a function that returns
 * the value at n'th node from the end of the linked list.
 * 
 * Approach: Maintain two pointers - reference pointer and main pointer.
 * 			 Initialize both pointers to head. Move reference pointer to head.
 * 			 Then move both pointers one by one until reference pointer reaches
 * 			 the end.
 * 			 Main pointer will now point to n'th node from the end.
 * 
 * @author Kyle Calabro
 *
 */
public class L2 
{	
	Node head;
	
	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	void printNthFromLast(int n)
	{
		Node mainPointer = head;
		Node referencePointer = head;
			
		int count = 0;
		if(head != null)
		{
			while(count < n)
			{
				if(referencePointer == null)
				{
					System.out.println(n + " is greater than the # "
							+ "of nodes in the list");
						
					return;
				}
				referencePointer = referencePointer.next;
				count++;
			}
			while(referencePointer != null)
			{
				mainPointer = mainPointer.next;
				referencePointer = referencePointer.next;
			}
			System.out.println("Node #" + n + " from last is " + mainPointer.data);
		}
	}
		
	public void push(int newData)
	{
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
	
	public static void main(String[] args) 
	{
		L2 list = new L2();
		
		list.push(20);
		list.push(4);
		list.push(15);
		list.push(35);

		list.printNthFromLast(4);
	}
}