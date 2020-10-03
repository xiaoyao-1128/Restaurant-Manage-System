package 算法;

public class LeetCode14 {
    public static void main(String[] args) {
        LeetCode14 test = new LeetCode14();
        String[] strs = {"flower","flow","flight"};
        System.out.println(test.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        while(true){
            int i = 0;
            char temp = strs[0].charAt(0);
            for(i = 0 ;i < strs.length;i++){
                if(strs[i].length() == 0) break;
                if(strs[i].charAt(0) == temp){
                    strs[i] = strs[i].substring(1);
                }else{
                    i--;
                    break;
                }
            }
            if(i == strs.length) result += String.valueOf(temp);
            else break;
        }
        return result;
    }
}
