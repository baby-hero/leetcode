package hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
class MedianOfTwoSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length, n = l1 + l2, medianIndex = n/2;
        int i=0,j=0,val=0, lastVal =0;
        for(int k=0;k<=medianIndex;k++){
            if(j==l2){
                val=nums1[i];
                i++;
            }
            else if(i==l1){
                val=nums2[j];
                j++;
            }
            else if(nums1[i]<=nums2[j]){
                val=nums1[i];
                i++;
            }
            else{
                val=nums2[j];
                j++;
            }
            if (k < medianIndex) {
                lastVal = val;
            }
        }
        if (n%2 == 0) {
            return (val + lastVal)/2.0;
        } else {
            return val;
        }
    }
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        // Test case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }
}