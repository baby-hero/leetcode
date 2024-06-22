#
# https://leetcode.com/problems/count-number-of-nice-subarrays/
#

from typing import List


class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        count_odd_nums = [0]
        for v in nums:
            count_odd_nums.append(count_odd_nums[-1] + (v % 2))

        count = 0
        prefix_odd_count_dict = {}
        keep_nums = k + 1
        print(count_odd_nums)
        old_count_odd = -1

        for count_odd in count_odd_nums:
            if count_odd >= k:
                count += prefix_odd_count_dict.get(
                    (count_odd - k) % keep_nums, 0
                )
            if count_odd == old_count_odd:
                prefix_odd_count_dict[
                    count_odd % keep_nums
                ] = prefix_odd_count_dict.get(
                    count_odd % keep_nums, 0
                ) + 1
            else:
                old_count_odd = count_odd
                prefix_odd_count_dict[count_odd % keep_nums] = 1
            print(prefix_odd_count_dict)
        print(f"result: {count}")
        return count


assert Solution().numberOfSubarrays(nums=[1, 1, 2, 1, 1], k=3) == 2
assert Solution().numberOfSubarrays(nums=[2, 4, 6], k=1) == 0
assert Solution().numberOfSubarrays(nums=[2, 2, 2, 1, 2, 2, 1, 2, 2, 2], k=2) == 16
