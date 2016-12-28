/**Name: Zimu Cui.  zimucui@gmail.com
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a Node class that will be used later in Stack class
 */
public class Node {
	private Node next;              /**node contains two fields*/
	private Object data;     
	
	public Node(Object data) {            /**running time = constant*/
		this(data, null);
	}
	
	public Node(Object data, Node next) {           /**running time = constant*/
		this.next = next;
		this.data = data;
	}
	
	public Object giveData() {                  /**it returns the data of the node. rt = constant*/
		return this.data;
	}
	
	public void resetData(Object data) {          /**it resets the data of the node. rt = constant*/
		this.data = data;
	}
	
	public Node giveNext() {            /**it returns the node after the current node. rt = constant*/
		return this.next;
	}
	
	public void resetNext(Node next) {        /**it resets next node. rt = constant.*/
		this.next = next;
	}
}
