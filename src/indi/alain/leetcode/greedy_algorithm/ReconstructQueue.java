package indi.alain.leetcode.greedy_algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 体育排队
 * @author d
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] oneP : people) {
            //按照人前面有几个高于自己人来插入队列
            queue.add(oneP[1], oneP);
        }
        return queue.toArray(new int[people.length][]);
    }
}
