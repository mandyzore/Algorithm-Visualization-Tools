package baseLogic;

/** 
 * 创建时间：2012-1-31 下午09:57:29 
 * 项目名称：HashTable 
 * @author daniel 
 * @version 1.0  
 * @since JDK 1.6.0_21 
 * 文件名称：HashTable.java 
 * 类说明： 线性开行寻址散列--
 */
/**
 * @author Mengdi
 * 
 */
public abstract class HashTable {

	//Bucket ht[]; // 数组形式的哈希表
	public int D=0;//表中桶的个数
	
	HashTable(int D){
		this.D=D;//设定桶的个数
	}
	
	public int F(int k) {
		return k%D;//返回关键码对应的起始桶home bucket
	}

	public int search(int k) {
		int index = 0;
		index = F(k);// 寻找起始位置

		return index;
	}

	
}
