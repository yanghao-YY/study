package 每日一题.字符串20210720;

/**
 * @author hao.yang
 * @date 2021/7/20
 */

import java.util.Stack;

/**
 *  * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  * 示例 1：
 *  * 输入：s = "babad"
 *  * 输出："bab"
 *  * 解释："aba" 同样是符合题意的答案。
 *  *
 *  * 示例 2：
 *  * 输入：s = "cbbd"
 *  * 输出："bb"
 *  * 示例 3：
 *  *
 *  * 输入：s = "a"
 *  * 输出："a"
 *  * 示例 4：
 *  *
 *  * 输入：s = "ac"
 *  * 输出："a"
 *  *
 *  * 提示：
 *  * 1 <= s.length <= 1000
 *  * s 仅由数字和英文字母（大写和/或小写）组成
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        String rs = reverseString(s);
        if(s.equals(rs)) return s;
        String result = null;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == rs.charAt(i)){
                sb.append(s.charAt(i));
                if((i >= 1) && (rs.charAt(i - 1) == sb.charAt(0))){
                    sb.append(rs.charAt(i));
                }
                flag = true;
            }else {
                if(result == null){
                    result = sb.toString();
                }else {
                    result = result.length() > sb.length() ? result : sb.toString();
                    sb.delete(0,sb.length());
                }
            }
        }
        if(!flag){
            result = s.substring(0,1);
        }
         return result;
    }

    public static String reverseString(String s){
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.add(s.charAt(i));
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(LongestPalindrome.longestPalindrome("babad"));
//        System.out.println(LongestPalindrome.longestPalindrome("cbbd"));
//        System.out.println(LongestPalindrome.longestPalindrome("a"));
//        System.out.println(LongestPalindrome.longestPalindrome("ac"));
        System.out.println(LongestPalindrome.longestPalindrome("cbbd"));
    }
}
