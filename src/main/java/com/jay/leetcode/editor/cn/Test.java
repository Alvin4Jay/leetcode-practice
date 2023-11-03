package com.jay.leetcode.editor.cn;

/**
 * desc.
 *
 * @author zhongshuo.xwj
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(getMinIndex(new int[]{1,2,3}));
    }

    public static int getMinIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int l = 0, r = len - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                return 0;
            }
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return 0;
    }

}
