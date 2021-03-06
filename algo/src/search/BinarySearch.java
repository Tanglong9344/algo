package search;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找
 * 只适用于顺序存储结构的顺序表
 * @author 唐龙
 */
public class BinarySearch {
	final static int N = 1000;//数据数目
	final static int R = 1000;//数据范围
	final static int CNT = 1000;//操作次数
	public static void main(String[] args) {
		//初始化数据
		int[] searchTable = new int[N];
		Random random = new Random();
		for(int i=0;i<N;i++){
			searchTable[i] = random.nextInt(R);
		}
		//从小到大排序
		Arrays.sort(searchTable);
		System.out.println("查找表："+Arrays.toString(searchTable));
		int key;//目标数据
		int pos;//数据位置
		int avg=0;//平均查找时间
		long start;//开始时间
		long end;//结束时间
		for(int i=0;i<CNT;i++){
			key = searchTable[random.nextInt(N)];
			start = System.nanoTime();//记录开始时间
			pos = binarySearch(searchTable,key);
			end = System.nanoTime();//记录结束时间
			avg+= end-start;
			if(-1 == pos){
				System.out.println("未找到目标数据"+key);
			}else{
				System.out.println("目标数据"+key+"在数组中的位置是"+pos);
			}
		}
		System.out.println(CNT+"次查找的平均查找时间："+avg/CNT+"纳秒");
	}

	/**
	 * 二分查找算法
	 * @param searchTable
	 * @param key
	 * @return 返回目标数据在查找表中的位置
	 */
	static int binarySearch(int[] searchTable,int key){
		int low = 0;
		int high = searchTable.length-1;
		int mid;
		while(low<=high){
			mid = (low + high)/2;
			if(key == searchTable[mid]){
				return mid;//找到数据
			}else if(key < searchTable[mid]){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return -1;//未找到数据
	}
}