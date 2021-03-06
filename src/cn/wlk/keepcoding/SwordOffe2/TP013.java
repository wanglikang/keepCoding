package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/3/2 17:42
 * author:WLK
 *
 * 面试题13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 *
 *     1 <= n,m <= 100
 *     0 <= k <= 20
 *
 * 解法：BFS
 *
 */


public class TP013 {

    @Test
    public void test() {
        TP013 t = new TP013();
        System.out.println(t.movingCount(3,2,17));
    }

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        int count = 0;
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(0);
        queue.add(0);
        visited[0][0]=1;
        int x,y;
        while (!queue.isEmpty()){
            x = queue.poll();
            y = queue.poll();

//            System.out.println(x+";"+y);
            count++;

//这两个方向可以优化掉
//            if(x>0 && visited[x-1][y]!=1 && check(x-1,y,k)){
//                queue.add(x-1);
//                queue.add(y);
//                visited[x-1][y]=1;
//            }
            if(x<m-1&& visited[x+1][y]!=1 && check(x+1,y,k)){
                queue.add(x+1);
                queue.add(y);
                visited[x+1][y]=1;
            }
//            if(y>0 && visited[x][y-1]!=1 && check(x,y-1,k)){
//                queue.add(x);
//                queue.add(y-1);
//                visited[x][y-1]=1;
//            }
            if(y<n-1 && visited[x][y+1]!=1 && check(x,y+1,k)){
                queue.add(x);
                queue.add(y+1);
                visited[x][y+1]=1;
            }
        }

        return count;
    }

    public boolean check(int x,int y,int k){
        int sum = 0;
        while (x>0){
            sum+=x%10;
            x = x/10;
        }
        while (y>0){
            sum+=y%10;
            y = y/10;
        }
        if(sum<=k){
            return true;
        }else{
            return false;
        }

    }


}
