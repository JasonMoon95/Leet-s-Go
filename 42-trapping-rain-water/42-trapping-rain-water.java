import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer> stack = new ArrayList<>();

    public int trap(int[] height) {
            int answer = 0;
          
            for (int i = 0; i < height.length; i++) {
              if (!stack.isEmpty() && height[i] > height[stack.get(stack.size() - 1)]) {
                stack.remove(stack.size()-1);
                while (!stack.isEmpty()) {
                  int left = stack.get(stack.size() - 1);
                  int base = 0;
                  for(int j:Arrays.copyOfRange(height, left + 1, i)) base = Math.max(j,base);
                  int localHeight = 100001;
                  localHeight = Math.min(height[i], height[left]) - base;
                  int width = i - left - 1;
                  answer += localHeight * width;
                  if (height[left] >= height[i]) { 
                    break;
                  }
                  stack.remove(stack.size()-1);
                }
              }
              stack.add(i);
            }
          
            return answer;
          };
}