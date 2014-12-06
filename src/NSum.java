import java.util.ArrayList;
import java.util.Arrays;

public class NSum {

	//Return all the satisfying pairs
	//Time complexity is O(nlgn + n) = O(nlsgn)
	static ArrayList<int[]> TwoSum(int a[], int sum){
		ArrayList<int[]> result = new ArrayList<int[]>();
		
		QuickSort(a, 0 , a.length - 1);
		int i = 0, j = a.length - 1;
		while(i < j){
			if(a[i] + a[j] > sum){
				j --;
			}
			else if(a[i] + a[j] < sum){
				i ++;
			}
			else{
				int r[] = {a[i], a[j]};
				result.add(r);
				i ++;
				j --;
			}
		}
		
		return result;
	}
	
	//Usually the target sum is zero in 3-sum problem
	//Time complexity is O(nlgn + n^2) = O(n^2)
	static ArrayList<ArrayList<Integer>> ThreeSum(int a[], int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		QuickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		
		for(int k = 0; k < a.length; k ++){
			int i = 0, j = a.length - 1;
			while( i < j ){
				if(a[i] + a[j] + a[k] > sum || j == k){
					j --;
				}
				else if(a[i] + a[j] + a[k] < sum || i == k){
					i ++;
				}
				else if(a[i] + a[j] + a[k] == sum && i != k && j != k){
					ArrayList<Integer> rr = new ArrayList<Integer>();
					if( k < i){
						rr.add(a[k]);
						rr.add(a[i]);
						rr.add(a[j]);
					}
					else if( i < k && k < j ){
						rr.add(a[i]);
						rr.add(a[k]);
						rr.add(a[j]);
					}
					else{
						rr.add(a[i]);
						rr.add(a[j]);
						rr.add(a[k]);
					}
					
					if(!result.contains(rr))
						result.add(rr);
					
					i ++;
					j --;
				}
			}//end of while
		}//end of for
		
		return result;
	}
	
	
	//TODO:
	static void ThreeSumClosest(int a[], int sum){
		;
	}
		
	//TODO:
	static void FourSum(int a[], int sum){
		;
	}
	
	//Suppose that the array is sorted in the increasing order
	//Return the index of target
	static int BinarySearch(int a[], int target){
		int left, right, middle;
		left = 0;
		right = a.length - 1;
		
		while(left <= right){
			middle = left + (right - left) / 2;
			if(a[middle]  > target){
				right = middle - 1;
			}
			else if(a[middle] < target){
				left = middle + 1;
			}
			else
				return middle;
		}
		
		return -1;
	}
	
	//Quick sort is unstable. (in-place)
	//Time complexity: O(nlgn)
	static void QuickSort(int a[], int left, int right){
//		System.out.println("left:" + left + "\t right:" + right);
		if(left >= right)
			return;
		
		int mark = a[left];
		int i = left + 1, j = right;
		while( true ){
			while( a[i] < mark && i != right)
				i ++;
			while( a[j] >= mark && j != left)
				j --;
			if( i < j ){
				//swap a[i] and a[j]
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
			else
				break;
		}
		//swap a[left] and a[j]
		int tmp = a[left];
		a[left] = a[j];
		a[j] = tmp;
		
//		System.out.println("-j:" + j);
//		System.out.println(Arrays.toString(a));
		
//		System.out.println("--left:" + left + "\t right:" + (j-1));
		QuickSort(a, left, j-1);
		QuickSort(a, j+1, right);
	}
	
	static void QuickSort2(int a[], int s, int t){
		int i, j;
		if(s<t){
			i=s;
			j=t+1;
			while(true){
				do{
					i ++;
				}while(!(a[s]<=a[i]||i==t));
				do{
					j --;
				}while(!(a[s]>=a[j])||j==s);
				if(i<j){
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
				else
					break;
			}
			
			int tmp = a[s];
			a[s] = a[j];
			a[j] = tmp;
			
			QuickSort2(a,s,j-1);
			QuickSort2(a,j+1, t);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {3, 7, 8, 5, 2, 1, 9, 5, 4};
		int b[] = {-1, 0, 1, 2, -1, -4};
		int c[] = {-6,7,3,9,6,-1,-7,1,-2,3,3,6,6,-6,8,-8,4,-1,-8,5,-3,-9,9,-5,-5,-6,-5};
		int d[] = {13,4,-6,-7,-15,-1,0,-1,0,-12,-12,9,3,-14,-2,-5,-6,7,8,2,-4,6,-5,-10,-4,-9,-14,-14,12,-13,-7,3,7,2,11,7,9,-4,13,-6,-1,-14,-12,9,9,-6,-11,10,-14,13,-2,-11,-4,8,-6,0,7,-12,1,4,12,9,14,-4,-3,11,10,-9,-8,8,0,-1,1,3,-15,-12,4,12,13,6,10,-4,10,13,12,12,-2,4,7,7,-15,-4,1,-15,8,5,3,3,11,2,-11,-12,-14,5,-1,9,0,-12,6,-1,1,1,2,-3};
		
		//test of quicksort
		NSum.QuickSort(b, 0, b.length-1);
		System.out.println(Arrays.toString(b));
		
		//test of 2-sum
//		ArrayList<int[]> rr = NSum.TwoSum(a, 10);
//		System.out.println("There're " + rr.size() + " pairs.");
//		for(int i = 0; i < rr.size(); i ++){
//			System.out.println(Arrays.toString(rr.get(i)));
//		}
		
		//test of 3-sum
//		ArrayList<ArrayList<Integer>> r = NSum.ThreeSum(c, 0);
//		for(int i = 0; i < r.size(); i ++)
//			System.out.println(r.get(i));
	}

}
