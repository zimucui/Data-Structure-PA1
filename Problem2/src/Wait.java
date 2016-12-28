/**Name: Zimu Cui
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a waitlist that will give the average wait time for students
 */
import java.io.*;
import java.util.*;

public class Wait {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		System.out.println("Usdan mailroom simulation: Please specify the input file");
		String name = console.next();
		Scanner input = new Scanner(new File(name));      /**input a file*/
		double waittime = 0;
		int nextallow = 0;
		int countnumber = 0;
		int temp = 0;
		QueueArray queue = new QueueArray(10);
		
		while (input.hasNextInt()) {      /**rt = n*/ 
			temp = input.nextInt();   
			if (nextallow == temp) {       /**see whether the time the person leaves the queue equals the time the new person comes*/
				if (queue.size() < 10) {    /**see whether there are spaces for incoming students. rt = constant*/
					queue.enqueue(temp);
					countnumber ++;
					waittime += 5.0 * (queue.size() -1);
				}             
			} else {        /**nextallow != time*/
				while (nextallow != temp) {        /**update the time for possible incoming people, if not, do it until matches the time of the new people's time*/
					queue.dequeue();
					nextallow += 5;
				}
				queue.enqueue(temp);        /**rt = constant*/
				countnumber++;
				waittime += 5.0 * (queue.size() -1);
				}
		}
		double result = waittime/(double) countnumber;
		System.out.println("Here are the results: of the simulation");      /**give result*/
		System.out.println("The average waiting time is: " + result);
	}
}