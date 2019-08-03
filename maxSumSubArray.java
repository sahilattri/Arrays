public class Solution {
    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        int [] maxSumFromThisPoint = new int [n];
        maxSumFromThisPoint[n - 1] = A.get(n - 1);
        
        for (int i = n - 2 ; i >= 0 ; i --) {
            maxSumFromThisPoint[i] = Math.max(maxSumFromThisPoint[i + 1] + A.get(i), A.get(i));
        }
         
        int currentSum = A.get(0);
        int maxSum = A.get(0);
        for (int i = 1 ; i < n ; i ++) {
            if (maxSumFromThisPoint[i] + currentSum >= currentSum && maxSumFromThisPoint[i] + currentSum >= maxSumFromThisPoint[i]) {
                currentSum += A.get(i);
            } else {
                maxSum = Math.max(currentSum, maxSum);
                currentSum = A.get(i);
            }
        }
        maxSum = Math.max(currentSum, maxSum);
        return maxSum;
    }
}
