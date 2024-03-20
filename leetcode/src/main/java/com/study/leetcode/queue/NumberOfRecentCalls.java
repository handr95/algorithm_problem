package com.study.leetcode.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 933. Number of Recent Calls
 * Easy
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * 특정 시간 프레임 내의 최근 요청 수를 계산하는 RecentCounter 클래스가 있습니다.
 *
 * RecentCounter 클래스를 구현합니다:
 *
 * RecentCounter() 최근 요청이 0인 카운터를 초기화합니다.
 * int ping(int t) 시간 t에 새 요청을 추가하고, 여기서 t는 밀리초 단위의 시간을 나타내며,
 * 지난 3000밀리초 동안 발생한 요청 수(새 요청 포함)를 반환합니다. 구체적으로는 [t - 3000, t]를 포함하는 범위에서 발생한 요청 수를 반환합니다.
 * 핑에 대한 모든 호출은 이전 호출보다 엄격하게 더 큰 값의 t를 사용하도록 보장됩니다.
 *
 *
 * Example 1:
 * Input
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * Output
 * [null, 1, 2, 3, 3]
 *
 * Explanation
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
 * recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 *
 *
 * Constraints:
 *
 * 1 <= t <= 109
 * Each test case will call ping with strictly increasing values of t.
 * At most 104 calls will be made to ping.
 */
public class NumberOfRecentCalls {
    static class RecentCounter {
        List<Integer> pings = new ArrayList<>();
        int count;
        public RecentCounter() {
            count =  0;
        }

        public int ping(int t) {
            count =  0;
            pings.add(t);

            for (int ping : pings) {
                if (t - 3000 > ping) {
                    continue;
                }
                count++;
            }

            return count;
        }
    }

    class RecentCounter2 {
        private static final int[] queue = new int[10000];
        private int start;
        private int end;

        public RecentCounter2() {
            start = 0;
            end = 0;
        }

        public int ping(int t) {
            while (start < end && (t - queue[start] > 3000)) {
                start++;
            }
            queue[end++] = t;
            return end - start;
        }
    }


/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
}
