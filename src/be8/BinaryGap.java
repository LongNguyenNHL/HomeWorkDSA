package be8;

public class BinaryGap {
	public static void main(String[] args) {
		int n = 9;
		int result = solution(n);
		System.out.println("Max gap: " + result);
	}
	
	// Time complexity: O(logN)
	public static int solution (int n) {
		String binaryNumber = "";
		String remainder;
		while (n > 0) {
			remainder = String.valueOf(n % 2);
			n = n / 2;
			binaryNumber = remainder + binaryNumber;
		}
		
		System.out.println("Binary number: " + binaryNumber);
		
		int max = 0;
		int current = 0;
		for (int i = 1; i < binaryNumber.length(); i++) {
			if (binaryNumber.charAt(i) == '0') {
				current +=1;
			} else {
				if (current > max) {
					max = current;
				}
				current = 0;
			}
		}
		
		return max;
	}
}