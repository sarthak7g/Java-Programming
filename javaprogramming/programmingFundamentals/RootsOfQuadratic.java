package programmingFundamentals;

import java.util.Scanner;

public class RootsOfQuadratic {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		double d = b*b-4*a*c;
		if(d<0)
			System.out.println(-1);
		else if(d>=0) {
			double p = -1*b + Math.sqrt(d);
			p/=2*a;
			double q = -1*b - Math.sqrt(d);
			q/=2*a;
			int r = (int)Math.round(p);
			int t = (int)Math.round(q);
			if(r==t) {
				System.out.println(0);
				System.out.println(r + " " + t);
			}
			else {
				System.out.println(1);
				System.out.println(r + " " + t);
			}
		}
		
	}
}
