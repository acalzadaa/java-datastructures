package com.core.list.arraylists;

import java.util.ArrayList;
import java.util.List;

public class ArrayLists {

	public static void main(String[] args) {

		List<String> originalArray = new ArrayList<>();
		originalArray.add("a");
		originalArray.add("b");
		originalArray.add("a");
		originalArray = replace(originalArray, "a", "z");
		System.out.println(originalArray);

	}

	/** Replaces each occurrence of oldItem in aList with newItem. */
	public static List<String> replace(List<String> aList, String oldItem, String newItem) {
		List<String> newArray = new ArrayList<>();
		aList.forEach(elem -> {
			newArray.add(elem.contains(oldItem) ? newItem : elem);
		});
		return newArray;
	}

	/** Deletes the first occurrence of target in aList. */
	public static void delete(List<String> aList, String target) {
		aList.remove(target);
	}

}
