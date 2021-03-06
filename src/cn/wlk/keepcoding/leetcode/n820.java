package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 2020/3/29 16:11
 * author:WLK
 *
 * 820. 单词的压缩编码
 *
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 *
 *
 * 提示：
 *
 *     1 <= words.length <= 2000
 *     1 <= words[i].length <= 7
 *     每个单词都是小写字母 。
 *
 *
 * 解法：只用对每个word都加入到集合中，然后删去每个word的所有后缀就行了
 *
 */

public class n820 {

    @Test
    public void test() {
        n820 t = new n820();
        System.out.println(t.minimumLengthEncoding(new String[]{"time","me","bell"}));
    }

    public int minimumLengthEncoding(String[] words) {
        HashSet<String> sset = new HashSet<>();
        for(int i  = 0;i<words.length;i++){
            sset.add(words[i]);
        }
        for(int i = 0;i<words.length;i++){
            for(int j = 1;j<words[i].length()-1;j++){
                sset.remove(words[i].substring(j));
            }
        }
        int result = 0;
        Iterator<String> it = sset.iterator();
        while(it.hasNext()){
            result+=it.next().length()+1;
        }
        return result;
    }

}
