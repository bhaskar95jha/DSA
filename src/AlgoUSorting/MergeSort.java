package AlgoUSorting;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {38,27,43,3,9,82,10};
		int n = arr.length;
		mergeSort(arr);
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}

	private static void mergeSort(int[] arr) {
		int n = arr.length;
		if(n < 2) {
			return;
		}
		int mid = n / 2;
		
		int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
	}

	private static void merge(int[] arr, int[] left, int[] right) {
		// TODO Auto-generated method stub
	
		int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
		
	}

}