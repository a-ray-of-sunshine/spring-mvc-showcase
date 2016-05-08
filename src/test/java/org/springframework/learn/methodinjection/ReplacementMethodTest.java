package org.springframework.learn.methodinjection;

import org.junit.Test;
import org.springframework.common.Container;
import org.springframework.methodinjection.MyValueCalculator;

public class ReplacementMethodTest extends Container{

	@Test
	public void test(){
		
		MyValueCalculator calc = this.context.getBean("calculator", MyValueCalculator.class);
		
		String result = calc.computeValue("678");

		// 返回的结果是 678: ReplacementComputeValue
		// 说明 computeValue 方法确实被替换了
		System.out.println(result);
	}

}
