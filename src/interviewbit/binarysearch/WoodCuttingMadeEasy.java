package interviewbit.binarysearch;

public class WoodCuttingMadeEasy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4, 42, 40, 26, 46};
		int b = 20;
		int l = 0;
		int r = Integer.MAX_VALUE;
		while(l+1<r) {
			int mid = l+(r-l)/2;
			if(predicate(a,mid,b)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(l);
	}

	private static int predicate(int[] arr, int height, int b) {
		// TODO Auto-generated method stub
		long currB = 0;
		for(int ele:arr) {
			if(ele>height) {
				currB += (ele-height);
			}
		}
		if(currB>=b)
			return 0;
		else
			return 1;
	}

}
