import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Implementación de un heap binario utilizando un vector interno para almacenar los elementos.
 * Esta clase implementa la interfaz PriorityQueue<E>, proporcionando métodos para insertar,
 * eliminar y verificar si el heap está vacío, así como para obtener su tamaño.
 *
 * @param <E> el tipo de elementos que se almacenarán en el heap, que debe ser comparable para poder
 *            establecer el orden de prioridad.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> data; // Vector interno para almacenar los elementos del heap

    /**
     * Constructor predeterminado que crea un nuevo VectorHeap vacío.
     */
    public VectorHeap() {
        data = new Vector<>();
    }

    /**
     * Constructor adicional que construye el heap a partir de un archivo de texto que contiene
     * los datos de los pacientes.
     *
     * @param filename el nombre del archivo que contiene los datos de los pacientes.
     */
    public VectorHeap(String filename) {
        this(); // Llama al constructor predeterminado para inicializar el vector interno
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String sintoma = partes[1];
                    char codigoEmergencia = partes[2].charAt(0);
                    @SuppressWarnings("unchecked")
                    E paciente = (E) new Paciente(nombre, sintoma, codigoEmergencia);
                    add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Métodos para ajustar el índice de los elementos en el heap
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

    /**
     * Inserta un elemento en el heap y ajusta el heap para mantener el orden de prioridad.
     *
     * @param value el elemento que se va a insertar en el heap.
     */
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

    /**
     * Elimina y devuelve el elemento con mayor prioridad del heap.
     *
     * @return el elemento con mayor prioridad del heap, o null si el heap está vacío.
     */
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

    /**
     * Verifica si el heap está vacío.
     *
     * @return true si el heap está vacío, false en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Obtiene el tamaño del heap, es decir, el número de elementos en el heap.
     *
     * @return el tamaño del heap.
     */
    @Override
    public int size() {
        return data.size();
    }
}
