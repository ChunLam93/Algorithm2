
public class myListDoubleLinkedList<T> implements myList<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private myNode<T> head;
	private myNode<T> tail;
	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	public myListDoubleLinkedList(){
		this.head = null;
		this.tail = null;

	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		//1. Traverse the elements
		myNode<T> current = this.head;
		int count = 0;

		//2. For each node we find, mark it as counted and move to the next one
		while (current != null){
			current = current.getRight();
			count = count + 1;
		}

		//3. Return the number of nodes being counted
		return count;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public T my_get_element(int index) throws myException{
		int count = 0;
		myNode<T> previous = null;
		myNode<T> current;
		if(index < (index+1/2)) {
			current = this.head;
			count = 0;
			while ((current != null) && (count < index)) {
				previous = current;
				current = current.getRight();
				count = count + 1;
			}
		}
		else {
			current = this.tail;
			count = 0;
			while ((current != null) && (count < index)) {
				current = current.getLeft();
				count = count + 1;
			}
		}



		//2.1. If the index is a valid one we access to the element and return it.
		if (current != null){
			T element = current.getInfo();
			//System.out.println(current.getLeft());

			return element;
		}
		//2.2. If the index is a wrong one
		else
		throw new myException("Invalid Index. The ADT does not have such an Index Position");


	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element
	//-------------------------------------------------------------------
	public void my_add_element(int index, T element) throws myException{
//1. We look for the element
		int count = 0;
		myNode<T> previous = null;
		myNode<T> current = this.head;

			while ((current != null) && (count < index)) {
				previous = current;
				current = current.getRight();
				count = count + 1;
			}


		//2.1. If the index is a valid one
		if (count == index){
			//2.1.1. We Create the new node
			myNode<T> new_node = new myNode<T>(element);

			//2.1.2. We adjust the previous pointer
			if (previous == null)
				this.head = new_node;
			else
				previous.setRight(new_node);

			//2.1.3. We adjust the successor pointer
			new_node.setRight(current);
			new_node.setLeft(previous);
			this.tail = new_node;
		}		//2.2. If the index is a wrong one
		else
			throw new myException("Invalid Index. The ADT does not have such an Index Position");





	}

	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index) throws myException{
		//1. We look for the element

		int count = 0;
		myNode<T> previous = null;
		myNode<T> current;
		if(index < (index+1/2)) {
			current = this.head;
			while ((current != null) && (count < index)) {
				previous = current;
				current = current.getRight();

				count = count + 1;
			}
			if (count == index){
				//2.1.1. We adjust the previous pointer
				if (current.getLeft() == null)
					this.head = current.getRight();

				else
				{
					previous.setRight(current.getRight());
					current.getRight().setLeft(current.getLeft());
				}
			}
			else
				throw new myException("Invalid Index. The ADT does not have such an Index Position");
		}
		else {
			current = this.tail;
			while ((current != null) && (count < index)) {
				previous = current;
				current = current.getLeft();
				count = count + 1;
			}

			if (current.getRight() == null)
			{
				this.tail = current.getLeft();
			}
			else {
				previous.setLeft(current.getLeft());
				current.getLeft().setRight(current.getRight());
			}
		}


		//2.1. If the index is a valid one

		//2.2. If the index is a wrong one

	}


}
