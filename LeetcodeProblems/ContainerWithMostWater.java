/*
https://leetcode.com/problems/container-with-most-water/description/

*/

public class ContainerWithMostWater {

    public static void main(String[] args) {
        // Example usage
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water container: " + maxArea(heights));
    }

    // Function to calculate the maximum area of water container
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * minHeight);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}