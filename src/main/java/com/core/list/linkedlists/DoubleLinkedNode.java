package com.core.list.linkedlists;

import lombok.Data;

@Data
public class DoubleLinkedNode<T> {

	private T data = null;
	private DoubleLinkedNode<T> next = null;
	private DoubleLinkedNode<T> prev = null;

	public DoubleLinkedNode(T data) {
		this.data = data;
	}

}
