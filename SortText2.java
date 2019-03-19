package sort.code;

import java.util.Arrays;

/**
 * 快速排序测试
 * @author forliove
 *
 */
public class SortText2 {
	public static void main(String[] args) {
		int[] arr = {5,27,35,15,3,22,34,18,20,50,6,10};
		long l1 = System.nanoTime();
//		arr = newArray(arr);
//		System.out.println(Arrays.toString(arr));
		System.out.print("快速排序后："+quickSort(arr, 1, arr.length));
		long l2 = System.nanoTime();
		System.out.println(l2-l1);
	}
	
	/**
	 * 快速排序，第一步包括了对数组的处理
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static String quickSort(int[] arr,int low,int high) {
		arr = newArray(arr);
		System.out.println("改变后的数组："+Arrays.toString(arr)); //输出改变后的数组
		arr = quickSort1(arr, low, high);
		return Arrays.toString(arr);
	}
	
	/**
	 * 对数组快速排序,递归调用自身
	 * @param arr
	 * @param low
	 * @param high
	 * @return 
	 */
	public static int[] quickSort1(int[] arr,int low,int high) {
		int pivotloc;
		if(low < high) { //长度大于1
			//将数组arr[low...high]一分为二，pivotloc为枢轴元素排好序的位置，即中心点位置
			pivotloc = partition(arr,low,high); 
			quickSort1(arr, low, pivotloc-1); //对低子表递归排序
			quickSort1(arr, pivotloc+1, high); //对高子表递归排序
		}
		arr = Arrays.copyOfRange(arr,1,arr.length);
//		System.arraycopy(arr, 1, arr, 0, len-1); //不可取
		return arr;
	}
	
	/**
	 * 中心点位置
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] arr, int low, int high) {
		arr[0] = arr[low];
		int pivotloc = arr[low];
		while(low < high) {
			while(low<high && arr[high]>=pivotloc) {
				--high;
			}
			arr[low] = arr[high];
			while(low<high && arr[low]<=pivotloc) {
				++low;
			}
			arr[high] = arr[low];
		}
		arr[low] = arr[0]; //当low==high时，low位置元素为空，将0位置元素移过来
		return low;
	}
	
	/**
	 * 数组扩容，并使数组第一个元素为0
	 * @param arr
	 * @return
	 */
	public static int[] newArray(int[] arr) {
		int len = arr.length;
		arr = Arrays.copyOf(arr, len+1);
		len++;
		int temp = arr[0];
		arr[0] = arr[len-1];
		arr[len-1] = temp;
		return arr;
	}
}
