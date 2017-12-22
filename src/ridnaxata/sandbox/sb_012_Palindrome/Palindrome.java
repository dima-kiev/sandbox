package ridnaxata.sandbox.sb_012_Palindrome;

public class Palindrome {

    public static boolean isPalindrome(String word) {

        char[] chars = word.toLowerCase().toCharArray();
        int tail = chars.length - 1 ;

        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[tail-i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
        System.out.println(Palindrome.isPalindrome("Dele1veled"));
    }
}
