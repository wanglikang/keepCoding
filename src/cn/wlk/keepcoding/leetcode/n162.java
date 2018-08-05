package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 162. 寻找峰值
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
//done

/**
 * 解法：参考https://blog.csdn.net/cinderella_niu/article/details/43056759
 *      使用二分查找的思想，只用找到一个峰值即可，
 */
public class n162 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid ;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else if(nums[mid]<nums[mid+1]){
                l=mid+1;
            }
        }
        return l;//返回的是下标
    }
    @Test
    public void test() {
        n162 t = new n162();
        System.out.println();
    }

}
