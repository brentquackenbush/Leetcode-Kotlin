## Performance Comparison: `ArrayDeque<TreeNode>()` vs `LinkedList<TreeNode>()` in Kotlin

### Implementation:

- **ArrayDeque**:
    - Backed by a resizable array.
    - Can dynamically adjust its size.
    - Has efficient index-based operations.
    - Generally more memory-efficient than `LinkedList`.

- **LinkedList**:
    - A doubly-linked list.
    - Each element contains two references (to the next and previous elements).
    - Less memory-efficient due to the overhead of these references.

### Performance:

- **Add Operation**:
    - Both `ArrayDeque` and `LinkedList` offer constant time complexity `O(1)` for adding elements.
    - `ArrayDeque` may perform better due to better cache locality and fewer memory allocations.

- **Remove Operation**:
    - `ArrayDeque` uses `removeFirst()`, which is `O(1)`.
    - `LinkedList` uses `poll()`, also `O(1)`.
    - The difference is negligible in terms of time complexity, but `ArrayDeque` can be faster due to lower overhead.

### Memory Usage:

- `ArrayDeque` is typically more memory-efficient due to its contiguous memory allocation.
- Better for cache performance compared to the non-contiguous nodes of `LinkedList`.

### Resizing:

- When an `ArrayDeque` needs to grow, it requires reallocating an array and copying elements.
- This operation is more expensive but doesn't happen frequently enough to be a major concern for most use cases.

### Summary:

- While both `ArrayDeque` and `LinkedList` can be used for queue operations with similar time complexities, `ArrayDeque` often offers better performance.
- Due to efficient memory usage and better cache performance, `ArrayDeque` is a preferable choice for BFS implementations, especially in performance-sensitive applications.
