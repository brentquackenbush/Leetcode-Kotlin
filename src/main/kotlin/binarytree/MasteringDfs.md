# Mastering Depth-First Search (DFS) in Tree Problems

Mastering Depth-First Search (DFS) in tree problems involves understanding several key concepts and how they apply to different problems. Let's break down these concepts using the "Count Nodes Equal to Average of Subtree" problem as an example:

## 1. Start Small: Handling Base Cases

In DFS, it's crucial to define the base case clearly. For tree problems, the base case often involves handling a null node or a leaf node.

**Example**: In our solution, the base case is `if (node == null) return Pair(0, 0)`. This means that if we reach a null node (which signifies the absence of a subtree), we return a pair of zeros, indicating no sum and no nodes to count.

## 2. Divide and Conquer: Breaking Down into Subproblems

DFS on trees inherently uses a divide-and-conquer approach, where a problem is broken down into smaller subproblems. Each node in a tree represents a subproblem consisting of its left and right subtrees.

**Example**: In the problem, for each node, we independently solve the subproblems for its left and right subtrees:
- `val (leftSum, leftCount) = dfs(node.left)`
- `val (rightSum, rightCount) = dfs(node.right)`

These calls compute the sum and count of nodes in the left and right subtrees, respectively.

## 3. Recursive Mindset: Each Node's Contribution

With recursion, you need to think about what each node does and how it contributes to the overall solution. Each node processes its own value and the results from its subtrees.

**Example**: After the DFS calls, we calculate:
- `val totalSum = node.val + leftSum + rightSum`
- `val totalCount = 1 + leftCount + rightCount`

Here, each node adds its own value to the sum of its subtrees and counts itself in addition to the nodes in its subtrees.

## 4. Backtracking: Exploring All Paths

Backtracking is an integral part of DFS where after exploring one path (e.g., left subtree), you backtrack and explore the other paths (e.g., right subtree).

**Example**: Once we calculate the sum and count for the left subtree, we backtrack and then do the same for the right subtree. This ensures that all parts of the tree are explored.

## Applying These Concepts to Solve the Problem

- **Understand the Problem**: Know what you need to find - in this case, the nodes where the value equals the average of its subtree.
- **Identify the Base Case**: Here, it's a null node.
- **Recursive Function**:
    - What does it do at each node? Calculate the sum and count of nodes in its subtree.
    - How does it integrate the results from left and right subtrees? It adds them together with the current node’s value.
- **Global or Local Variables**: Decide if you need a global variable (like `count` in our case) or local variables to store intermediate results.
- **Backtracking and Returning Results**: Once a node is processed, the function returns the computed values (sum and count here) to its parent.
- **Post-DFS Computation**: Sometimes, additional computation or checks are needed after the DFS call, as we did with the average and count increment.

## Practice and Visualization

- **Draw Trees and Trace the Algorithm**: Visualizing how DFS traverses a tree and processes nodes can be really helpful.
- **Practice with Variations**: Try solving different tree problems with DFS to understand how these principles apply in various scenarios.