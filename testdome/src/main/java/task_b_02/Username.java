package task_b_02;

public class Username {

    public static String allowedLetters = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
    public static String allowedDigits  = "1234567890";
    public static String allowedSpecial = "-";

    public static boolean validate(String username) {

        return          ( username.length() >= 6 )
                    &&  ( username.length() <= 16 )
                    &&  ( !username.endsWith("-") )
                    &&  ( username.indexOf("-") == username.lastIndexOf("-"))
                    &&  ( containsOnly(username, allowedLetters + allowedDigits + allowedSpecial) )
                    &&  ( allowedLetters.indexOf(username.charAt(0)) != -1)
        ;

    }

    private static boolean containsOnly(String tested, String allowed) {
       char[] given = tested.toCharArray();

       for(int i = 0; i < given.length; i++) {
           if (allowed.indexOf(given[i]) == -1) return false;
       }

       return true;
    }

    public static void main(String[] args) {
        System.out.println(validate("Mike-Standish")); // Valid username
        System.out.println(validate("Mike Standish")); // Invalid username
    }
}
