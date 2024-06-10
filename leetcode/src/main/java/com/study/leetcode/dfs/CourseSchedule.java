package com.study.leetcode.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 207. Course Schedule
 * Medium
 * https://leetcode.com/problems/course-schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0,
 * and to take course 0 you should also have finished course 1.
 * So it is impossible.
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> condition = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> orDefault = condition.getOrDefault(prerequisite[0], new HashSet<>());
            orDefault.add(prerequisite[1]);
            condition.put(prerequisite[0], orDefault);
        }

        int[] history = new int[numCourses + 1];
        for (Integer target : condition.keySet()) {
            boolean check = recursion(condition, history, target);
            if(!check) {
                return false;
            }
        }

        return true;
    }

    public boolean recursion(Map<Integer, Set<Integer>> condition, int[] history, Integer target) {
        if (history[target] == 3) {
            return true;
        } else if (history[target] == 1) {
            return false;
        }

        Set<Integer> condList = condition.getOrDefault(target, new HashSet<>());
        history[target] = 1;
        for (int cond : condList) {
            if (!recursion(condition, history, cond)){
                return false;
            }
        }

        history[target] = 3;
        return true;
    }
}