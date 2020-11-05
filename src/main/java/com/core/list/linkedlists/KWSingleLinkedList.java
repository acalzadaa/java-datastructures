package com.core.list.linkedlists;

public class KWSingleLinkedList<T> {

	private SingleLinkedNode<T> head = null;
	private int size = 0;

	private void addAfter(SingleLinkedNode<T> node, T item) {
		node.setNext(new SingleLinkedNode<>(item, node.getNext()));
		size++;
	}

	private void addFirst(T item) {
		head = new SingleLinkedNode<>(item, head);
		size++;
	}

	private T removeAfter(SingleLinkedNode<T> node) {
		SingleLinkedNode<T> temp = node.getNext();
		if (temp != null) {
			node.setNext(temp.getNext());
			size--;
			return temp.getData();
		} else {
			return null;
		}
	}

	private T removeFirst() {
		SingleLinkedNode<T> temp = head;
		if (head != null) {
			head = head.getNext();
		}
		// Return data at old head or null if list is empty
		if (temp != null) {
			size--;
			return temp.getData();
		} else {
			return null;
		}
	}

	private SingleLinkedNode<T> getNode(int index) {
		SingleLinkedNode<T> node = head;

		for (int i = 0; i < index && node != null; i++) {
			node = node.getNext();
		}

		return node;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		SingleLinkedNode<T> node = getNode(index);
		return node.getData();
	}

	public T set(int index, T newValue) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		SingleLinkedNode<T> node = getNode(index);
		T result = node.getData();
		node.setData(newValue);
		return result;
	}

	public void add(int index, T item) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index == 0) {
			addFirst(item);
		} else {
			SingleLinkedNode<T> node = getNode(index - 1);
			addAfter(node, item);
		}
	}

	public boolean add(T item) {
		add(size, item);
		return true;
	}

}
