class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(), n2 = t.length();

        if(n1 != n2)
            return false;

        Map<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < n1; i++){
            if(mp.containsKey(s.charAt(i)))
                mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
            else
                mp.put(s.charAt(i), 1);
        }

        for(int j = 0; j < n2; j++){
            if(mp.containsKey(t.charAt(j)))
                mp.put(t.charAt(j), mp.get(t.charAt(j))-1);
            else
                return false;
        }
        
        for(Map.Entry<Character, Integer> m: mp.entrySet())
            if(m.getValue() != 0)
                return false;

        return true;
    }
}
