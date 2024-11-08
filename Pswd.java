import java.util.Arrays;

public class Pswd {
    public String[] checkSimilarPasswords(String[] newPasswords, String[] oldPasswords) {
        int n = newPasswords.length;
        String[] res = new String[n];

        for (int r = 0; r < n; r++) {
            // Check if oldPasswords[r] is a subsequence of newPasswords[r] after possible transformations
            if (isSubsequence(newPasswords[r], oldPasswords[r])) {
                res[r] = "YES";
            } else {
                res[r] = "NO";
            }
        }

        return res; // Return the result array
    }

    // Helper method to check if oldPassword can be a subsequence of newPassword with transformations
    private boolean isSubsequence(String newPassword, String oldPassword) {
        int j = 0; // Pointer for oldPassword

        for (int i = 0; i < newPassword.length() && j < oldPassword.length(); i++) {
            char newChar = newPassword.charAt(i);
            char oldChar = oldPassword.charAt(j);

            // Check if characters match or if transforming newChar makes it match oldChar
            if (newChar == oldChar || getNextChar(newChar) == oldChar) {
                j++; // Move pointer in oldPassword if there's a match
            }
        }

        // If we reached the end of oldPassword, it is a subsequence
        return j == oldPassword.length();
    }

    // Helper method to get the next cyclic character
    private char getNextChar(char c) {
        return (c == 'z') ? 'a' : (char) (c + 1);
    }

    public static void main(String[] args) {
        String[] n_pswd = {"baacbab", "accdb", "baacba"};
        String[] o_pswd = {"abdbc", "ach", "abb"};

        Pswd pswdChecker = new Pswd();
        String[] result = pswdChecker.checkSimilarPasswords(n_pswd, o_pswd);

        System.out.println(Arrays.toString(result)); // Expected output: ["YES", "NO", "YES"]
    }
}
