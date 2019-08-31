public class Solution {
    int maxArea;
    public int largestRectangleArea(ArrayList<Integer> A) {
        LinkedList<Entry> stack = new LinkedList<Entry>();
        stack.push(new Entry(-1, 0));
        
        for (int i = 0 ; i <= A.size() ; i ++) {
            int index = i;
            int height = i == A.size() ? 0 : A.get(i);
            if (stack.peek().height == height) {
                continue;
            } else if (stack.peek().height < height) {
                stack.push(new Entry(i, A.get(i)));
            }  else {
                clearStack(stack, height, i);
            }
        }
        return maxArea;
    }
    
    private void clearStack(LinkedList<Entry> stack, int h, int i) {
        int last = -1;
        while(stack.peek().height > h) {
            Entry top = stack.peek();
            int area = (i - top.index) * top.height;
            maxArea = Math.max(area, maxArea);
            last = top.index;
            stack.pop();
        }
        if (stack.peek().height < h) {
            stack.push(new Entry(last, h));
        }
    }
}

class Entry {
    int index;
    int height;
    public Entry(int i, int h) {
        this.index = i;
        this.height = h;
    }
}
