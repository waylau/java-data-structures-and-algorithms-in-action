/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * HelloWorld Test.
 * 
 * @since 1.0.0 2020年4月12日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class HelloWorldTests {

	@Test
	void testGetWords() {
		var words = "Hello World";
		var hello = new HelloWorld(words);
		
		assertEquals(words, hello.getWords());
	}
}
