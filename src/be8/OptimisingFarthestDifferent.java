package be8;

public class OptimisingFarthestDifferent {
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
	// Additional Space: O(1)
	public static int solution (int[] A) {
		int N = A.length;
		
		if (A[0] != A[N - 1]) {
			return N - 1;
		}
		
		int left = 0;
		
		while (left < N && A[left] == A[N - 1]) {
			left++;
		}
		
		int right = N - 1;
		while (right >= 0 && A[right] == A[0]) {
			right--;
		}
		
		return Math.max(N - 1 - left, right);
	}
	public static void main(String[] args) {
		int[] A = {4,6,2,2,6,6,4};
		System.out.println(solution(A));
	}
}