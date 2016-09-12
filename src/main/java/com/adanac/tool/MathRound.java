package com.adanac.tool;

import java.util.Scanner;

public class MathRound {
	private static int radius;

	public static void main(String[] args) {
		int dist;
		System.out.println("Input the radius(R > 2):");
		Scanner scan = new Scanner(System.in);
		try {
			radius = Integer.parseInt(scan.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
		radius = 2 * radius;
		System.out.println("===========When R < 20 works well==============");
		for (int i = 0; i <= radius; i++) {
			int j = 0;
			if (i == radius / 2) // 对图形微调
				continue;
			// 中垂线到*号的距离
			dist = (int) Math.sqrt(radius * radius - (radius - 2 * i) * (radius - 2 * i));
			while (j < radius - dist)// 左半圆
			{
				System.out.print(" ");
				j++;
			}
			System.out.print("*");
			dist = radius + dist;
			while (j < dist)// 右半圆
			{
				System.out.print(" ");
				j++;
			}
			System.out.println("*");
		}
	}
}
