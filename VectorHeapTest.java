import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
class VectorHeapTest {
    @Test
    void testAddAndRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());

        heap.add(5);
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
        assertEquals(Integer.valueOf(5), heap.remove());

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    void testOrdering() {
        VectorHeap<Integer> heap = new VectorHeap<>();

        heap.add(10);
        heap.add(5);
        heap.add(20);
        heap.add(3);

        assertEquals(Integer.valueOf(3), heap.remove());
        assertEquals(Integer.valueOf(5), heap.remove());
        assertEquals(Integer.valueOf(10), heap.remove());
        assertEquals(Integer.valueOf(20), heap.remove());
    }
}
