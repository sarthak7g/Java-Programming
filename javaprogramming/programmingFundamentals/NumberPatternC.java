package programmingFundamentals;

import java.util.Scanner;

public class NumberPatternC 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i=1;i<=n;i++) {
			int k=1;
			for(int j=i;j<=n;j++) {
				System.out.print(k++);
			}
			System.out.println();
		}
		
	}
}
