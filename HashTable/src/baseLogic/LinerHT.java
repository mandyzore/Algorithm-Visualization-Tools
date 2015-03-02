package baseLogic;

import java.awt.Color;
import java.awt.Graphics;

import gui.ShowHashTabel;

/** 
 * 创建时间：2012-1-31 下午11:46:32 
 * 项目名称：HashTable 
 * @author daniel 
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * 文件名称：linerHT.java 
 * 类说明： 
 */
/**
 * @author Mengdi
 * 
 */
public class LinerHT extends HashTable {

	Bucket ht[]; // 数组形式的哈希表
	int Length = 0;// 表中已插入的元素个数
	public ShowHashTabel ht3;
	public String currentContain="";
	public String currentStep="";

	/**
	 * @param D
	 */
	public LinerHT(int D) {
		super(D);
		// TODO Auto-generated constructor stub
		ht = new Bucket[D];
		System.out.println("散列初始化完毕");
		show();
	}

	/*
	 * public void Initiate() { ht = new Bucket[D]; for (int i = 0; i < D - 1;
	 * i++) { ht[i].setNum(0);// 初始化每个桶的数值为0 }
	 * 
	 * }
	 */
	
	public Boolean search(int k,int index) {
		int realIndex = F(k);// 寻找起始位置
		if(realIndex==index)
			return true;
		else return false;
	}

	/**
	 * 
	 * @param k
	 * @return 元素所在的位置
	 */
	

	public int search1(int k) {
		System.out.println("****查找元素“" + k + "”在散列表中的所在位置：****");
		step(show(), "查找元素“" + k + "”在散列表中的所在位置：");
		int index;
		index = F(k);// 寻找起始位置
		int i = 1;
		while (ht[index] != null && i != D) {// 到达一个空桶或又回到f(k)桶
			if (ht[index].getNum() == k) {
				step(show(index), "找到元素“" + k + "”所在位置：" + index + "号桶");
				return index;
			} else {
				step(show(index),  "检查" + index + "号桶");
				index = (index + 1) % D;
			}
			i++;
		}
		if (ht[index] == null) {
			step(show(index),"遇到空桶--" + index + "号桶--停止搜索" );
		} else {
			step(show(index), "又回到该元素的起始桶");
		}
		step(show(), "表中不含有该"+k+"元素");
		return -1;// 表中不含有关键值为k的元素
	}

	/**
	 * 
	 * @param k
	 * @return 元素插入的位置
	 */
	public int search2(int k) {
		System.out.println("****寻找元素“" + k + "”的插入位置：****");
		step(show(), "寻找元素“" + k + "”的插入位置");
		if (Length == D) {
			System.out.println("散列表已满，不能插入新元素");
			step(show(), "散列表已满，不能插入新元素");
			return -1;
		}
		int index;
		index = F(k);// 插入起始位置
		System.out.println("检查元素“" + k + "”应插入的起始桶" + index + "号桶");
		show(index);
		step(show(index), "检查元素“" + k + "”应插入的起始桶" + index + "号桶");
		while (ht[index] != null) {
			String s=index + "号桶不为空,";
			step(show(index), index + "号桶不为空,");
			index = (index + 1) % D;
			s=s+"检查" + index + "号桶";
			System.out.println(s);
			show(index);
			step(show(index), s);
		}
		System.out.println(index + "号桶为空");
		step(show(index), index + "号桶为空"); 
		return index;
	}

	/**
	 * 
	 * @param k
	 * @return 插入单个元素
	 */
	public boolean insert1(int k) {
		System.out.println("****插入元素“" + k + "”****");
		step(show(), "将元素“" + k + "”插入当前散列");
		int index = search2(k);
		if (index == -1)
			return false;
		ht[index] = new Bucket();
		ht[index].setNum(k);
		Length++;
		System.out.println("将元素“" + k + "”插入" + index + "号桶");
		show(index);
		step(show(index), "将元素“" + k + "”插入" + index + "号桶");
		return true;
	}

	/**
	 * 
	 * @param k
	 * @return 插入多个元素
	 */
	public boolean insert2(int[] a) {
		for (int i = 0; i < a.length; i++) {
			insert1(a[i]);
//			step(show(), "将元素“" + a[i] + "”插入当前散列");
//			int index = search2(a[i]);
//			if (index == -1)
//				return false;
//			ht[index] = new Bucket();
//			ht[index].setNum(a[i]);
////			System.out.println("将元素“" + a[i] + "”插入" + index + "号桶");
////			show(index);
//			step(show(index), "将元素“" + a[i] + "”插入" + index + "号桶");
//			Length++;
		}
		return true;
	}

	/**
	 * 
	 * @param index
	 * @return 删除表中指的定桶中的元素
	 */
	public void delete1(int index) {
		System.out.println("删除" + index + "号桶内元素");
		ht[index] = null;
		Length--;
		show(index);
	}

	/**
	 * 
	 * @param index
	 * @return 删除表中指定的元素
	 */
	public boolean delete2(int k) {
		System.out.println("****删除元素“" + k + "”****");
		int index;
		index = search1(k);
		if (index == -1)
			return false;
		step(show(index), "删除元素“" + k+ "”");
		delete1(index);
		step(show(index), "删除元素“" + k+ "”");
		index = (index + 1) % D;
		step(show(index), "检查后继桶内元素是否需要调整");
		while (ht[index] != null) {
			System.out.println("检查" + index + "号桶");// 当下处理的桶号
			// Show();//单步显示
			// ht[(index+D-1)%D]=ht[index];
			int x = ht[index].getNum();	
			if(!search(x,index)){
			delete1(index);
			insert1(x);
			}else{
		    step(show(index), index + "号桶内元素不需调整");
			}
			index = (index + 1) % D;
		}
		step(show(), "元素调整完毕");
		Length--;
		return true;
	}

	public String show() {
		String s = "";
		for (int i = 0; i < ht.length; i++)
			s = s + " [" + (ht[i] == null ? " " : ht[i].getNum()) + "]";
		System.out.print(s);
		System.out.println();
		return s;
	}

	public String show(int index) {
		String s = "";
		for (int i = 0; i < ht.length; i++)
			if (i == index)
				s = s + "[#" + (ht[i] == null ? " " : ht[i].getNum()) + "#]";
			else
				s = s + "[" + (ht[i] == null ? " " : ht[i].getNum()) + "]";
		System.out.println(s);
		return s;
	}
public Graphics showByGraphics(int index,Graphics g){
	String s = "";
	for (int i = 0; i < ht.length; i++)
		if (i == index)
			s = s + "[#" + (ht[i] == null ? " " : ht[i].getNum()) + "#]";
		else
			s = s + "[" + (ht[i] == null ? " " : ht[i].getNum()) + "]";
	System.out.println(s);
	
	g.setColor(Color.blue);
	
	return g;
	
}
	public void step(String s1, String s2) {
		currentStep=currentStep+"!"+s1;
		currentContain=currentContain+"!"+s2;
	}

	public static void main(String[] args) {
		// key值置为10
		LinerHT h = new LinerHT(10);

		System.out.println("---------------散列初始化：----------------");
		int a[] = { 1, 17, 0, 5, 90, 80, 39, 99 };
		h.insert2(a);// 插入一个数组
		System.out.println("散列初始化完毕：");
		h.show();
		System.out.println();

		System.out.println("---------------散列的查找：----------------");
		h.search1(99);
		System.out.println();

		System.out.println("---------------散列的删除：----------------");
		h.delete2(80);
		System.out.println();

		System.out.println("散列的插入：");
		h.insert1(11);// 插入一个数

	}

	/**
	 * @param operateMsg
	 */
	public void operate(String operateMsg, int[] a) {
		// TODO Auto-generated method stub
		if (operateMsg.equals("Insert")) {
			insert2(a);
		}
		if (operateMsg.equals("Search")) {
			search1(a[0]);
		}
		if (operateMsg.equals("Delete")) {
			delete2(a[0]);
		}
	}
}
