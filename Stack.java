package project2;

import java.util.ArrayList;

public class Stack<E> {
	
	ArrayList<E> elements = new ArrayList<E>();
	
	
	
	public void push(E element) {
		elements.add(element);
		
	}
	
	public E pop() {
		if(elements.isEmpty()) {			
			return null;
		}
		else {
			return elements.remove(elements.size()-1);
		}
	}
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	 
	public int size() {
		return elements.size();
	}
	
	
	
	public E top() {	
		if(elements.isEmpty()) return null;
		
		return elements.get(elements.size()-1);
	}

	
	public String toString() {
		
		return "" + elements + "";
	}
	
	
	
	
	
			
}
		

