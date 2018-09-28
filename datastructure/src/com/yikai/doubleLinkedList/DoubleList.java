package com.yikai.doubleLinkedList;

public class DoubleList<T> {

	/**
	 * 双向链表的数据结构
	 * 
	 * @author Administrator
	 *
	 */
	class Entry {
		T data;
		Entry next;
		Entry pre;

		public Entry() {
			next = null;
			pre = null;
		}

		public Entry(T data, Entry pre, Entry next) {
			this.next = next;
			this.pre = pre;
			this.data = data;
		}

		/**
		 * 构建一个空节点
		 * 
		 * @param next
		 * @param pre
		 */
		public Entry(Entry pre, Entry next) {
			this.next = next;
			this.pre = pre;
			this.data = null;
		}

	}

	private Entry head;
	private Entry tail;
	private int size;

	/**
	 * 在链表的链表头添加数据
	 * 
	 * @param data
	 */
	public void insertToHead(T data) {
		if (head == null) {
			Entry entry = new Entry(data, null, null);
			this.head = entry;
			this.tail = entry;
			this.size++;
		} else {
			Entry entry = new Entry(data, null, head);
			head.pre = entry;
			head = entry;
			this.size++;
		}
	}

	/**
	 * 在链表的链表尾部插入数据
	 * 
	 * @param data
	 */
	public void insertToTail(T data) {
		if (tail == null) {
			Entry entry = new Entry(data, null, null);
			this.tail = entry;
			this.head = entry;
			this.size++;
		} else {
			Entry entry = new Entry(data, tail, tail.next);
			this.tail.next = entry;
			this.tail = entry;
			this.size++;
		}
	}

	/**
	 * 在链表中指定插入哪个数据之后
	 * 
	 * @param data
	 *            想插入的数据
	 * @param preData
	 *            想插入数据的前一个数据
	 */
	public void insertToPosition(T data, T preData) {
		Entry index = head;
		boolean isHavePreData = false;
		while (index != null) {
			if (index.data.equals(preData)) {
				isHavePreData = true;
				break;
			}
			index = index.next;
		}

		if (isHavePreData) {

			if (index == tail) {
				Entry entry = new Entry(data, index, null);
				tail.next = entry;
				tail = entry;
			} else {
				Entry entry = new Entry(data, index, index.next);
				index.next.pre = entry;
				index.next = entry;
			}

			this.size++;
		} else {

			throw new RuntimeException("preData 不存在链表中");

		}

	}

	/**
	 * 删除指定元素
	 * @param data
	 */
	public void removeElement(T data) {

		Entry index = head;
		boolean isHaveRemoveData = false;
		while (index != null) {
			if (index.data.equals(data)) {
				isHaveRemoveData = true;
				break;
			}
			index = index.next;
		}

		if (isHaveRemoveData) {
			if (index == tail) {
				this.tail = index.pre;
				index.pre.next = null;
				index.pre = null;
			} else if (index == head) {
				this.head = index.next;
				index.next.pre = null;
				index.next = null;
			} else {
				index.pre.next = index.next;
				index.next.pre = index.pre;
			}
			this.size--;
		} else {
			throw new RuntimeException("链表中不存在你要删除的数据");
		}
		if (isHaveElement(data)) {
			removeElement(data);
		}

	}

	/**
	 * 链表中是否还存在这个元素
	 * @param data
	 * @return
	 */
	public boolean isHaveElement(T data) {
		Entry entry = head;
		boolean isHaveEle = false;
		while (entry != null) {
			if (entry.data.equals(data)) {
				isHaveEle = true;
				return isHaveEle;
			}
			entry = entry.next;
		}
		return isHaveEle;

	}

	public int getSize() {
		return size;
	}

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		Entry current = head;
		while (current != null) {
			stringBuffer.append(current.data.toString() + "\n");
			current = current.next;
		}
		return stringBuffer.toString();
	}

}
