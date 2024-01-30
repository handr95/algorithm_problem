package com.study.leetcode.array;

/**
 * 9. Palindrome Number
 * Easy
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] intArray = String.valueOf(x).toCharArray();
        if (intArray[0] == '-') {
            return false;
        }
        int middleIdx =  intArray.length/2 + intArray.length%2;
        for (int i = 0; i < middleIdx; i ++) {
            if (intArray[intArray.length - i - 1] != intArray[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode.com/problems/palindrome-number/solutions/3651712/2-method-s-c-java-python-beginner-friendly/
     *
     * 이 코드의 직관은 전체 입력 숫자를 반전하고 반전된 숫자가 원래 숫자와 같은지 확인하는 것입니다. 두 숫자가 같으면 해당 숫자는 팔린드롬입니다.
     *
     * 접근 방식 1: 전체 숫자 반전하기
     * 설명:
     * 1. 먼저 초기 검사를 수행합니다. 팔린드롬은 일반적으로 양수에 대해 정의되므로 입력된 숫자 x가 음수인 경우 팔린드롬이 될 수 없습니다. 이러한 경우 즉시 false를 반환합니다.
     *
     * 2. 두 개의 변수를 초기화합니다:
     *  - reversed: 이 변수는 숫자 x의 반전된 값을 저장합니다.
     *  - temp: 이 변수는 원래 값을 수정하지 않고 입력 숫자를 조작하기 위한 임시 자리 표시자입니다.
     *  - temp가 0이 될 때까지 계속되는 루프에 들어갑니다:
     *
     * 3. 루프 내부에서 모듈로 연산자 %를 사용하여 temp의 마지막 숫자를 추출하여 숫자 변수에 저장합니다.
     *  - 숫자를 반전시키려면 반전된 현재 값에 10을 곱하고 추출한 숫자를 더합니다.
     *  - 그런 다음 temp를 10으로 나누어 마지막 숫자를 제거하고 다음 반복으로 넘어갑니다.
     * 4. 루프가 완료되면 전체 숫자가 반전됩니다. 이제 반전된 값을 원래 입력 값인 x와 비교합니다.
     *  - 둘이 같으면 숫자가 팔린드롬이라는 뜻이므로 참을 반환합니다.
     *  - 같지 않으면 숫자가 팔린드롬이 아니므로 거짓을 반환합니다.
     *
     * 이 코드는 입력 숫자가 클 경우 발생할 수 있는 오버플로를 처리하기 위해 반전된 변수에 긴 데이터 유형을 사용합니다.
     * @param x
     * @return
     */
    public boolean isPalindrome_solution1(int x) {
        if (x < 0) {
            return false;
        }

        long reversed = 0;
        long temp = x;

        while (temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        return (reversed == x);
    }

    /**
     * 접근법 2: 숫자의 절반 반전하기
     *
     * 전체 숫자를 반전시키는 대신 숫자의 마지막 절반만 반전시킬 수 있습니다. 이 방법은 숫자의 마지막 절반을 반전시킬 때 중간 숫자가 원래 값으로 되돌아가지 않도록 해야 하기 때문에 까다롭습니다. 숫자의 자릿수가 홀수인 경우 이런 문제가 발생할 수 있습니다. 이 문제를 해결하려면 숫자의 전반부와 반전된 후반부를 비교하면 됩니다.
     *
     * 설명:
     * 1. 특수한 경우를 처리하기 위해 초기 검사부터 시작합니다:
     *  - 팔린드롬은 일반적으로 양수에 대해 정의되므로 입력 숫자 x가 음수인 경우 팔린드롬이 될 수 없습니다. 이러한 경우 즉시 false를 반환합니다.
     *  - x가 0이 아니고 0으로 끝나는 경우, 팔린드롬에서는 선행 0이 허용되지 않으므로 팔린드롬이 될 수 없습니다. 이러한 경우 거짓을 반환합니다.
     * 2. 두 개의 변수를 초기화합니다:
     *  - reversed: 이 변수는 숫자 자릿수의 반전된 후반부를 저장합니다.
     *  - temp: 이 변수는 원래 값을 수정하지 않고 입력 숫자를 조작하기 위한 임시 자리 표시자입니다.
     * 3. 자릿수의 전반부(x)가 반전된 후반부(반전)보다 작거나 같을 때까지 계속되는 루프에 들어갑니다:
     *  - 루프 내에서 모듈로 연산자 %를 사용하여 x의 마지막 자릿수를 추출한 다음 10을 곱한 후 반전된 변수에 더합니다(기존 자릿수를 왼쪽으로 이동).
     *  - 그런 다음 x를 10으로 나누어 마지막 숫자를 제거하고 숫자의 중앙으로 이동합니다.
     * 4. 루프가 완료되면 자릿수의 후반부를 반전시킨 것입니다. 이제 숫자의 전반부(x)와 반전된 후반부(반전)를 비교하여 해당 숫자가 팔린드롬인지 확인합니다:
     *  - 자릿수가 짝수인 경우 x가 반전된 것과 같으면 해당 숫자는 팔린드롬입니다. 참을 반환합니다.
     *  - 자릿수가 홀수인 경우 x가 반전 / 10(중간 숫자 무시)과 같으면 해당 숫자는 팔린드롬입니다. 참을 반환합니다.
     *  - 위의 조건 중 어느 것도 충족되지 않으면 해당 숫자가 팔린드롬이 아니므로 거짓을 반환합니다.
     *  
     * 이 코드는 필요한 부분만 비교하여 전체 숫자를 반전시킬 필요를 피합니다. 이 접근 방식은 시간 복잡성과 메모리 사용량을 모두 줄여주므로 보다 효율적인 솔루션이 됩니다.
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return (x == reversed) || (x == reversed / 10);
    }
}