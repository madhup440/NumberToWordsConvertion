package com.virtusa.numtoword;

import java.util.Scanner;

import com.virtusa.numtoword.constants.DigitsEnum;
import com.virtusa.numtoword.exceptions.NumberExceedLimitException;
import com.virtusa.numtoword.exceptions.ParseException;

public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };

	public static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	public static String convert(final int n) {

		if (n == 0) {
			return "Zero";
		} else if (n < 0) {
			return "Minus " + convert(-n);
		} else if (n < 20) {
			return units[n];
		} else if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		} else if (n < 1000) {
			return units[n / 100] + " " + DigitsEnum.HUNDRED.getValue()
					+ ((n % 100 == 0) ? " " : " " + convert(n % 100));
		} else if (n < 100000) {
			return convert(n / 1000) + " " + DigitsEnum.THOUSAND.getValue()
					+ ((n % 1000 == 0) ? " " : " " + convert(n % 1000));
		} else if (n < 10000000) {
			return convert(n / 100000) + " " + DigitsEnum.LAKH.getValue()
					+ ((n % 100000 == 0) ? " " : " " + convert(n % 100000));
		} else {
			throw new NumberExceedLimitException("Number exceeds the limit of 10000000");
		}

	}

	public static void main(String[] args) {
		int number = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type in a number");
		while (true) {
			number = scanner.nextInt();
			System.out.print("Number in words: " + convert(number) + "\n");
		}
	}
}