package com.yikai.singleLinkedList;

import com.sun.org.apache.regexp.internal.recompile;

/**
 * 带头节点的单链表
 * 
 * @author 18237
 *
 * @param <T>
 */
public class SingleLinkedList<T> {

	class Entry {

		private T data;

		private Entry next;

		private Entry(T data, Entry next) {
			this.data = data;
			this.next = next;
		}
	}

	private Entry head;

	public SingleLinkedList() {

		head = new Entry(null, null);
	}

	public void insertToHead(T data) {
		Entry entry = new Entry(data, null);
		entry.next = head.next;
		head.next = entry;
	}

	public void insertToTail(T data) {
		Entry entry = new Entry(data, null);
		Entry index = head;
		while (index != null) {
			if (index.next == null) {
				index.next = entry;
				break;
			}
			index = index.next;
		}

	}

	public void delete(T data) {
		Entry index = head;
		Entry preIndex = head;
		while (index != null) {
			if (data.equals(index.data)) {
				preIndex.next = index.next;

			}
			preIndex = index;
			index = index.next;

		}

	}

	public String toString() {

		StringBuffer sb = new StringBuffer();
		Entry index = head.next;

		while (index != null) {
			sb.append(index.data + "\n");
			index = index.next;
		}

		return sb.toString();

	}

}
