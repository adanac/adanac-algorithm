package com.adanac.algorithm;

public class Test {

	public static void main(String[] args) {
		// float[] pp = new float[] { 1, 2 };
		// System.out.println(Arrays.toString(pp));
		String str = "";
		String s = str + "";
		if (s.intern() == "") {// if add function intern syso 1, else syso 2
			System.out.println(1);
		} else {
			System.out.println(2);
		}
	}

}
