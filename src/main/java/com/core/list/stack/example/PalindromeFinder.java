package com.core.list.stack.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PalindromeFinder {

	private static Deque<Character> fillStack(String inputString) {
		Deque<Character> charStack = new ArrayDeque<>();
		inputString.chars().mapToObj(chr -> ((char) chr)).forEach(chr -> charStack.push(chr));
		return charStack;
	}

	private static String buildReverse(String inputString) {
		Deque<Character> charStack = fillStack(inputString);
		StringBuilder result = new StringBuilder();
		charStack.stream().forEach(stack -> result.append(stack));
		return result.toString();
	}

	public static boolean isPalindrome(String inputString) {
		return inputString.equalsIgnoreCase(buildReverse(inputString));
	}

	public static String reverseAPhrase(String phrase) {
		StringBuilder sb = new StringBuilder();
		List<String> words = new ArrayList<>(Arrays.asList(phrase.split(" ")));
		Deque<String> wordStack = new ArrayDeque<>();
		words.stream().forEach(word -> wordStack.push(word));
		while (!wordStack.isEmpty()) {
			sb.append(wordStack.pop()).append(" ");
		}
		return sb.toString();
	}
}
