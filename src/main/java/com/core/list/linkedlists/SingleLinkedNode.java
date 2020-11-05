package com.core.list.linkedlists;

import lombok.Data;

@Data
public class SingleLinkedNode<T> {

	private T data = null;
	private SingleLinkedNode<T> next = null;

	public SingleLinkedNode(T data) {
		this.data = data;
	}

	public SingleLinkedNode(T data, SingleLinkedNode<T> node) {
		this.data = data;
		this.next = node;
	}

}
