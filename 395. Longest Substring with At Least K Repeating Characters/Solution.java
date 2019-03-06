class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if(len == 0 || k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Character filter = null;
        Set<Character> keys = map.keySet();
        for(Character c : keys) {
            if(map.get(c) < k) {
                filter = c;
            }
        }
        int ans = 0;
        if(filter == null) {
            return len;
        }
        String[] subStrings = s.split("" + filter);
        for(String sub : subStrings) {
            ans = Math.max(ans, longestSubstring(sub, k));
        }
        return ans;
    }
}
