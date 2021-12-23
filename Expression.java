package project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Expression {
	public static void main(String[] args) {
		// Read input from user:
		System.out.println("Enter the expression: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine(); // read a line
		
				
		// store elements of the input in an array without the spaces:
		String[] elementsInput = input.split(" "); 
		
		String postExpression = postfixExpression(elementsInput);
		String preExpression = prefixExpression(elementsInput);
		
		
		System.out.println("Input Infix Expression: " + input);
		System.out.println("Postfix version: " + postExpression );
		System.out.println("Prefix version: " + preExpression );
		evaluation(postExpression);
		
		in.close();				
				
				
	}
	
	public static String postfixExpression(String[] elementsInput) {
		ArrayList<String> operator = new ArrayList<>();
		operator.addAll(Arrays.asList("*", "/", "+", "-"));
		
		ArrayList<String> result = new ArrayList<>();
		
		Stack<String> operatorStack = new Stack<>();		
		
		
		
		for(String element : elementsInput) {
			if (element.startsWith("(")) {
				operatorStack.push(element);
				
			} else if (element.startsWith(")")) {
				if(!operatorStack.isEmpty()) {
					String lastOperator = operatorStack.pop();
					result.add(lastOperator);
					if(!operatorStack.isEmpty()) {
						String secondToLastOperator = operatorStack.pop();
						result.add(secondToLastOperator);
					}
				}
				
			// if element is an operator :	
			} else if (operator.contains(element)) { 
				if(operatorStack.isEmpty()) {
					operatorStack.push(element);
				} else {
					String op= operatorStack.top();					
					if( operatorHierarchy(element.charAt(0)) <= operatorHierarchy(op.charAt(0))) {
						result.add(operatorStack.pop());					
						operatorStack.push(element);
					} else {
						operatorStack.push(element);
					}
				}
								
			// If element is a number:
			} else { 
				result.add(element);
			}
		}
		// If there are operators left in the stack
		while(!operatorStack.isEmpty()) {
			String lastElements = operatorStack.pop();
			result.add(lastElements);
		}
		
		// Build a String without the parentheses
		String resultExpression = "";
		for(int i=0; i < result.size(); i++) {
			if(!result.get(i).startsWith("(") && !result.get(i).startsWith(")")) {
				resultExpression = resultExpression + result.get(i) + " ";				
			}
		}
		
		return resultExpression;
		
	}
	
	
	// ----------- Convert infix expressions to prefix expressions ---------
	
	public static String prefixExpression(String[] elements) {
		List<String> reversedExpression = Arrays.asList(elements);
		Collections.reverse(reversedExpression);	
				
		ArrayList<String> operator = new ArrayList<>();
		operator.addAll(Arrays.asList("*", "/", "+", "-"));
		
		//ArrayList<Character> result = new ArrayList<>();
		//String result = "";		
			
		Stack<String> result = new Stack<>();
		
		Stack<String> operatorStack = new Stack<>();
		
		
		for(String element : reversedExpression) {
			
			if (element.startsWith(")") ) {
				operatorStack.push(element);
				
				
			} else if(operator.contains(element)) {
				operatorStack.push(element);
				
				
			} else if(element.startsWith("(")) {
				result.push(operatorStack.pop());
				if(!operatorStack.isEmpty()) {
					result.push(operatorStack.pop());
				}
				
				
			} else {
				result.push(element);
			}
		}
		
		String resultExpression = "";
		int size = result.size();		
		
		for(int i = 0; i < size; i++) {
			String curr = result.top();
			if(curr.charAt(0) != ')') {			
				resultExpression = resultExpression + result.pop() + " ";
			} else {
				result.pop();
			}
		}
		
		return resultExpression; 
	}
	
	
	// ------------- Check hierarchy of operator ---------------
	
	public static int operatorHierarchy(char operator) {
		int position = 0;
		
		if(operator == '+' || operator == '-') position = 1;
		else if(operator == '*' || operator == '/') position = 2;
		else position = 3;
		
		return position;			
		
	}
	
	
	// ----------- Evaluate postfix expressions -----------
	
	public static void evaluation(String s) {		
		ArrayList<String> operator = new ArrayList<>();
		operator.addAll(Arrays.asList("*", "/", "+", "-"));
		String[] elementsInput = s.split(" "); 
		Stack<Double> stack = new Stack<>();
		double num1 = 0;
		double num2 = 0;
		double operation;
		
		
		for(String c : elementsInput) {
			if(operator.contains(c)) {
				num1 = Double.parseDouble(String.valueOf(stack.pop()));
				num2 = Double.parseDouble(String.valueOf(stack.pop()));
				
				if(c.charAt(0) == '*') {
					operation = num2 * num1;
				} else if(c.charAt(0) == '/') {
					operation = num2 / num1;
				} else if (c.charAt(0) == '-') {
					operation = num2 - num1;
				} else if(c.charAt(0) == '+') {
					operation = num2 + num1;
				} else operation = 0;
				stack.push(operation);
			} else if(c == " ") {
				
			} else {
				stack.push(Double.parseDouble(String.valueOf(c)));
			}	
						
		}		
		
		
		System.out.println("Evaluation: " + stack.pop());
		
	}	

}
