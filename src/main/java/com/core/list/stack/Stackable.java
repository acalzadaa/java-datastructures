package com.core.list.stack;

public interface Stackable<E> {

	E push(E obj);

	E peek();

	E pop();

	boolean isEmpty();

}
