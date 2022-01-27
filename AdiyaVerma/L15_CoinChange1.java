import java.util.Scanner;
//total number of coins


public class L15_CoinChange1
{
	public static void main(String[] args)
	{
		int[] coins = {1, 2, 5};
		int amount = 5;	
		int result = change(amount, coins);
		System.out.println(result);	
	}

	 public static int change(int amount, int[] coins) {
       int n = coins.length;
        
        int[][] dp = new int[n+1][amount+1];
        
        //initialisation
        for(int i = 0; i<=n; i++)
        for(int j = 0; j<=amount; j++)
        {
            if(i == 0)
                dp[i][j] = 0;
            if(j == 0)
                dp[i][j] = 1;
        }
        
        for(int i = 1; i<=n; i++)
        {
            for(int j = 1; j<=amount; j++)
            {
                if(coins[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }


    
}