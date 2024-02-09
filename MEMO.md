# 헷갈리는 것들 정리

## 재귀함수

### 재귀 함수를 만들기 위한 단계

문제를 해결하기 위해 재귀 함수를 만들려면 몇 가지 단계를 따라야 합니다. 아래는 일반적으로 따르는 절차입니다:

1. 문제 이해: 먼저 문제를 이해해야 합니다. 문제가 무엇을 요구하는지, 어떤 입력이 주어지고 어떤 결과를 반환해야 하는지 이해해야 합니다.

2. Base Case 식별: 재귀 함수에서는 반드시 종료 조건을 정의해야 합니다. 이를 Base Case라고 합니다. Base Case는 재귀 호출을 멈추게 하는 조건입니다.

3. 작은 문제로 분할: 주어진 문제를 작은 부분 문제로 분할해야 합니다. 이는 재귀 함수를 통해 작은 문제들을 해결하는 데 사용됩니다.

4. 재귀 호출 정의: 작은 문제를 해결하기 위해 동일한 함수를 호출해야 합니다. 재귀 호출은 문제를 점진적으로 해결하는 데 사용됩니다.

5. 함수 구현: 위의 단계들을 바탕으로 재귀 함수를 구현합니다. 이때 재귀 호출을 위한 Base Case와 적절한 호출이 있는지 확인해야 합니다.

6. 테스트: 구현한 재귀 함수를 테스트하여 예상대로 동작하는지 확인해야 합니다. 특히 Base Case와 재귀 호출이 올바르게 작동하는지 확인하는 것이 중요합니다.

이러한 단계를 따라가면서 문제를 해결하는 데 필요한 재귀 함수를 만들 수 있습니다. 문제를 이해하고 Base Case를 식별하는 것이 특히 중요합니다. 이후 작은 문제로 분할하고 재귀 호출을 정의하여 해결해 나가는 것이 재귀 함수를 만드는 핵심 단계입니다.


### 재귀 함수의 예시 - 1

문제: 양의 정수 n에 대해 n의 팩토리얼을 계산하는 함수를 재귀적으로 구현하십시오.

1. 문제 이해: 우리는 주어진 양의 정수 n에 대해 n의 팩토리얼을 계산해야 합니다. 예를 들어, 5의 팩토리얼은 5 * 4 * 3 * 2 * 1 = 120입니다.

2. Base Case 식별: 팩토리얼의 Base Case는 n이 0 또는 1일 때입니다. 0 또는 1의 팩토리얼은 1입니다.

3. 작은 문제로 분할: n의 팩토리얼을 계산하는 문제는 n을 (n-1)의 팩토리얼과 곱하는 문제로 나눌 수 있습니다.

4. 재귀 호출 정의: 재귀적으로 n의 팩토리얼을 계산하려면 (n-1)의 팩토리얼을 먼저 계산해야 합니다. 그러므로 자신의 함수를 다시 호출하면서 n-1의 팩토리얼을 계산하고 그 결과에 n을 곱합니다.

5. 함수 구현: 위의 단계들을 바탕으로 재귀 함수를 구현합니다.

6. 테스트: 구현한 재귀 함수를 테스트하여 예상대로 동작하는지 확인합니다.

```java
public class Factorial {
    // 재귀 함수를 사용한 팩토리얼 계산
    public static int factorial(int n) {
        // Base Case: n이 0 또는 1인 경우 1 반환
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // 작은 문제로 분할하고 재귀 호출하여 해결
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int number = 5; // 계산할 숫자
        int result = factorial(number);
        System.out.println("Factorial of " + number + " is: " + result);
    }
}
```

### 재귀 함수의 예시 - 2

이진 트리에서 특정 값을 가진 노드의 개수를 찾는 문제를 사용해보겠습니다. 이 문제에서는 Base Case가 노드가 없는 경우와 노드가 있는 경우 두 가지로 나뉘고, 작은 문제는 각 서브트리에서 특정 값을 가진 노드의 개수를 찾는 것입니다.

문제: 주어진 이진 트리에서 특정 값 x를 가진 노드의 개수를 찾는 재귀 함수를 구현하십시오.

1. 문제 이해: 우리는 주어진 이진 트리에서 특정 값 x를 가진 노드의 개수를 찾아야 합니다.

2. Base Case 식별: 이 경우에는 노드가 없는 경우와 노드가 있는 경우 두 가지 Base Case가 있습니다. 즉, 노드가 null인 경우와 노드의 값이 x와 같은 경우입니다.

3. 작은 문제로 분할: 각 노드에서 특정 값을 가진 노드의 개수를 찾기 위해 왼쪽 서브트리와 오른쪽 서브트리로 문제를 분할합니다.

4. 재귀 호출 정의: 재귀적으로 특정 값을 가진 노드의 개수를 계산하려면 왼쪽 서브트리와 오른쪽 서브트리에서 특정 값을 가진 노드의 개수를 계산해야 합니다. 그러므로 자신의 함수를 왼쪽 서브트리와 오른쪽 서브트리에 대해 호출하고 결과를 합칩니다.

5. 함수 구현: 위의 단계들을 바탕으로 재귀 함수를 구현합니다.

6. 테스트: 구현한 재귀 함수를 테스트하여 예상대로 동작하는지 확인합니다.

아래는 위의 단계들을 반영하여 구현한 이진 트리에서 특정 값을 가진 노드의 개수를 찾는 재귀 함수의 예시입니다.

```java
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class CountNodesWithValueX {
    // 재귀 함수를 사용한 특정 값 x를 가진 노드의 개수 계산
    public static int countNodesWithValueX(TreeNode root, int x) {
        // Base Case: 노드가 null인 경우 0 반환
        if (root == null) {
            return 0;
        }
        // 현재 노드의 값이 x와 같은 경우 1을 반환하고, 아닌 경우는 0을 반환
        int count = (root.val == x) ? 1 : 0;
        // 왼쪽 서브트리와 오른쪽 서브트리에서 특정 값을 가진 노드의 개수를 계산하고 합침
        count += countNodesWithValueX(root.left, x);
        count += countNodesWithValueX(root.right, x);
        return count;
    }

    public static void main(String[] args) {
        // 이진 트리 생성
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 특정 값 x를 가진 노드의 개수 계산
        int x = 3;
        int result = countNodesWithValueX(root, x);
        System.out.println("Number of nodes with value " + x + " is: " + result);
    }
}
```
