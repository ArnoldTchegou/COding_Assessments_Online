// User function Template for Java

class Solution {
    public int maxOnes(int arr[], int m) {
        int left = 0;  // Left index of the sliding window
        int right = 0; // Right index of the sliding window
        int maxCount = 0; // Maximum number of consecutive ones found
        int zeroCount = 0; // Count of zeros in the current window

        // Traverse the array using a sliding window
        while (right < arr.length) {
            // If we encounter a zero, increment the zero count
            if (arr[right] == 0) {
                zeroCount++;
            }

            // If we have more than m zeros, shrink the window from the left
            while (zeroCount > m) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum count of ones (window size)
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }
}