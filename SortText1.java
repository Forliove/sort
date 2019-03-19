package sort.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 直接插入排序之顺序排序
 * @author forliove
 *
 */
public class SortText1 {
	public static void main(String[] args) {
		int[] arr = {8,2,5,17,19,12,11,23,50,1,6,45};
		
//		int[] arr = new int[10000];
//		int x = 0;
//		for(x=0;x<10000;x++) {
//			arr[x] = x;
//		}
//		List<int[]> list = Arrays.asList(arr);
//		Collections.shuffle(list);
//		int[] arr1 = list.toArray();
		long l1 = System.nanoTime();
		System.out.print("顺序排序后："+insertSort(arr));
		long l2 = System.nanoTime();
		System.out.println(l2-l1);
	}
	
	/**
	 * 直接插入排序之顺序插入
	 * @param arr
	 */
	public static String insertSort(int[] arr) {
		int len = arr.length;
		int i,j;
		if(len>=2) {
			arr = Arrays.copyOf(arr, len+1);
			len = len+1;
			int temp = arr[0];
			arr[0] = arr[len-1];
			arr[len-1] = temp;
		}else {
			return Arrays.toString(arr);
		}
		for(i=2;i<len;++i) {
			if(arr[i]<arr[i-1]) { //若小，需将arr[i]插入有序子表
				arr[0] = arr[i]; //复制为“哨兵”
				for(j=i-1;arr[0]<arr[j];--j) {
					arr[j+1] = arr[j]; //记录后移
				}
				arr[j+1] = arr[0]; //插入到正确位置
			}
		}
		arr = Arrays.copyOfRange(arr,1,len);
//		System.arraycopy(arr, 1, arr, 0, len-1); //不可取
		return Arrays.toString(arr);
	}
}
