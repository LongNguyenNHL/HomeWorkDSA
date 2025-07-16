package HomeWorkDay28;

public class CalculateTheSquare {
	public static void main(String[] args) {
		System.out.println(solution(10,20));
		System.out.println(solution(6000,7000));
		System.out.println(solution(2, 2));
		System.out.println(solution(2, 1000000));
		System.out.println(solution(2, 1000000000));
	}
	public static int solution (int A, int B) {
		if (A < 2 || B < 2) {
			System.out.println("Invalid input");
			return 0;
		}
		
		int maxCount = 0;
		for (int i = (int) Math.sqrt(A); i * i <= B; i++) {
			int num = i * i;
			int temp = num;
			int count = 0;
			
			if (num < A) {
				continue;
			}
			
			while (Math.sqrt(temp) == (int) Math.sqrt(temp)) {
				count++;
				temp = (int) Math.sqrt(temp);
			}
			
			if (maxCount < count) {
				maxCount = count;
			}
		}
		return maxCount;
	}
}