class Solution {
    public boolean canConstruct(String rs, String mg) {
        int rans[] = new int[26];
        int mag[] = new int[26];
        for (char c : rs.toCharArray())
            rans[c - 'a']++;

        for (char c : mg.toCharArray())
            mag[c - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (rans[i] > mag[i])
                return false;
        }
        return true;

    }
}