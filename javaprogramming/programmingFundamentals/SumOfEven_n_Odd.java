package programmingFundamentals;

import java.util.Scanner;

public class SumOfEven_n_Odd {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int osum=0, esum=0;
		while(n!=0) {
			int a=n%10;
			if(a%2==0)
				esum+=a;
			else osum+=a;
			n/=10;
		}
		System.out.println(esum+" "+osum);
		
	}

}
