package com.bite.day;

/**
 * @Author tjy
 * @Date 2020/8/8 10:03
 */

public class bite8_8 {

    /**
     * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
     *
     * 火车票有三种不同的销售方式：
     *
     * 一张为期一天的通行证售价为 costs[0] 美元；
     * 一张为期七天的通行证售价为 costs[1] 美元；
     * 一张为期三十天的通行证售价为 costs[2] 美元。
     * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
     *
     * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
     */

    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        dp[days[0]] = Math.min(costs[0],Math.min(costs[1],costs[2]));
        int x = 1;
        for (int i = days[0]+1; i < dp.length; i++) {
            if (i == days[x]){
                x++;
                if (i >= 30){
                    dp[i] = Math.min(dp[i - 7]+ costs[1],Math.min(dp[i -1] +costs[0],dp[i - 30]+ costs[2]));
                }
                else if (i >= 7){
                    dp[i] = Math.min(costs[2],Math.min(dp[i -1] +costs[0],dp[i - 7]+ costs[1]));
                }
                else
                    dp[i] = Math.min(costs[2],Math.min(dp[i -1] +costs[0],costs[1]));
            }else
                dp[i] = dp[i - 1];
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,5,6,9,10,12,14,15,18,20,21,22,23,24,25,26,28};
        int[] costs = {3,13,57};
        System.out.println(mincostTickets(a, costs));
    }

    static int[] days, costs;
    static Integer[] memo;
    static int[] durations = new int[]{1, 7, 30};

    public static int mincostTickets1(int[] days, int[] costs) {
        bite8_8.days = days;
        bite8_8.costs = costs;
        memo = new Integer[days.length];
        return dp(0);
    }

    public static int dp(int i) {
        if (i >= days.length) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k]) {
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }

    public int mincostTickets3(int[] days, int[] costs) {
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }

}
