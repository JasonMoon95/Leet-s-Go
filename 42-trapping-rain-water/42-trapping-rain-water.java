import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    ArrayList<Integer> stack = new ArrayList<>();

    public int trap(int[] height) {
            // stack에는 { index: number, val: number } 형태의 object를 담는다.
            int answer = 0;
          
            for (int i = 0; i < height.length; i++) {
              // stack이 비어있지 않고 stack의 top element가 현재 height보다 높은 경우
              if (!stack.isEmpty() && height[i] > height[stack.get(stack.size() - 1)]) {
                stack.remove(stack.size()-1); // 첫 번째 요소 제거
                while (!stack.isEmpty()) {
                  int left = stack.get(stack.size() - 1);
                  int base = 0;
                  for(int j:Arrays.copyOfRange(height, left + 1, i)) base = Math.max(j,base);
                  int localHeight = 100001;
                  localHeight = Math.min(height[i], height[left]) - base;
                  int width = i - left - 1;
                  answer += localHeight * width;
                  if (height[left] >= height[i]) { // 현재 바(height[i])보다 높은 값을 만나면 while loop 중단
                    break;
                  }
                  // stack에서 요소 하나를 제거한다.
                  stack.remove(stack.size()-1);
                }
              }
              // 나머지 경우 stack에 object를 추가해준다.
              stack.add(i);
            }
          
            return answer;
          };
}