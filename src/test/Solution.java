package test;

public class Solution {
    public static void main(String[] args) {
        String s="abcde";
        int i = lengthOfLongestSubstring(s);
    }
    public static int lengthOfLongestSubstring(String s) {
        int []hash = new int [500];
        int max = 0;
        int i = 0, j = 0;

        while (i < s.length() && j <s.length() ) {
            if(hash[s.charAt(j)] == 0) {
                hash[s.charAt(j)] = 1;
                j++;
                max = (j - i) > max ? (j - i) : max;
            } else {
                hash[s.charAt(i)] = 0;
                i++;
            }  
        }
        return max; 
    }
}