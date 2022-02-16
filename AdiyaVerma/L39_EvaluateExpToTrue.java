// boolean parenthesisation -> recursive solution

public class L39_EvaluateExpToTrue
{
	public static void main(String[] args)
	{
		String s = "T|F&T^F";
		int n = s.length();

		System.out.println(booleanParanthesis(s, 0, n-1, T));
	}

	public static int booleanParenthesis(String x, int i, int j, boolean isTrue)
	{
		if(i > j)
			return 0;

		if(i == j)
		{
			if(isTrue == true)
				return x.charAt(i) == "T" ? 1 : 0;
			else
				return x.charAt(i) == "F" ? 1 : 0;
		}


		int ans = 0;

		for(int k = i+1; k<j; k+=2)
		{
			int lt = booleanParanthesis(x, i, k-1, T);
			int lf = booleanParanthesis(x, i, k-1, F);
			int rt = booleanParanthesis(x, k+1, j, T);
			int rf = booleanParanthesis(x, k+1, j, F);

			if(x.charAt(k) == '&')
			{
				if(isTrue == "T")
					ans += lt*rt;
				else
					ans += lf*rt + rf*lt + lf*rf;
			}
			else if(x.charAt(k) == '|')
			{
				if(isTrue == "T")
					ans += lt*rt + lt*rf + lf*rt;
				else
					ans += lf*rf;
			}


			else if(x.charAt(k) == '^')
			{
				if(isTrue == "T")
					ans += lt*rf + lf*rt;
				else
					ans += lf*rf + lt*rt;
			}
		}

		return ans;
	}

}