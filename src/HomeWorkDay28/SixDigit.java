package HomeWorkDay28;

import java.util.Arrays;

public class SixDigit {
	public static void main(String[] args) {
		System.out.println(solution(1,8,3,6,2,4)); // 12:36:48
		System.out.println(solution(2,3,1,0,5,6)); // 01:23:56
		System.out.println(solution(1,2,4,5,6,9)); // 12:46:59
		System.out.println(solution(0,0,0,7,8,9)); // 07:08:09
		System.out.println(solution(2,4,5,9,5,9)); // NOT POSSIBLE
		System.out.println(solution(0, 0, 0, 0, 0, 0)); // 00:00:00
		System.out.println(solution(1, 2, 3, 4, 5, 6)); // 12:34:56
		System.out.println(solution(2, 4, 5, 9, 5, 9)); // NOT POSSIBLE
		System.out.println(solution(0, 1, 2, 3, 4, 5)); // 01:23:45
		System.out.println(solution(9, 9, 9, 9, 9, 9)); // NOT POSSIBLE
		System.out.println(solution(2, 3, 5, 6, 7, 8)); // NOT POSSIBLE
		System.out.println(solution(2, 3, 5, 5, 5, 5)); // 23:55:55
		System.out.println(solution(0, 1, 0, 2, 0, 3)); // 00:01:23
		System.out.println(solution(1, 1, 2, 2, 5, 9)); // 11:22:59
		System.out.println(solution(0, 6, 7, 8, 9, 9)); // NOT POSSIBLE
	}
	
	// Time Complexity: O(1) 
	// Space Complexity: O(1)
	public static String solution (int A, int B, int C, int D, int E, int F) {
		int[] list = {A,B,C,D,E,F};
		// O(N log(N))
		Arrays.sort(list);
		String result = "";
		int temp;
		
		if (list[0] > 2) {
			return "NOT POSSIPLE";
		}
		
		if (list[0] == 2 && list[1] > 4) {
			return "NOT POSSIPLE";
		}
		
		if (list[0] == 2 && list[1] == 4 && list[2] != 0) {
			return "NOT POSSIPLE";
		}
		
		if (list[2] > 5) {
			return "NOT POSSIPLE";
		}
		
		if (list[0] < 2) {
			if (list[3] > 5) {
				temp = list[1];
				list[1] = list[3];
				list[3] = list[4];
				list[4] = list[2];
				list[2] = temp;
			} else if (list[3] <= 5 && list[4] > 5) {
				temp = list[3];
				list[3] = list[4];
				list[4] = temp;
			}
		} else if (list[0] == 2) {
			if (list[3] > 5) {
				return "NOT POSSIPLE";
			}
		}
	
		for (int i = 0; i < list.length; i++) {
			String convert  = String.valueOf(list[i]);
			result = result + convert;
			if (i == 1 || i == 3) {
				result = result + ":";
			}
		}
		
		return result;
	}
}
