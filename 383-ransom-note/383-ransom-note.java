class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int idx = 0;
        //String STR = "java"; 
        char[] StringtoCharRN = ransomNote.toCharArray();
        Arrays.sort(StringtoCharRN);
        String SortedRN = new String(StringtoCharRN);

        char[] StringtoCharMZ = magazine.toCharArray();
        Arrays.sort(StringtoCharMZ);
        String SortedMZ = new String(StringtoCharMZ);

        for(int i=0; i<magazine.length(); i++)
        {
            if(SortedRN.charAt(idx)==SortedMZ.charAt(i))
            {
                idx++;
            }
            if(idx>=SortedRN.length()) return true;
        }
        return false;
    }
}