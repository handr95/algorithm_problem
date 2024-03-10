package com.study.leetcode.array;

/**
 * 605. Can Place Flowers
 * Easy
 * https://leetcode.com/problems/can-place-flowers/description/?envType=study-plan-v2&envId=leetcode-75
 * <p>
 * 일부 플롯에는 꽃이 심어져 있고 일부는 심어져 있지 않은 긴 화단이 있습니다. 그러나 인접한 플롯에는 꽃을 심을 수 없습니다.
 * <p>
 * 0과 1이 포함된 정수 배열 화단(0은 비어 있고 1은 비어 있지 않음을 의미)과 정수 n이 주어질 때, 인접 꽃 금지 규칙을 위반하지 않고 화단에 새로운 꽃을 심을 수 있으면 참을 반환하고, 그렇지 않으면 거짓을 반환합니다.
 * <p>
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flower = 0;

        for (int i = 0; i < flowerbed.length; i ++) {
            if (flower >= n) {
                return true;
            }
            if (flowerbed[i] == 1) {
                continue;
            }
            if (canPlant(i, flowerbed)) {
                flowerbed[i] = 1;
                flower++;
            }
        }
        return flower >= n;
    }

    boolean canPlant(int i, int[] flowerbed) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return true;
            }
        }

        if (i == 0) {
            if (flowerbed[i + 1] == 0) {
                return true;
            }
        } else if (i == flowerbed.length - 1) {
            if (flowerbed[i - 1] == 0) {
                return true;
            }
        } else return flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0;

        return false;
    }

    public boolean solution(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (n <= 0)
                return true;
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                    i++;
                } else {
                    i += 2;
                }
            } else {
                i++;
            }
        }
        return n <= 0;
    }
}
