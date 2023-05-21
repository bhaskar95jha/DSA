package interviewbit.binarysearch;

public class CapacityToShipPackageWithinBDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {3, 4, 17, 8, 8, 7, 8, 9, 13, 11, 10, 4};
		int b = 14;
		long l = 0;
		long r = 0;
		for(int ele:arr) {
			r += ele;
		}
		//System.out.println(l+" "+r);
		while(l+1<r) {
			long mid = l + (r-l)/2;
			if(predicate(mid,arr,b)==0) {
				l = mid;
			}else {
				r = mid;
			}
		}
		System.out.println(r);
	}

	private static int predicate(long weight, int[] arr, int days) {
		int currDays = 1;
		long currWeight = 0;
		for(int ele:arr) {
			if(ele>weight) {
				return 0;
			}
			currWeight += ele;
			
			if(currWeight>weight) {
				currWeight = ele;
				currDays++;
				if(currDays>days) {
					return 0;
				}
			}
			
		}
		if(currDays>days) {
			return 0;
		}else {
			return 1;
		}
	}

}
