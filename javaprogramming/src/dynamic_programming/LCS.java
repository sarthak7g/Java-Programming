package dynamic_programming;

import java.util.Scanner;

public class LCS {
	public static int lcs(String s1, String s2){
				int m=s1.length(),n=s2.length();
				
			int	a[][]=new int[m+1][n+1];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(s1.charAt(i)==s2.charAt(j))
					a[i+1][j+1]=a[i][j]+1;
				else a[i+1][j+1]=Math.max(a[i][j+1], a[i+1][j]);
			}
		}
		return a[m][n];	
	}
	
	public static void main(String[] args) {
		String s1,s2;
		Scanner s=new Scanner(System.in);
		System.out.println("enter String 1");
		s1=s.nextLine();
		System.out.println("enter String 2");
		s2=s.nextLine();
		System.out.println(lcs(s1, s2));
	}

}
