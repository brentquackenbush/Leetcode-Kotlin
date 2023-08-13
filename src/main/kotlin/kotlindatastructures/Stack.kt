package kotlindatastructures
interface Stack<T: Any> {

    fun peek() : T?

    fun pop() : T?

    fun push(element: T)

    val count : Int

    val isEmpty: Boolean
        get() = count == 0
}

/**
 * @interface This keyword is used to declare an interface in Kotlin.
 * An interface is a contract that specifies the behavior that classes implementing the interface must provide.
 *
 * @Stack This is the name of the interface.
 *
 * @<T: Any>: This is a declaration of a generic type parameter T. The T can be any non-null type, as indicated by the
 * constraint : Any. This allows the stack to handle elements of any specific type, such as Int, String, etc.,
 * without having to write separate implementations for each type.
 */
/**
 * @JAVA
 * public interface Stack<T> {
 *     T peek();
 *     T pop();
 *     void push(T element);
 *     int getCount();
 *     boolean isEmpty();
 * }
 */
