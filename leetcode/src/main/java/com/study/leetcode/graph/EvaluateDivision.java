package com.study.leetcode.graph;

import java.util.*;

/**
 * 399. Evaluate Division
 * Medium
 * https://leetcode.com/problems/evaluate-division
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 *
 * Example 2:
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *  1 <= equations.length <= 20
 *  equations[i].length == 2
 *  1 <= Ai.length, Bi.length <= 5
 *  values.length == equations.length
 *  0.0 < values[i] <= 20.0
 *  1 <= queries.length <= 20
 *  queries[i].length == 2
 *  1 <= Cj.length, Dj.length <= 5
 *  Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
class EvaluateDivision {
    Map<String, Map<String, Double>> combineList = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int valueIdx = 0;
        for (List<String> equation : equations) {
            String first = equation.get(0);
            String second = equation.get(1);

            combineList.putIfAbsent(first, new HashMap<>());
            combineList.putIfAbsent(second, new HashMap<>());

            combineList.get(first).put(second, values[valueIdx]);
            combineList.get(second).put(first, 1.0/values[valueIdx]);
            valueIdx++;
        }

        double[] result = new double[queries.size()];
        for (int resultIdx = 0; resultIdx < queries.size(); resultIdx++) {
            String first = queries.get(resultIdx).get(0);
            String second = queries.get(resultIdx).get(1);

            if (!combineList.containsKey(first) || !combineList.containsKey(second)) {
                result[resultIdx] = -1.0;
                continue;
            }

            Double recursion = recursion(second, first, 1.0, new HashSet<>());
            result[resultIdx] = recursion == null ? -1.0 : recursion;
        }
        return result;
    }

    public Double recursion(String need, String target, double val, Set<String> visit) {
        visit.add(target);

        if (need.equals(target)) {
            return val;
        }

        Map<String, Double> neighbors = combineList.get(target);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String combineAlpha = entry.getKey();
            Double combineNum = entry.getValue();
            if (visit.contains(combineAlpha)) {
                continue;
            }
            Double recursion = recursion(need, combineAlpha, val * combineNum, visit);
            if (recursion != null) {
                return recursion;
            }
        }

        visit.remove(target);
        return null;
    }
}