package programmingFundamentals;

import java.util.Scanner;

public class NumberPatternB {
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(1);
		for(int i=1;i<n;i++) {
			System.out.print(i);
			int k=i-1;
			while(k--!=0)
				System.out.print(0);
			System.out.println(i);
		}

	}
}
