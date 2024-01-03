package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HtmlTextConverterTest {

	@Test
	public void foo() {
		final HtmlTextConverter converter = new HtmlTextConverter("foo");
		assertEquals("foo", converter.getFilename());
	}

}
