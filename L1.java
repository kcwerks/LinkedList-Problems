package ListProblems;

/**
 * Given two linked lists of the same size, create a new
 * linked list using those given linked lists.
 * 
 * Condition: Node which is greater among the two original 
 * 		      linked lists will be added to new linked list.
 * 
 * Approach: Traverse both linked lists at the same time
 * 			 and compare node of both lists. Node which is
 * 			 greater among them will be added to the new list.
 * 
 * @author Kyle Calabro
 *
 */
public class L1 
{
	static class Node
	{
		int data;
		Node next;
	};
	
	// Function to insert a node into a linked list.
	static Node insert(Node root, int item)
	{
		Node pointer;
		Node temp = new Node();
		
		temp.data = item;
		temp.next = null;
		
		if(root == null)
		{
			root = temp;
		}
		else
		{
			pointer = root;
			while(pointer.next != null)
			{
				pointer = pointer.next;
			}
			pointer.next = temp;
		}
		return root;
	}
	
	// Generates a single list from two given lists based upon
	// the given condition.
	static Node newList(Node root1, Node root2)
	{
		Node pointer1 = root1;
		Node pointer2 = root2;
		Node root = null;
		
		Node pointer;
		Node temp;
		
		while(pointer1 != null)
		{
			temp = new Node();
			temp.next = null;
			
			if(pointer1.data < pointer2.data)
			{
				temp.data = pointer2.data;
			}
			else
			{
				temp.data = pointer1.data;
			}
			
			if(root == null)
			{
				root = temp;
			}
			else
			{
				pointer = root;
				while(pointer.next != null)
				{
					pointer = pointer.next;
				}
				pointer.next = temp;
			}
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return root;
	}
	
	// Displays a given linked list.
	static void display(Node root)
	{
		while(root != null)
		{
			System.out.print(root.data + "->");
			root = root.next;
		}
		System.out.print("Null");
		System.out.println();
	}
	
	// Driver program.
	public static void main(String[] args) 
	{
		Node root1 = null;
		Node root2 = null;
		Node root = null;
		
		//Build first list...
		root1 = insert(root1, 5);
		root1 = insert(root1, 2);
		root1 = insert(root1, 3);
		root1 = insert(root1, 8);
		
		System.out.print("First List: ");
		display(root1);

		// Build second list...
		root2 = insert(root2, 1);
		root2 = insert(root2, 7);
		root2 = insert(root2, 4);
		root2 = insert(root2, 5);

		System.out.print("Second List: ");
		display(root2);
		
		// Combine the lists into one and display it.
		root = newList(root1, root2);
		System.out.print("Combined List: ");
		display(root);
	}
}
