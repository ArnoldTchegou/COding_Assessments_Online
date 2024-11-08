import java.util.*;  
public class MaxScoreBalancedSubstring {
    public int maxScore(String s) {
        int maxScore = 0;
        Stack<Integer> stack = new Stack<>();

        // Traverse through each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Push the index of '(' onto the stack
                stack.push(i);
            } else if (!stack.isEmpty()) {
                // Pop the index of the matching '(' from the stack
                int openIndex = stack.pop();
                
                // Calculate the score for this balanced pair
                int score = i - openIndex;
                
                // Accumulate the score to get the maximum possible
                maxScore += score;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        MaxScoreBalancedSubstring solver = new MaxScoreBalancedSubstring();
        
        // Example test case
        String s = "()()";
        System.out.println(solver.maxScore(s)); // Expected output: 4
    }
}
