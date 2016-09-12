package com.adanac.java.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/*
 * @desc 遍历TreeMap的测试程序。
 *   (01) 通过entrySet()去遍历key、value，参考实现函数：
 *        iteratorTreeMapByEntryset()
 *   (02) 通过keySet()去遍历key、value，参考实现函数：
 *        iteratorTreeMapByKeyset()
 *   (03) 通过values()去遍历value，参考实现函数：
 *        iteratorTreeMapJustValues()
 *
 * @author skywang
 */
public class TreeMapIteratorTest {

	private static final int COUNT = 100000000;

	public static void main(String[] args) {
		int val = 0;
		String key = null;
		Integer value = null;
		Random r = new Random();
		TreeMap map = new TreeMap();

		for (int i = 0; i < COUNT; i++) {
			// 随机获取一个[0,100)之间的数字
			val = r.nextInt(100);

			key = String.valueOf(val);
			value = r.nextInt(5);
			// 添加到TreeMap中
			map.put(key, value);
			// System.out.println(" key:"+key+" value:"+value);
		}
		// 通过entrySet()遍历TreeMap的key-value
		long s1 = System.currentTimeMillis();
		iteratorTreeMapByEntryset(map);
		System.out.println("iteratorTreeMapByEntryset-->" + (System.currentTimeMillis() - s1) + "ms");
		// 通过keySet()遍历TreeMap的key-value
		long s2 = System.currentTimeMillis();
		iteratorTreeMapByKeyset(map);
		System.out.println("iteratorTreeMapByKeyset-->" + (System.currentTimeMillis() - s2) + "ms");
		// 单单遍历TreeMap的value
		long s3 = System.currentTimeMillis();
		// iteratorTreeMapJustValues(map);
		System.out.println("iteratorTreeMapJustValues-->" + (System.currentTimeMillis() - s3) + "ms");
	}

	/*
	 * 通过entry set遍历TreeMap 效率高!
	 */
	private static void iteratorTreeMapByEntryset(TreeMap map) {
		if (map == null)
			return;

		System.out.println("\niterator TreeMap By entryset");
		String key = null;
		Integer integ = null;
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();

			key = (String) entry.getKey();
			integ = (Integer) entry.getValue();
			// System.out.println(key+" -- "+integ.intValue());
		}
	}

	/*
	 * 通过keyset来遍历TreeMap 效率低!
	 */
	private static void iteratorTreeMapByKeyset(TreeMap map) {
		if (map == null)
			return;

		System.out.println("\niterator TreeMap By keyset");
		String key = null;
		Integer integ = null;
		Iterator iter = map.keySet().iterator();
		while (iter.hasNext()) {
			key = (String) iter.next();
			integ = (Integer) map.get(key);
			// System.out.println(key + " -- " + integ.intValue());
		}
	}

	/*
	 * 遍历TreeMap的values bug，不能退出循环
	 */
	private static void iteratorTreeMapJustValues(TreeMap map) {
		if (map == null)
			return;

		Collection c = map.values();
		Iterator iter = c.iterator();
		while (iter.hasNext()) {
			// System.out.println(iter.next());
		}
	}
}
