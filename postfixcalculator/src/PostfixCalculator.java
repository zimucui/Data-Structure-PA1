/**Name: Zimu Cui.  zimucui@gmai.com
 *Class: COSI 11A, Fall 2013, Section 2
 *Programming Assignment #1, 9/20/2015
 *Description: This program forms a Postfix calculator that will generate the result you want
 */
import java.util.*; /**for Scanner*/

public class PostfixCalculator {
    public static void main(String[] args) {
    	Stack postfix = new Stack();       /**build a new stack*/
    	Scanner console = new Scanner(System.in);
    	System.out.println("Now start the postfix calculator, please enter a number (no operator first)");
    	String input = console.next();
    	while (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {        /**must enter an operand here*/
    		System.out.println("Please enter an operand");
    		input = console.next();
    	}
    	postfix.push("" +input);
    	while (!postfix.isEmpty()) {              /**this while loop will not end. rt = n*/
    		System.out.println("Please enter an operand or an operator or the order 'clear'");
    		input = console.next();
    		if (input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5") || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9")) { /**it means input is a number*/
    			postfix.push(input);
    		} else if (input.equals("+")) {   /**when plus is entered*/
    			if (postfix.size() == 1) {
    				System.out.println("Stack is underflow. Please enter an operand, not an operator");
    				input = console.next();
    				while (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {  
    					System.out.println("please enter the right operand");
    					input = console.next();
    				}
    				postfix.push("" + input);   /**push it into the stack. rt = constant*/
    			} else {
    			double first = Double.parseDouble((String) postfix.pop());    /**transfer it into double. rt = constant*/
    			double second = Double.parseDouble((String) postfix.pop());
    			double result = first + second;
    			System.out.println("Now, the result after you enter the operator is:" + result);
    			postfix.push("" + result);	  /**push the result back into the stack. rt = constant*/
    			}  
    		} else if (input.equals("-")) {       /**when minus is entered*/
    			if (postfix.size() == 1) {
    				System.out.println("Stack is underflow. Please enter an operand, not an operator");
    				input = console.next();
    				while (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
    					System.out.println("please enter the right operand");
    					input = console.next();
    				}
    				postfix.push("" + input);
    			} else {
    			double first = Double.parseDouble((String) postfix.pop());
    			double second = Double.parseDouble((String) postfix.pop());
    			double result = first - second;
    			System.out.println("Now, the result after you enter the operator is:" + result);
    			postfix.push("" + result);	
    			}
    		} else if (input.equals("*")) {       /**when multiplication is entered*/
    			if (postfix.size() == 1) {
    				System.out.println("Stack is underflow. Please enter an operand, not an operator");
    				input = console.next();
    				while (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
    					System.out.println("please enter the right operand");
    					input = console.next();
    				}
    				postfix.push("" + input);
    			} else {
    			double first = Double.parseDouble((String) postfix.pop());
    			double second = Double.parseDouble((String) postfix.pop());
    			double result = first * second;
    			System.out.println("Now, the result after you enter the operator is:" + result);
    			postfix.push("" + result);	
    			}
    		} else if (input.equals("/")) {       /**when division is entered*/
    			if (postfix.size() == 1) {
    				System.out.println("Stack is underflow. Please enter an operand, not an operator");
    				input = console.next();
    				while (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
    					System.out.println("please enter the right operand");
    					input = console.next();
    				}
    				postfix.push("" + input);
    			} else {
    			double first = Double.parseDouble((String) postfix.pop());      
    			double second = Double.parseDouble((String) postfix.pop());
    			double result = first / second;
    			System.out.println("Now, the result after you enter the operator is:" + result);
    			postfix.push("" + result);	
    			} 
    		} else if (input.equals("clear")) {        /**when clear is entered*/
    			while (!postfix.isEmpty()) {           /**clear all elements in the stack. rt = n*/
    				postfix.pop();          
    			}
    			System.out.println("Now, the memory is empty. Start over again. Please enter an operand.");
    			input = console.next();
    	    	while (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
    	    		System.out.println("Please enter an operand");
    	    		input = console.next();
    	    	}
    	    	postfix.push(input);
    			}
    		}
    	}
	}