import java.util.List;

class Node{
    Node[] arr = new Node[26];
    boolean word = false;
}
class Solution 
{
    void add(String s,Node root)
    {
        Node temp = root;
        for(char ch : s.toCharArray())
        {
            if(temp.arr[ch-'a']==null)
                temp.arr[ch-'a'] = new Node();
            temp = temp.arr[ch-'a'];
        }
        temp.word = true;
    }
   boolean search(String s, int i, Node temp, int dp[],Node root)
   {
        if(i==s.length()) 
            return true;
        if(dp[i]!=0) 
            return dp[i]==1;
        if(temp.arr[s.charAt(i)-'a']==null) 
            return false;

        while(i<s.length() && temp!=null)
        {
            temp = temp.arr[s.charAt(i)-'a'];
            if(temp!=null && temp.word)
            {
                Node x = root;
                dp[i+1] = search(s, i+1, x,dp,root) ? 1 : -1;
                if(dp[i+1]==1) return true;
            }
            i++;
        }
        if(temp==null) 
            return false;
        return i==s.length() ? temp.word : false;
    }
    
    public static void main(String s, List<String> wordDict) 
    {
    	Solution sol=new Solution();
        int[] dp;
        Node root = new Node();
        for(String str : wordDict) 
        	sol.add(str,root);
        Node temp = root;
        dp = new int[s.length()+1];
        System.out.println(sol.search(s, 0, temp, dp, root)); 
    }
}