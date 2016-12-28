/**Name: Zimu Cui.  zimucui@gmai.com
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a linkedlist class that will be used later in Game class
 */
public class LinkedList {
	private Node head;        /**there are two fields*/
	private int size;
	
	public LinkedList() {              /**rt = constant*/
		this.head = new Node(null);
		this.size = 0;
	}
	
	public void add(Object data) {        /**it adds new data into the linkedlist*/
		Node current = head;           /**use current to trace the linkedlist*/
		Node temp = new Node(data);
		
		while (current.giveNext() != null) {       /**rt = n*/
			current = current.giveNext();
		}
		current.resetNext(temp);
		this.size ++;
	}
	
	public void add(Object data, int index) {       /**it adds new data with given index into the linkedlist. rt = n*/
		Node current = head;
		Node temp = new Node(data);
		
		for (int i = 1; i < index && current.giveNext() != null; i ++) {
			current= current.giveNext();
		}
		temp.resetNext(current.giveNext());
		current.resetNext(temp);
		this.size ++;
	}
		
	public void delete(int index) {          /**it deletes data from the linkedlist*/
		Node current = head;
			
		for (int i = 1; i < index; i++) {      /**index must be larger than 0. rt = n*/
			current = current.giveNext();
		}
		current.resetNext(current.giveNext().giveNext());
		this.size --;
	}
	
	public int size() {         /**it returns the size from the linkedlist. rt = constant*/
		return this.size;
	}
	
	public Object getName(int index) {        /**it gives the data of a given index from the linkedlist*/
		Node current = head.giveNext();   
		
		for (int i = 1; i < index; i++) {       /**rt = constant*/
			current = current.giveNext();
		}
		return current.giveData();
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
				
				
		
		
