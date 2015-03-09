package examples.sorting;

import java.util.Arrays;

/**
 * Implementation of pseudo code from Book Algorithm Unlocked [Ch#3 : Section 5 : Quick Sort ]
 * 
 * 1. If p > r then just return without doing anything 
 * 2. Otherwise do the following 
 * 	a. Call partition (A,p,r) and set q to the result; 
 * 	b. Recursively	call quickSort(A,p,q-1) 
 * 	c. Recursively call quickSort(A,q+1,r)
 * 
 * Whereas the partition algorithm is
 * 
 * 1. Set q = p 
 * 2. For u = p to r-1 Do 
 * 	a. if A[u] <= A[r], then swap A[q] with A[u] and then increment q 
 * 3. Swap A[q] with A[r] and the return q
 * 
 * Note - u is variable but refers to u - unknown group. 
 * Hint to solve partition   
 * There can be four group. 
 * 	1. Left A[p,q-1] < A[q] 
 * 	2. Right A[q+1,r]> A[q] 
 * 	3. Unknown A[u,r-1]
 * and 4. A[q], the pivot and start with Left,Right as empty and all the elements belongs to Unknown
 * 
 * @author santosh.bhushan
 */
public class QuickSort {

   /**
    * @param arr
    * @param p
    * @param r
    * @return
    */
    private static int partition(int[] arr, int p, int r) {
	int q = p;
	System.out.println("Before partition p=" + p + " q=" + q + " r = " + r + " and " + Arrays.toString(arr));
	for (int u = p; u < r; u++) {
	    if (arr[u] <= arr[r]) {
		swap(arr, q, u);
		q++;
	    }
	}
	swap(arr, r, q);
	System.out.println("After partition p=" + p + " q=" + q + " r = " + r + " and " + Arrays.toString(arr));
	return q;
    }

    /**
     * Swap the content of i and j position
     * 
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }

    /**
     * Quick Sort
     * 
     * @param arr
     * @param p
     * @param r
     */
    public static void quickSort(int[] arr, int p, int r) {
	if (p <= r) {
	    int q = partition(arr, p, r);
	    // Note - a[q] is left out
	    quickSort(arr, p, q - 1);
	    quickSort(arr, q + 1, r);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] arr = { 0,2,3,355,67,8,1,23,-5,2,3,-4,5,55, 5, 7, 2, 6, 1, 3, 2 };
	System.out.println("Input=" + Arrays.toString(arr));
	int p = 0;
	int r = arr.length - 1;
	quickSort(arr, p, r);
	System.out.println("Output=" + Arrays.toString(arr));
    }

}
