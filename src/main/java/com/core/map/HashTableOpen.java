package com.core.map;

import lombok.Data;

@Data
public class HashTableOpen<K, V> implements KWHashMap<K, V> {

	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = 0.75;

	private int numKeys;
	private int numDeletes;

	private final Entry<K, V> DELETED = new Entry<>(null, null);

	public HashTableOpen() {
		table = new Entry[START_CAPACITY];
	}

	private int find(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}

		while ((table[index] != null) && (!key.equals(table[index].getKey()))) {
			index++;
			if (index >= table.length) {
				index = 0;
			}
		}

		return index;

	}

	@Data
	private static class Entry<K, V> {
		private final K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}

	}

	@Override
	public boolean isEmpty() {
		return numKeys == 0;
	}

	@Override
	public V get(Object key) {
		int index = find(key);
		if (table[index] != null) {
			return table[index].getValue();
		} else {
			return null;
		}
	}

	@Override
	public V put(K key, V value) {
		int index = find(key);
		if (table[index] != null) {
			table[index] = new Entry<K, V>(key, value);
			numKeys++;
			/* checks for rehash */
			double loadFactor = (double) (numKeys + numDeletes) / table.length;

			if (loadFactor > LOAD_THRESHOLD) {
				rehash();
			}
			return null;
		} else {
			V oldVal = table[index].getValue();
			table[index].setValue(value);
			return oldVal;
		}

	}

	@SuppressWarnings("unchecked")
	private void rehash() {

		Entry<K, V>[] oldTable = table;

		/* double the capacity */
		table = new Entry[2 * oldTable.length + 1];

		/* reinsert all items */
		numKeys = 0;
		numDeletes = 0;

		for (int i = 0; i < oldTable.length; i++) {
			if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
				put(oldTable[i].getKey(), oldTable[i].getValue());
			}
		}
	}

	@Override
	public V remove(Object key) {
		int index = find(key);
		if (table[index] != null) {
			V oldVal = table[index].getValue();
			table[index] = DELETED;
			return oldVal;
		} else {
			return null;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return numKeys;
	}

}
