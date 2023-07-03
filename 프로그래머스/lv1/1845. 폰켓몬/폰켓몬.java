import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums) {
            //map.put(a, map.getOrDefault(a, 0)+1);
            map.put(a, 1);
        }
        
        answer = ((map.size() >= nums.length/2) ? nums.length/2 : map.size());
        
        return answer;
    }
}