## For loops in Kotlin
### Standard For Loop:

```kotlin
for (i in 0 until n) { 
    // code 
}
```
This loop will run from 0 to n-1. The until keyword is exclusive of the end value.

### Inclusive Range For Loop:
```kotlin
for (i in 0..n) { 
    // code 
}
```
This loop will run from 0 to n inclusive. The .. operator creates an inclusive range.

### Exclusive Range For Loop using until:
```kotlin
for (i in 0 until n) { 
    // code 
}
```
This loop will run from 0 to n-1.

### Step For Loop:
```kotlin
for (i in 0 until n step 2) { 
    // code 
}
```
This loop will run from 0 to n-1 with a step of 2.

### Downward For Loop:
```kotlin
for (i in n downTo 0) { 
    // code 
}
```
This loop will run from n down to 0 inclusive.

### ForEach Loop:
``` kotlin
for (item in collection) {
    // code
}
// or equivalently using forEach function
collection.forEach { item ->
    // code
}
```
This loop will iterate over each item in the collection.

### Indexed For Loop:
```kotlin
for ((index, value) in collection.withIndex()) {
    // code
}
```
This loop will iterate over the collection, providing both the index and the value of each element.

### Char Sequence or Range Iteration:
``` kotlin
for (char in 'a'..'z') { 
    // code 
}
```
This loop will iterate over a char sequence or range.

#### Memory Tips:
1. until is exclusive of the end value.
2. .. creates an inclusive range.
3. downTo is for downward iterations and is inclusive.
4. step is for specifying a step value.
5. forEach and the standard for loop are for iterating over collections.