package easy;

public class SquaresOfASortedArray_977 {
    private int binarySearch(int[] nums, int l, int r) {
        if (l>= r) {
            return r;
        }
        int mid = (l + r) / 2;
        if (nums[mid] >= 0) {
            return binarySearch(nums, l, mid);
        } else {
            return binarySearch(nums, mid + 1, r);
        }
    }
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int mid = binarySearch(nums, 0, n);
        int l = mid - 1;
        int r = mid;
        int[] res = new int[n];
        for(int i =0; i < n; i++) {
            if (l < 0) {
                res[i] = nums[r] * nums[r];
                r += 1;
                continue;
            }
            if (r >= n) {
                res[i] = nums[l] * nums[l];
                l -= 1;
                continue; 
            }
            if (-nums[l] < nums[r]) {
                res[i] = nums[l] * nums[l];
                l -= 1;
            } else {
                res[i] = nums[r] * nums[r];
                r += 1;
            }
        }
        return res;
    }
}
