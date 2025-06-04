package be8;

public class FindIntervalInArray {
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	// Additional Space: O(R)
	public static int solution (int[] A, int L, int R) {
		
		// Example Test Case 2
		// Tao mang de gan index [0,0,0,0,0]
		int[] fragment = new int[R + 1];
		
		// Gan index cua mang A sang vi tri trong mang fragment tuong ung
		// => fragment = [0,0,5,4,3]
		for (int i = 0; i < A.length / 2 + 1; i++) {
			if ((A[i] <= R) && (A[i] >= L)) {
				fragment[A[i]] = i + 1; // +1 để không trung với trường hợp có index 0
			}
			int j = A.length - i - 1;
			if ((A[j] <= R) && (A[j] >= L)) {
				fragment[A[j]] = j + 1; 
			}
		}
		
		// max - min  + 1 = 5 - 3 + 1 = 3 => Shortest = 3;
		int min = A.length - 1;
		int max = 0;
		for (int i = L; i < fragment.length; i++) {
			if (fragment[i] == 0) {
				return -1;
			}
			
			if (fragment[i] < min) {
				min = fragment[i];
			}
			if (fragment[i] > max) {
				max = fragment[i];
			}
		}

		int shortest = max - min + 1;
		return shortest;
	}
	
	public static void main(String[] args) {
		//Test case 1
		int[] A = {2,1,4,3,5,1,6,3,4,5};
		int L = 2;
		int R = 5;
		System.out.println(solution(A,L,R));
		
		//Test case 2
		int[] A1 = {2,1,4,3,2,1,1,4};
		int L1 = 2;
		int R1 = 4;
		System.out.println(solution(A1,L1,R1));
		
		//Test case 3
		int[] A2 = {1,3,5,7};
		int L2 = 3;
		int R2 = 5;
		System.out.println(solution(A2,L2,R2));
		
		//Test case 4
		int[] A3 = {109, 1, 1, 1, 1, 1, 108};
		int L3 = 108;
		int R3 = 109;
		System.out.println(solution(A3,L3,R3));
		
		//Test case 5
		int[] A4 = {5, 6, 7, 4, 3, 2, 1};
		int L4 = 3;
		int R4 = 5;
		System.out.println(solution(A4,L4,R4));
	}
}