package Arrays.StockBuySell;

public class stockBuySell {

    public static int maxProfit(Integer[] arr, int start, int end)
    {
    	if(end <= start)
    		return 0;

    	int profit = 0;

    	for(int i = start; i < end; i++)
    	{
    		for(int j = i + 1; j <= end; j++)
    		{
    			if(arr[j] > arr[i])
    			{
    				int curr_profit = arr[j] - arr[i] 
    								  + maxProfit(arr, start, i - 1)
    								  + maxProfit(arr, j + 1, end);

    				profit = Math.max(profit, curr_profit);
    			}
    		}
    	}

    	return profit;
    }

    public static Integer buySellEfficient(Integer arr[]){
        //The idea here is that you keep adding the profit till we have a up in the stock price when the stock price go down you let it
        //go down and the day it picks up you start adding the profit again.
        Integer profit = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                profit += arr[i]-arr[i-1];
            }
        }
        return profit;
    }

    public static void main(String args[]){
        Integer arr[] = {1,5,3,8,12};
        System.out.println(maxProfit(arr, 0, arr.length-1));
        System.out.println(buySellEfficient(arr));
    }
    
}
