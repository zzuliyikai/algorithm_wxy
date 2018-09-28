package com.yikai.singleLinkedList;

public class Test {

	public static void main(String[] args) {
		SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();

		singleLinkedList.insertToTail("a");
		singleLinkedList.insertToTail("b");
		singleLinkedList.insertToTail("c");
		singleLinkedList.insertToTail("d");
		singleLinkedList.delete("b");

		System.out.println(singleLinkedList.toString());
	}

}
