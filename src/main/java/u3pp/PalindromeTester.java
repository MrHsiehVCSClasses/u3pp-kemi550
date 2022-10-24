package u3pp;

public class PalindromeTester {

    /**
     * Tests whether a string is a palindrome. Case insensitive. 
     * @param s  the string to test
     * @return true if the string is a palindrome
     */
    public static boolean isPalindrome(String s) {
        
        s = s.replace(" ", "");
        
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--){
            rev += s.charAt(i);
        }
        
        boolean palindrome = true;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != rev.charAt(i)){
                palindrome = false;
            }
        }
        if (palindrome) {
            return true;
        } else {
            return false;
        }
        
    }
}