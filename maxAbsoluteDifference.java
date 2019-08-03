public class Solution {
    public int maxArr(ArrayList<Integer> A) {
        int maxPlusValue = A.get(0) + 0;
        int minPlusValue = A.get(0) + 0;
        int maxMinusValue = A.get(0) - 0;
        int minMinusValue = A.get(0) - 0;
        
        for (int i = 1 ; i < A.size() ; i ++) {
            maxPlusValue = Math.max(maxPlusValue, A.get(i) + i);
            minPlusValue = Math.min(minPlusValue, A.get(i) + i);
            maxMinusValue = Math.max(maxMinusValue, A.get(i) - i);
            minMinusValue = Math.min(minMinusValue, A.get(i) - i);
        }
        return Math.max(maxPlusValue - minPlusValue, maxMinusValue - minMinusValue);
    }
}
