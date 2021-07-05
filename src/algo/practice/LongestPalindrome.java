package algo.practice;

/**
 * 最长回文子串
 */
public class LongestPalindrome {

    /**
     * f(n-k) = f(n + k)
     * 0 - k , k - s.length()
     */
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            int curLen = Math.max(i, s.length() - i - 1);
            String palindrome;
            String withCenter = calWithCenter(i, curLen, s);
            String withoutCenter = calWithoutCenter(i, curLen, s);
            if (withCenter.length() > withoutCenter.length()) {
                palindrome = withCenter;
            } else {
                palindrome = withoutCenter;
            }
            if (longestPalindrome.length() < palindrome.length()) {
                longestPalindrome = palindrome;
            }
        }
        return longestPalindrome;
    }

    private String calWithCenter(int i, int curLen, String s) {
        StringBuilder palindrome = new StringBuilder();
        for (int j = 0; j <= curLen; j++) {
            if (0 == j) {
                palindrome = new StringBuilder(String.valueOf(s.charAt(i)));
                continue;
            }
            if (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                palindrome = new StringBuilder(s.charAt(i - j) + palindrome.toString() + s.charAt(i + j));
            } else {
                break;
            }
        }
        return palindrome.toString();
    }

    private String calWithoutCenter(int i, int curLen, String s) {
        StringBuilder palindrome = new StringBuilder(String.valueOf(s.charAt(i)));
        for (int j = 0; j <= curLen; j++) {
            if (i - j > 0 && i + j >= 0 && i + j < s.length() && s.charAt(i - j - 1) == s.charAt(i + j)) {
                if (i == i + j) {
                    palindrome.insert(0, s.charAt(i - j - 1));
                } else {
                    palindrome = new StringBuilder(s.charAt(i - j - 1) + palindrome.toString() + s.charAt(i + j));
                }
            } else {
                break;
            }
        }
        return palindrome.toString();
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("a"));
        System.out.println(longestPalindrome.longestPalindrome("babab"));
        System.out.println(longestPalindrome.longestPalindrome("ac"));
        System.out.println(longestPalindrome.longestPalindrome("abbc"));
        System.out.println(longestPalindrome.longestPalindrome("bb"));
        System.out.println(longestPalindrome.longestPalindrome("ccc"));
        System.out.println(longestPalindrome.longestPalindrome("aaaa"));
    }
}
