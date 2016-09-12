package com.adanac.java.line.queue;

import java.lang.reflect.Array;

/**
 * Java : 数组实现“队列”，只能存储int数据。 队列（Queue），是一种线性存储结构。它有以下几个特点： (01) 队列中数据是按照
 * "先进先出（FIFO, First-In-First-Out）"方式进出队列的。 (02) 队列只允许在"队首"进行删除操作，而在"队尾"进行插入操作。
 * 队列通常包括的两种操作：入队列 和 出队列。
 */
public class ArrayQueue2<T> {
	private static final int DEFAULT_SIZE = 12;

	private T[] mArray;
	private int mCount;

	public ArrayQueue2(Class<T> type) {
		// mArray = new int[sz];
		// mCount = 0;
		this(type, DEFAULT_SIZE);
	}

	public ArrayQueue2(Class<T> type, int size) {
		// 不能直接使用mArray = new T[DEFAULT_SIZE];
		mArray = (T[]) Array.newInstance(type, size);
		mCount = 0;
	}

	// 将val添加到队列的末尾
	public void add(T val) {
		mArray[mCount++] = val;
	}

	// 返回“队列开头元素”
	public T front() {
		return mArray[0];
	}

	// 返回“栈顶元素值”，并删除“栈顶元素”
	public T pop() {
		T ret = mArray[0];
		mCount--;
		for (int i = 1; i <= mCount; i++) {
			mArray[i - 1] = mArray[i];
		}
		return ret;
	}

	// 返回“栈”的大小
	public int size() {
		return mCount;
	}

	// 返回“栈”是否为空
	public boolean isEmpty() {
		return size() == 0;
	}

	public static void main(String[] args) {
		Integer tmp = new Integer(0);
		ArrayQueue2 astack = new ArrayQueue2(Integer.class);

		// 将10, 20, 30 依次推入队列中
		astack.add(10);
		astack.add(20);
		astack.add(30);

		// 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
		tmp = (Integer) astack.pop();
		System.out.printf("tmp=%d\n", tmp);

		// 只将“栈顶”赋值给tmp，不删除该元素.
		tmp = (Integer) astack.front();
		System.out.printf("tmp=%d\n", tmp);

		astack.add(40);

		System.out.printf("isEmpty()=%b\n", astack.isEmpty());
		System.out.printf("size()=%d\n", astack.size());
		while (!astack.isEmpty()) {
			System.out.printf("size()=%d\n", astack.pop());
		}

		System.out.println("--------------------------");

		astack = new ArrayQueue2(String.class);

		// 将10, 20, 30 依次推入队列中
		astack.add("a");
		astack.add("b");
		astack.add("c");

		// 将“栈顶元素”赋值给tmp，并删除“栈顶元素”
		String tt = (String) astack.pop();
		System.out.printf("tt=%d\n", tmp);

		// 只将“栈顶”赋值给tmp，不删除该元素.
		tt = (String) astack.front();
		System.out.printf("tt=%d\n", tmp);

		astack.add("d");

		System.out.printf("isEmpty()=%b\n", astack.isEmpty());
		System.out.printf("size()=%d\n", astack.size());
		while (!astack.isEmpty()) {
			System.out.printf("size()=%s\n", astack.pop());
		}
	}
}
