package dataStructurePractice;

public class minCostStairsRecurssion {


	    public static int minCost(int[] cost, int n) {
	        if (n == 0 || n == 1)
	            return cost[n];
	       int ans = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
	     
	        return ans ;
	    }

	    public static void main(String[] args) {
	        int[] cost = {10, 15, 20,45,17,25};
	        int n = cost.length;

	        //we can start from either 0 or 1
	        
	        int result = Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
	        System.out.println("Minimum Cost = " + result);
	    }
	}


