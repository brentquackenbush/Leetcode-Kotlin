package kotlindatastructures

class StackImpl<T: Any>: Stack<T> {

    private var storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }
}
/**
 * @JAVA
 * public class StackImpl<T> implements Stack<T> {
 *     private ArrayList<T> storage = new ArrayList<>();
 *
 *     @Override
 *     public T peek() {
 *         return storage.isEmpty() ? null : storage.get(storage.size() - 1);
 *     }
 *
 *     @Override
 *     public T pop() {
 *         return storage.isEmpty() ? null : storage.remove(storage.size() - 1);
 *     }
 *
 *     @Override
 *     public void push(T element) {
 *         storage.add(element);
 *     }
 *
 *     @Override
 *     public int getCount() {
 *         return storage.size();
 *     }
 *
 *     @Override
 *     public boolean isEmpty() {
 *         return storage.isEmpty();
 *     }
 * }
 */
