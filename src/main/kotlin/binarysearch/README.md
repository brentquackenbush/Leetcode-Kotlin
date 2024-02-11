# When to Use Binary Search
You can consider binary search in situations where:

You can halve the search space based on a condition. Even without traditional sorting, if you can determine which half of your search space contains the answer, binary search might be applicable.

There's a clear way to move left or right. If comparing elements at specific indices gives you a clear direction to move in search of your target, binary search can be effective.

## Binary Search Template
A generic binary search template looks like this:

```kotlin
    var left = 0
    var right = array.size - 1

    while (left <= right) { // Use < for finding an element, <= for finding a position
        val mid = left + (right - left) / 2
        
        when {
            // Check condition to decide direction
            array[mid] == target -> return mid // Or any condition for moving left or right
            array[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
```

- **Decide on left and right**: They typically start as the boundaries of your search space (e.g., 0 and array.size - 1).

- **Adjusting the Loop and Condition**: The condition inside the loop (left < right vs. left <= right) and how you adjust left and right depends on what you're searching for: an element's value, its position, or a condition like a peak.

---
Understanding when and how to apply binary search beyond sorted arrays can significantly enhance your problem-solving toolkit, especially for questions that involve searching or optimization.