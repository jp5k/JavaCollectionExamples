package com.pluralsight.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
	
	/*
	 1
	 -
	 3
	 +
	 2
	 +
	 4 
	 */
	

	public int evaluate(final String input) {
		final Deque<String> stack = new ArrayDeque<>();
		final String[] tokens = input.split(" ");
		for (String token : tokens)
		{
			stack.add(token);
		}
		
		while(stack.size() > 1)
		{
			int left = Integer.parseInt(stack.pop()); 
			final String operator = stack.pop();
			int right = Integer.parseInt(stack.pop());
		
			int result = 0;
			switch(operator)
			{
			case "+":
				result = left + right;
				break;
				
			case "-":
				result = left - right;
				break;
			}
			
			stack.push(String.valueOf(result));
			
			}
		
		return Integer.parseInt(stack.pop());
		
		
	}
	
}
