package com.core.list.stack;

import java.util.NoSuchElementException;

import com.core.list.linkedlists.SingleLinkedNode;

public class LinkedStack<E> implements Stackable<E> {

	private SingleLinkedNode<E> topOfStackRef = null;

	@Override
	public E push(E obj) {
		topOfStackRef = new SingleLinkedNode<E>(obj, topOfStackRef);
		return obj;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return topOfStackRef.getData();
		}
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			E result = topOfStackRef.getData();
			topOfStackRef = topOfStackRef.getNext();
			return result;
		}
	}

	@Override
	public boolean isEmpty() {
		return topOfStackRef == null;
	}

}
