class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            String s1=new String(c);
            if(!map.containsKey(s1)){
                map.put(s1,new ArrayList<>());
            }
            map.get(s1).add(strs[i]);
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> e:map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}