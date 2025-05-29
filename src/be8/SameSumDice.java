package be8;

import java.util.ArrayList;

public class SameSumDice {
	public static void main(String[] args) {
		// Case 1
		int[] A = {5,1};
		int[] B = {1,1,6};
		
		// Case 2
		int[] A1 = {5,2,3,5};
		int[] B1 = {2,5,4,5,6};
		
		// Case 3
		int[] A2 = {2,3,1,1,2}; // 9
		int[] B2 = {5,4,6,5,6}; // 26
		System.out.println(solution(A, B)); // 1
		System.out.println(solution(A1, B1)); // 2
		System.out.println(solution(A2, B2)); // 4
	}
	// Time complexity: O((n + m).log(n+m))
	public static int solution (int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}
		
		for (int i = 0; i < B.length; i++) {
			sumB += B[i];
		}
		
		int[] high;
		int[] low;
		
		if (sumA == sumB) {
			return 0;
		} else if (sumA < sumB) {
			high = B;
			low = A;
		} else {
			high = A;
			low = B;
		}
		
		int diff = Math.abs(sumA - sumB);
		
		// Calculate the max gain we can get from each dice 
		ArrayList<Integer> dices = new ArrayList<>();
		
		for (int x : high) {
			dices.add(x - 1); //maximum decrease
		}
		
		for (int x : low) {
			dices.add(6 - x); //maximum increase
		}
		
		dices.sort(null);
		
		int steps = 0;
		for (int i = dices.size() - 1; i >= 0; i--) {
			diff = diff - dices.get(i);
			steps += 1;
			if (diff <= 0) {
				return steps;
			}
		}
		return -1;
	}
}
