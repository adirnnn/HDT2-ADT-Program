import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayStackTest {

    private ArrayStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new ArrayStack<>();
    }

    @Test
    public void testPushAndPop() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertFalse(stack.isEmpty());
        assertEquals(3, stack.size());

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPeek() {
        assertTrue(stack.isEmpty());

        stack.push(42);

        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());

        assertEquals(Integer.valueOf(42), stack.peek());
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopOnEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.pop();
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekOnEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.peek();
    }

    @Test
    public void testResizeArray() {
        assertEquals(10, stack.getArrayCapacity());

        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }

        assertEquals(20, stack.getArrayCapacity());
    }
}
