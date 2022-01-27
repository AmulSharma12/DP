import java.util.Scanner;

public class L24_ShortestCommonSuperSequence
{
	public static void main(String[] args)
	{
		String a = "geek";
		String b = "eke";
		int m = a.length();
		int n = b.length();


		int result  = m+n -lcs(a, b, m, n);
		System.out.println(result);
	}


	//lcs method
	public static int lcs(String x, String y, int m, int n)
	{
		if(m == 0 || n == 0)
			return 0;


		if(x.charAt(m-1) == y.charAt(n-1))
			return 1 + lcs(x, y, m-1, n-1);

		return Math.max(lcs(x, y, m, n-1) , lcs(x, y, m-1, n));
	}
}