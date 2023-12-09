package com.uPractice;

public class MethodChainInternal {
	public static void main(String[] args) {
		 m1()
		.m2()
		.m3();
	}
	
public static MethodChainInternal m1() {
	System.out.println("m1 method");
	return new MethodChainInternal();
}
public MethodChainInternal m2() {
	System.out.println("m2 method");
	return this;
}

public MethodChainInternal m3() {
	System.out.println("m3 method");
	return this;
}

}
