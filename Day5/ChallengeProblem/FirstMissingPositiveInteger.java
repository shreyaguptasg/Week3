package Day4.ChallengeProblem;

public class FirstMissingPositiveInteger {

    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Segregate positive numbers from non-positive numbers
        int shift = segregate(nums, n);
        int[] positiveArr = new int[n - shift];
        for (int i = 0; i < positiveArr.length; i++) {
            positiveArr[i] = nums[shift + i];
        }

        // Step 2: Mark presence of elements
        int size = positiveArr.length;
        for (int i = 0; i < size; i++) {
            int x = Math.abs(positiveArr[i]);
            if (x - 1 < size && positiveArr[x - 1] > 0) {
                positiveArr[x - 1] = -positiveArr[x - 1];
            }
        }

        // Step 3: Identify the first missing positive
        for (int i = 0; i < size; i++) {
            if (positiveArr[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }

    // Function to segregate positive and non-positive numbers
    private static int segregate(int[] nums, int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] <= 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("The smallest missing positive integer is: " + findFirstMissingPositive(nums));
    }
}





















































































































