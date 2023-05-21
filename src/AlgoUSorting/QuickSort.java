package AlgoUSorting;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {2,4,1,6,9,4,9,9,9,9,9};
		quickSort(arr,0,arr.length-1);
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println();
	}

	private static void quickSort(int[] arr,int s,int e) {
		// TODO Auto-generated method stub
		
		if(s>=e) {
			return;
		}
		
		int pivotIndex = partition(arr,s,e);
		
		quickSort(arr,s,pivotIndex);
		quickSort(arr,pivotIndex+1,e);

	}

	private static int partition(int[] arr,int s,int e) {
		// TODO Auto-generated method stub
		
		int pivot = arr[s];
		int count = 0;
		for(int i=s+1;i<=e;i++) {
			if(arr[i]<pivot)
				count++;
		}
		int pivotIndex = s + count;
		
		int temp = arr[pivotIndex];
		arr[pivotIndex] = arr[s];
		arr[s] = temp;
		
		int l = s;
		int r = e;
		while(l<pivotIndex && r>pivotIndex)  {
			while(arr[l]<pivot) {
				l++;
			}
			while(arr[r]>pivot) {
				r--;
			}
			
			if(l<pivotIndex && r>pivotIndex) {
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
			l++;
			r--;
			
		}
		return pivotIndex;
	}

}
