package HomeWorkDay28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class PublicTransportTicket {
	public static void main(String[] args) {
		System.out.println(solution(new LinkedList<>(Arrays.asList(1, 2, 4, 5, 7, 29, 30))));
		System.out.println(solution(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))));
		System.out.println(solution(new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 16)))); 
		System.out.println(solution(new LinkedList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 22)))); 
		System.out.println(solution(new LinkedList<>(Arrays.asList(1, 6, 7, 8, 9, 10, 11)))); 
	}
	
	// 1 day ticket = 2 
	// 7 day ticket = 7 - 7 ngay lien tiep
	// 30 day ticket = 25
	public static int solution (LinkedList<Integer> A) {
		HashMap<String, Integer> ticketType = new HashMap<String, Integer>();
		
		ticketType.put("1-Day", 2);
		ticketType.put("7-Day", 7);
		ticketType.put("30-Day", 25);
		
		int minCost = 0;
		
		if (A.size() >= 23) {
			return minCost = ticketType.get("30-Day");
		}
		
		if (A.size() < 4) {
			return minCost = ticketType.get("1-Day") * A.size();
		}

		int firstDay = A.get(0);
		int lastDay = firstDay + 6;
		int count = 0;
		
		while (!A.isEmpty()) {
			int curDay = A.removeFirst();
			
			if (curDay <= lastDay) {
				count++;
			} else {
				if (count < 4) {
					minCost = minCost + ticketType.get("1-Day") * count;
				} else {
					minCost = minCost + ticketType.get("7-Day");		
				}
				count = 1;
				firstDay = curDay;
				lastDay = firstDay + 6;
			}
		}
		
		if (count < 4) {
			minCost = minCost + ticketType.get("1-Day") * count;
		} else {
			minCost = minCost + ticketType.get("7-Day");		
		} 
		
		return minCost;
	}
	
}
