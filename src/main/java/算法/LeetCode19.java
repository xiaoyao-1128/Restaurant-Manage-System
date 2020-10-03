package 算法;

/**
 * @author jinrui
 */
public class LeetCode19 {
    public static void main(String[] args) {
        LeetCode19 test = new LeetCode19();
        String s = "";
        test.minimumOperations(s);
    }
    public int minimumOperations(String leaves) {
        int counts = 0;
        char [] leaveArray = leaves.toCharArray();
        int yellowCount = 0, redCount = 0;
        if(leaveArray[0] == 'y'){
            leaveArray[0] = 'r';
            counts++;
        }
        if(leaveArray[leaveArray.length-1] == 'y'){
            leaveArray[leaveArray.length-1] = 'r';
            counts++;
        }
        for(int i = 1;i < leaveArray.length-1;i++){
            
        }
        return counts;
    }
}
