package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/7/4 9:52
 * author:WLK
 *
 * 674. 最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 * 注意：数组长度不会超过10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：简单题
 *
 */
public class n674 {
    @Test
    public void test() {
        n674 t = new n674();
//        int[] nums = {1,3,5,4,7};
        int[] nums = {2,2,2,2,2,2};
        int re = t.findLengthOfLCIS(nums);
        System.out.println(re);
    }

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        int[] looong = new int[len];
        looong[0] = 1;
        int max = 1;
        for(int i = 1;i<len;i++){
            if(nums[i]>nums[i-1]){
                looong[i]=looong[i-1]+1;
            }else looong[i]=1;
            max = Math.max(max,looong[i]);
        }

        return max;
    }


}