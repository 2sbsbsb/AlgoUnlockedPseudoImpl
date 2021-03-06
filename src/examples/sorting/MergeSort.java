package examples.sorting;

import java.util.Arrays;

/**
 * Implementation of pseudo code from Book Algorithm Unlocked [Ch#3 : Section 4 : Merge Sort ]
 * 
 * Merge-Sort(A,p,r)
 *  
 * Input A-array, p - start index , r - end index
 * Result - Sorted array A[p...r] in non-decreasing order. 
 * 
 * Step 
 * 	1. if(p>=r) Do nothing 
 * 	2. Otherwise 
 * 		1. Set q = (p+r)/2
 * 		2. Recursively call Merge-Sort(A,p,q)
 * 		3. Recursively call Merge-Sort(A,q+1,r)
 * 		4. Combine(A,p, q,r) 

 * where combine routine is 
 * 
 * Combine(A,p, q,r) 
 * Input A-array, A[p...q] and A[q+1...r] are sorted array	
 * 1. Set n1 = q-p+1 and Set n2 = r-q; 
 * 2. Let  B[1...n1+1] and C[1...n2+1] be new arrays 
 * 3. Copy A[p..q] to B[1...n1] and copy A[q+1...r] into C[1...n2]
 * 4. Set both B[n1+1] and C[n2+1] to infinity 
 * 5. Set both i and j = 0 [In the book it is infinity(which appears to by typo]
 * 6. For k=p to r
 * 	1. If B[i] <= C[j] then set A[k] to B[i] and increment i
 * 	2. If B[i] > C[j] then set A[k] to C[j] and increment j
 * 
 * @author santosh.bhushan
 */
public class MergeSort {

    /**
     * @param A
     * @param p
     * @param q
     * @param r
     */
    private static void combine(int[] A, int p, int q, int r) {
	StringBuilder sb = new StringBuilder();
	sb.append("A=");
	for (int i = p; i <= q; i++) {
	    sb.append(A[i]);
	    sb.append(" ");
	}
	sb.append(", B=");
	for (int i = q + 1; i <= r; i++) {
	    sb.append(A[i]);
	    sb.append(" ");
	}
	// Elements in the 1st array
	int n1 = q - p + 1;
	// Elements in the 2nd array
	int n2 = r - q;
	// Even though the book suggests to create a new array. It can be done away by creating just one workspace array
	int[] B = new int[n1 + 1];
	int[] C = new int[n2 + 1];
	// Sentinel Concept
	B[n1] = Integer.MAX_VALUE;
	C[n2] = Integer.MAX_VALUE;
	// There is to much copy in merge sort. Not in place sorting
	System.arraycopy(A, p, B, 0, n1);
	System.arraycopy(A, q + 1, C, 0, n2);
	//
	int i = 0;
	int j = 0;
	int k = p;
	while (k <= r) {
	    if (B[i] <= C[j]) {
		A[k++] = B[i++];
	    } else if (C[j] < B[i]) {
		A[k++] = C[j++];
	    }
	}
	sb.append(", C=");
	for (int l = p; l <= r; l++) {
	    sb.append(A[l]);
	    sb.append(",");
	}
	System.out.println(sb.toString());
    }

    /**
     * Merge array from startIndex to endIndex  
     * 
     * @param A
     * @param startIndex
     * @param endIndex
     * Note - The name ends with Recursive just to emphasis that this method is getting called recursively  
     */
    private static void mergeSortRecursive(int[] A, int startIndex, int endIndex) {
	if (startIndex >= endIndex) {
	    return;
	} else {
	    int half = (startIndex + endIndex) / 2;
	    mergeSortRecursive(A, startIndex, half);
	    mergeSortRecursive(A, half + 1, endIndex);
	    combine(A, startIndex, half, endIndex);
	}
    }

    /**
     * @param a
     */
    private static void mergeSort(int[] A) {
	System.out.println("Input=" + Arrays.toString(A));
	mergeSortRecursive(A, 0, A.length - 1);
	System.out.println("Output=" + Arrays.toString(A));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[] A = { 0, 2, 3, 355, 67, 8, 1, 23, -5, 2, 3, -4, 5, 55, 5, 7, 2, 6, 1, 3, 2 };
	mergeSort(A);
    }

}
