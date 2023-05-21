package interviewbit.binarysearch;

public class SearchForRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 17, 100, 111};
		int b = 3;
		int l = -1;
		int r = arr.length;
		int ans[] = new int[2];
		while(l+1<r){
			int mid = l + (r-l)/2;
			if(predicateFirst(arr[mid],b)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		if(arr[r]!=b) {
			ans[0] = -1;
			ans[1] = -1;
			for(int ele:ans)
				System.out.print(ele+" ");
			return; 
		}
			
		ans[0] = r;
		l = -1;
		r = arr.length;
		while(l+1<r){
			int mid = l + (r-l)/2;
			if(predicateSecond(arr[mid],b)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		ans[1] = l;
		for(int ele:ans)
			System.out.print(ele+" ");
		return;
	}

	private static int predicateSecond(int num, int b) {
		if(num<=b)
			return 0;
		else
			return 1;
	}

	private static int predicateFirst(int num, int b) {
		if(num<b)
			return 0;
		else
			return 1;
	}

}
