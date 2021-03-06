package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/2 15:07
 * author:WLK
 *
 * 面试题10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 *
 * 提示：
 *
 *     0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 *
 * 解法：简单题
 */

public class TP0102 {

    @Test
    public void test() {
        TP0102 t = new TP0102();
    }

    public int numWays(int n) {
        if(n<2){
            return 1;
        }

        int[] dp = new int[n+1];

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i = 3;i<=n;i++){
            dp[i]=dp[i-2]%1000000007+dp[i-1]%1000000007;
        }

        return dp[n];
    }


}
