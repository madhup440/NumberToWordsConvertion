package com.virtusa.numtoword;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.virtusa.numtoword.NumberToWordsConverter;
import com.virtusa.numtoword.exceptions.NumberExceedLimitException;
import com.virtusa.numtoword.exceptions.ParseException;

public class NumberToWordsTest {

	public void testconvert(int num, String expectedSpelling) {
		assertEquals(NumberToWordsConverter.convert(num), expectedSpelling);
	}

	@Test
	public void testconvert_ten() {
		testconvert(10, "Ten");
	}

	@Test
	public void testNumtoWords_forunitsPosition() {
		testconvert(9, "Nine");
	}

	@Test
	public void testNumtoWords_forZerocheck() {
		testconvert(0, "Zero");
	}

	@Test
	public void testNumtoWords_forNegativeValues() {
		testconvert(-21, "Minus Twenty One");
	}

	@Test
	public void testNumtoWords_forTenthPosition() {
		testconvert(21, "Twenty One");
	}

	@Test
	public void testNumtoWords_forhunderedPosition() {
		testconvert(221, "Two Hundred Twenty One");
	}

	@Test
	public void testNumtoWords_forThousandsPosition() {
		testconvert(9010, "Nine Thousand Ten");
	}

	@Test
	public void testNumtoWords_forLakhsPosition() {
		testconvert(999999, "Nine Lakh Ninety Nine Thousand Nine Hundred Ninety Nine");
	}

	@Test(expected = NumberExceedLimitException.class)
	public void testNumtoWords_ExceptionWhenExceedLimit() {
		int num = 10000000;
		NumberToWordsConverter.convert(num);
	}

}
