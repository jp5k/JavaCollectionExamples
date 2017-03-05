package com.pluralsight.stacks;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator = new Calculator();

	@Test
	public void shouldEvaluateConstants() {
		int result = calculator.evaluate("1");
		Assert.assertEquals(1, result);
	}

	@Test
	public void shouldSupportAdding() {
		int result = calculator.evaluate("1 + 2");
		Assert.assertEquals(3, result);
	}

	@Test
	public void shouldSupportSubtraction() {
		int result = calculator.evaluate("1 - 2");
		Assert.assertEquals(-1, result);
	}

	@Test
	public void shouldComplexStatements() {
		int result = calculator.evaluate("1 - 3 + 2 + 4");
		Assert.assertEquals(4, result);

	}

}
