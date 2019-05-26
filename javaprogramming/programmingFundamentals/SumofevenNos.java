package programmingFundamentals;

import java.util.Scanner;

public class SumofevenNos {
	
//To find sum of even no.s till N
	
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		if(n%2!=0)
			n--;
		int sum = n*(2+n);
		sum/=4;
		System.out.println(sum);
	}

}
