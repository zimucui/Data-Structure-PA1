/**Name: Zimu Cui.  zimucui@gmai.com
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a Stack class that will be used later in PostFixCalculator class
 */
public class Stack {
	private Node head;     /**there are two fields*/
	private int size;
	
	
	public Stack() {            /**rt = constant*/
		this.head = null;
		this.size = 0;
	}
	public void push(Object data) {        /**it pushes data into the stack*/
		Node temp = new Node(data);
		if (size == 0) {    /**rt = constant*/
			head = temp;
			this.size ++;
		} else {
			Node current = head;
			while (current.giveNext() != null) {    /**rt = n*/
				current = current.giveNext();
			}
			current.resetNext(temp);
			this.size ++;
		}
	}
	
	public boolean isEmpty() {        /**test whether the stack is empty or not. rt = constant*/
		return size == 0;
	}
	
	public int size() {       /**rt = constant*/
		return size;
	}
	public Object pop() {      /**it gives the latest data in the stack*/
		if (isEmpty()) {      /**rt = constant*/
			return "it is empty";
		} else if (size == 1){                 /**rt = constant*/
			Object data = head.giveData();
			head = null;
			size --;
			return data;
		} else {
			Node current = head;
			for (int i = 0; i < this.size - 2; i++) {        /**rt = n*/
				current = current.giveNext();
			}
			Object data = current.giveNext().giveData();
			current.resetNext(current.giveNext().giveNext());
			this.size --;
			return data;
		}
	}
	
	public String toString() {        /**it shows the whole linkedlist. rt = n */
		Node current = head.giveNext();
		String result = "[" +current.giveData();
		current = current.giveNext();
		while (current != null) {
			result = result + ", " + current.giveData();
			current = current.giveNext();
		}
		result = result + "]";
		return result;
	}
}
				
