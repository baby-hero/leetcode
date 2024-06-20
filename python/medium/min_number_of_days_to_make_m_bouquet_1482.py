#
# https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
#

from typing import List


class Solution:
    def countBouquets(self, input_list, m, k):
        count = 0
        pre_index = -1
        for i in input_list:
            size = i - pre_index - 1
            count += size // k
            if count >= m:
                return count
            pre_index = i
        return count

    def create_remove_index_list(self, n, numb_index_dict, select_keys, left, right):
        mid = (left + right) // 2
        remove_index_list = []
        for i in range(mid, len(select_keys)):
            remove_index_list.extend(numb_index_dict[select_keys[i]])

        remove_index_list.append(n)
        remove_index_list.sort()
        return mid, remove_index_list

    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        n = len(bloomDay)
        num_remove_flowers = n - m * k
        if num_remove_flowers < 0:
            print("min_days = -1")
            return -1

        if num_remove_flowers == 0:
            return max(bloomDay)

        numb_index_dict = dict()
        for i, value in enumerate(bloomDay):
            if value not in numb_index_dict:
                numb_index_dict[value] = []
            numb_index_dict[value].append(i)

        count = 0
        select_keys = []
        min_days = 0
        for key in sorted(numb_index_dict.keys()):
            if count < m * k:
                count += len(numb_index_dict[key])
                min_days = key
            else:
                select_keys.append(key)

        # binary search
        left = 0
        right = len(select_keys)
        while True:
            mid, remove_index_list = self.create_remove_index_list(n, numb_index_dict, select_keys, left, right)

            tmp = self.countBouquets(remove_index_list, m, k)
            if tmp >= m:
                right = mid - 1
            else:
                left = mid + 1
                min_days = select_keys[mid]
            if left > right:
                break
            print("========")
            print(select_keys)
            print(remove_index_list)
            print("========")

        print(f"min_days = {min_days}")
        return min_days


assert Solution().minDays(bloomDay=[1, 10, 3, 10, 2], m=3, k=1) == 3
assert Solution().minDays(bloomDay=[1, 10, 3, 10, 2], m=3, k=2) == -1
assert Solution().minDays(bloomDay=[7, 7, 7, 7, 12, 7, 7], m=2, k=3) == 12
assert Solution().minDays(bloomDay=[1000000000, 1000000000], m=1, k=1) == 1000000000
assert Solution().minDays(bloomDay=[1, 10, 2, 9, 3, 8, 4, 7, 5, 6], m=4, k=2) == 9
