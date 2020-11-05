package com.core.list.linkedlists;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWDoubleLinkedList<T> {

	private DoubleLinkedNode<T> head = null;
	private DoubleLinkedNode<T> tail = null;
	private int size = 0;

	private class KWListIter implements ListIterator<T> {

		private DoubleLinkedNode<T> nextItem;
		private DoubleLinkedNode<T> lastItemReturned;
		private int index = 0;

		public KWListIter(int i) {
			if (i < 0 || i > size) {
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}

			lastItemReturned = null;
			if (i == size) {
				index = size;
				nextItem = null;
			} else {
				nextItem = head;
				for (index = 0; index < i; index++) {
					nextItem = nextItem.getNext();
				}
			}
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return nextItem != null;
		}

		@Override
		public T next() {

			if (nextItem != null) {
				throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.getNext();
			index++;
			return lastItemReturned.getData();
		}

		@Override
		public boolean hasPrevious() {
			return (nextItem != null && size != 0) || nextItem.getPrev() != null;
		}

		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}

			if (nextItem == null) {
				nextItem = tail;
			} else {
				nextItem = nextItem.getPrev();
			}

			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.getData();
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return nextItem != null ? index + 1 : -1;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return lastItemReturned != null ? index - 1 : -1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(T e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void add(T data) {
			if (head == null) {
				head = new DoubleLinkedNode<>(data);
				tail = head;
			} else if (nextItem == head) {
				DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data);
				newNode.setNext(nextItem);
				nextItem.setPrev(newNode);
				head = newNode;
			} else if (nextItem == null) {
				DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data);
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
			} else {
				DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(data);
				newNode.setPrev(nextItem.getPrev());
				nextItem.getPrev().setNext(newNode);
				newNode.setNext(nextItem);
				nextItem.setPrev(newNode);
			}
			size++;
			index++;
			lastItemReturned = null;

		}
	}

}
