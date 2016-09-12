package com.adanac.algorithm.kmeans;

import kmeans.kmeans;
import kmeans.kmeans_data;
import kmeans.kmeans_param;

public class Kmeans0 {
	public static void main(String[] args) {
		double[][] points = { { 0, 0 }, { 4, 10 }, { 1, 1 }, { 5, 8 } }; // 测试数据，四个二维的点
		kmeans_data data = new kmeans_data(points, 4, 2); // 初始化数据结构
		kmeans_param param = new kmeans_param(); // 初始化参数结构
		param.initCenterMehtod = kmeans_param.CENTER_RANDOM; // 设置聚类中心点的初始化模式为随机模式

		// 做kmeans计算，分两类
		kmeans.doKmeans(2, data, param);

		// 查看每个点的所属聚类标号
		System.out.print("The labels of points is: ");
		for (int lable : data.labels) {
			System.out.print(lable + "  ");
		}
	}
}