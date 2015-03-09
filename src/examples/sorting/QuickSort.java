package examples.sorting;

import java.util.Arrays;

/**
 * CLRS Implementation of pseudo code
 * 
 * @author santosh.bhushan
 */
public class QuickSort {

	/**
	 * Algorithm
	 * 
	 * @return q, where arr[1...q]<=a[q] and arr[q+1,....]>=a[q]
	 */
	private static int partition(int[] arr, int p, int r) {
		int q = p;
		System.out.println("Before partition p=" + p + " q=" + q + " r = " + r
				+ " and " + Arrays.toString(arr));
		for (int u = p; u < r; u++) {
			if (arr[u] <= arr[r]) {
				swap(arr, q, u);
				q++;
			}
		}
		swap(arr, r, q);
		System.out.println("After partition p=" + p + " q=" + q + " r = " + r
				+ " and " + Arrays.toString(arr));
		return q;
	}

	/**
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 */
	public static void quicky(int[] arr, int p, int r) {
		if (p < r) {
			int q = partition(arr, p, r);
			quicky(arr, p, q - 1);
			quicky(arr, q + 1, r);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 4, 5, 7, 2, 6, 1, 3, 2 };
		System.out.println("Input=" + Arrays.toString(arr));
		int p = 0;
		int r = arr.length - 1;
		quicky(arr, p, r);
		System.out.println("Output=" + Arrays.toString(arr));
	}

}