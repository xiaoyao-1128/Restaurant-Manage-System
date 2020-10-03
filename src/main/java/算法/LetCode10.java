package 算法;

import java.math.BigDecimal;
/**
 * @Author: jiaRu
 */
public class LetCode10 {
    public static void main(String[] args) {
        LetCode10 test = new LetCode10();
        String s = "";
        String p = ".*.*";
        System.out.println(test.isMatch(s, p));
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        if(a.equals(b)){

        }
    }
    boolean flag = false;
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 ) {
            if (p.length() == 0){ return true;}
            else {return tanXin(s, p, p.charAt(0));}
        }
        else if(p.length() == 0) {return false;}
        else {return tanXin(s, p, p.charAt(0));}
    }
    public boolean tanXin(String s, String p, char temp){
        if(temp == '*'){return false;}
        if(s.length() == 0 && p.length() == 0) {return true;}
        else if(s.length() >= 0){
            if(p.length() == 0) {return false;}
            if(p.length() >= 2 && p.charAt(1) == '*'){
                temp = p.charAt(0);
                p = p.substring(2);
                flag = tanXin(s, p, temp);
                //如果返回true，说明后面可以完全匹配，而前面是已经判断成功的，所以返回true，如果返回false，说明后面不能匹配
                if(flag == true){
                    return true;
                }else{
                    if(s.length() > 0 && temp == '.'){
                        s = s.substring(1);
                        p = temp+"*"+p;
                        flag = tanXin(s, p, temp);
                    }
                    else if(s.length() > 0 && s.charAt(0) == temp){
                        s = s.substring(1);
                        p = temp+"*"+p;
                        flag = tanXin(s, p, temp);
                    }else {return false;}
                }
            }
            if(flag == true) {return true;}
            if(s.length() > 0 && p.charAt(0) == '.'){
                temp = '.';
                s = s.substring(1);
                p = p.substring(1);
                flag = tanXin(s, p, temp);
            }
            //如果一样就substring继续递归，如果不一样说明已经无法匹配，直接返回false
            else if(s.length() > 0 && (s.charAt(0) == p.charAt(0))){
                temp = p.charAt(0);
                s = s.substring(1);
                p = p.substring(1);
                flag = tanXin(s, p, temp);
            }else {return false;}
        }
        if(flag == true) {return true;}
        else {return false;}
    }
}

