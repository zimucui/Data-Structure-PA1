/**Name: Zimu Cui.  zimucui@gmai.com
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a Game class that will generate the goose-duck result from input files
 */
import java.io.*;
import java.util.*;

public class Game {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("Input circle file:");
		String n1 = input.nextLine();
		Scanner circle = new Scanner(new File(n1));
		System.out.println("input game file:");
		String n2 = input.nextLine();
		Scanner itName = new Scanner(new File(n2));
		LinkedList linkedlist = new LinkedList();      /**build a linkedlist. rt = constant*/
		String name = itName.nextLine();
		linkedlist.add(name);       /**add the name in game file first to the linkedlist*/
		while (circle.hasNext()) {             /**rt = n*/
			linkedlist.add(circle.next());
		}
		Stack trackName = new Stack();   /**it keeps track of the popped name*/
		int index = 0;   /**it is the index we need to delete*/
		int totalIndex = index;    /**in case of negative numbers*/
		trackName.push(linkedlist.getName(index));    /**push it to stack in case of using*/
		linkedlist.delete(index);  /**now, game start. The name in game file is ready to replace others*/
		while(itName.hasNextInt()) {        /**rt = n*/
			Object temp = trackName.pop();      /**use the backup name*/
			totalIndex += itName.nextInt();       /**count total index*/
			index = (totalIndex % linkedlist.size()) + 1;     /**index must be larger than 0*/
			trackName.push(linkedlist.getName(index));       /**pushes the backup name into stack*/
			linkedlist.delete(index);
			linkedlist.add(temp, index);
			index --;
		}
		System.out.println(trackName.pop() + " is still it!");          /**it gives the final result*/
		System.out.println(linkedlist.toString());
	}
}


