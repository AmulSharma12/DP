import java.util.Scanner;


public class L43_EggDropRecursive
{
	public static void main(String[] args)
	{
		System.out.println(twoEggDrop(2));
	}


	 public static int twoEggDrop(int n) {
        return solve(2,n);
    }
    
    
    public static int solve(int e, int f)
    {
        if(f == 1 || f == 0)
            return f;
        if(e == 1)
            return f;
        
        
        //minMoves to find threshold floor in worst case
        int minMoves = Integer.MAX_VALUE;
        
        for(int k = 1; k<=f; k++)
        {
            
            //1 attempt made -> max  for worst case
            int tempAns = 1 + Math.max(solve(e-1,k-1), solve(e,f-k));
            minMoves = min(minMoves, tempAns);
        }
        
        
        return minMoves;
        
    }
    
    
    public static int min(int first, int second)
    {
        return first>second ? second : first;
    }
}