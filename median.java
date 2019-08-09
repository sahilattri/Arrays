public class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size()) return findMedianSortedArrays(b, a);
        if (a.size() == 0) {
         //System.out.println("size is zero");
            int n = b.size();
            int m = (n - 1) / 2;
            return b.size() % 2 == 0 ? (b.get(m) + b.get(m + 1)) / 2f : b.get(m);
        }
        int l = 0; int h = a.size();
        while(l <= h) {
            int mid = (l + h) / 2;
            
            int totalElems = a.size() + b.size();
            int elemsA = mid;
            int elemsB = (totalElems + 1) / 2 - elemsA;
            elemsB = elemsB < 0 ? 0 : elemsB;

            int aGroupALastElem = elemsA != 0 ? a.get(elemsA - 1) : Integer.MIN_VALUE;
            int bGroupALastElem = elemsB != 0 ? b.get(elemsB - 1) : Integer.MIN_VALUE;
            
            int aGroupBFirstElem = elemsA < a.size() ? a.get(elemsA) : Integer.MAX_VALUE;
            int bGroupBFirstElem = elemsB < b.size() ? b.get(elemsB) : Integer.MAX_VALUE;
            
            if (aGroupALastElem <= bGroupBFirstElem && bGroupALastElem <= aGroupBFirstElem) {;
                return findMedian(aGroupALastElem, bGroupALastElem, bGroupBFirstElem, aGroupBFirstElem, totalElems);
            } else if (aGroupALastElem > bGroupBFirstElem) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
            
        }
        return 0;
        
    }
    public float findMedian(int a, int b, int c, int d, int n) {
       // System.out.println("lets see " + n + " " + a + " " + b + " " + c + " " + d);
        if (n % 2 != 0) {
            return Math.max(a, b);
        }
        return (Math.max(a, b) +  Math.min(c, d)) / 2f;
    }
}
