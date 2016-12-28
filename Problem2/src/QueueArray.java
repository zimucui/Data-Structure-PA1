/**Name: Zimu Cui
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a queue that will be used later in Wait class
 */
import java.util.*;

public class QueueArray {
	private int size;           /**there are five fields*/
	private int occupied;  /**it means the slots that are occupied in the queue*/
	private int[] queue;
	private int front;
	private int rear;
	
	public QueueArray(int input) {   /**rt = constant*/
		size = input;
		occupied = 0;
		queue = new int[input];
		front = 0;              
		rear = 0;
	}
	
	
	public int size() {             /**rt = constant*/
		return this.occupied;
	}
	
	public void enqueue(int input) {        /**it pushes a value into the array. rt = constant*/
		if (occupied == size) {
			throw new IllegalStateException("Queue is overflowed.");
		} else {
			queue[rear] = input;
			rear = (rear + 1) % size;
			occupied ++;
		}
	}
	
	public int dequeue() {        /**it delete a value from the array. rt = constant*/
		int result;
		if (isEmpty()) {
			throw new IllegalStateException("Queue is underflowed.");
		} else {
			result = queue[front];
			front = (front + 1) % size;
			occupied --;
		}
		return result;
	}
	
	public boolean isEmpty() {                 /**rt = constant*/
		return (front == rear && occupied != size);
	}
	
	
	public String toString() {         /**rt = constant*/
		return "the front index is " + front + ", and the rear index is " + rear + ". The queue as a whole is " + Arrays.toString(queue);
	}
}