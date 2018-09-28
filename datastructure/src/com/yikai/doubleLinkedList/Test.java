package com.yikai.doubleLinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoubleList<String> doubleList = new DoubleList<String>();

		doubleList.insertToTail("a");
		doubleList.insertToTail("b");
		doubleList.insertToTail("b");
		doubleList.insertToTail("c");
		doubleList.insertToTail("d");
		doubleList.insertToPosition("1", "a");

		System.out.println(doubleList.toString());
	
		
		doubleList.removeElement("b");

		System.out.println(doubleList.toString());
	}

}
