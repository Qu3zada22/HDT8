import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data;

    public VectorHeap() {
        data = new Vector<>();
    }

    // Método para obtener el índice del padre de un nodo en el heap
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Método para obtener el índice del hijo izquierdo de un nodo en el heap
    private int left(int i) {
        return 2 * i + 1;
    }

    // Método para obtener el índice del hijo derecho de un nodo en el heap
    private int right(int i) {
        return 2 * i + 2;
    }

    // Método para intercambiar dos elementos en el heap
    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    // Método para insertar un elemento en el heap
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    // Método auxiliar para ajustar el heap después de insertar un elemento
    private void percolateUp(int i) {
        while (i > 0 && data.get(i).compareTo(data.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Método para eliminar y devolver el elemento con mayor prioridad del heap
    @Override
    public E remove() {
        if (data.isEmpty())
            return null;

        E min = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        percolateDown(0);
        return min;
    }

    // Método auxiliar para ajustar el heap después de eliminar un elemento
    private void percolateDown(int i) {
        int min = i;
        int left = left(i);
        int right = right(i);

        if (left < data.size() && data.get(left).compareTo(data.get(min)) < 0)
            min = left;
        if (right < data.size() && data.get(right).compareTo(data.get(min)) < 0)
            min = right;

        if (min != i) {
            swap(i, min);
            percolateDown(min);
        }
    }

    // Método para verificar si el heap está vacío
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Método para obtener el tamaño del heap
    @Override
    public int size() {
        return data.size();
    }
}
