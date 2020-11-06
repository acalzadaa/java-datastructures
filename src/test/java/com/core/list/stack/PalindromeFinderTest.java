package com.core.list.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.core.list.stack.example.PalindromeFinder;

class PalindromeFinderTest {

	@Test
	void singleCharacterIsAlwaysAPalindrome() {
		Assertions.assertTrue(PalindromeFinder.isPalindrome("a"));
	}

	@Test
	void aSingleWordPalindrome() {
		Assertions.assertTrue(PalindromeFinder.isPalindrome("kayak"));
	}

	@Test
	void aSingleWordNonPalindrome() {
		Assertions.assertFalse(PalindromeFinder.isPalindrome("banana"));
	}

	@Test
	void multipleWordsSameCase() {
		Assertions.assertTrue(PalindromeFinder.isPalindrome("I saw I was I"));
	}

	@Test
	void reversePhrase() {
		Assertions.assertTrue(PalindromeFinder.reverseAPhrase("uno dos tres").contains("tres dos uno"));
	}

}
