public class Main {

    public static void main(String[] args) {
        // Crear una cola de prioridad utilizando el constructor que lee los pacientes desde el archivo
        VectorHeap<Paciente> emergencias = new VectorHeap<>("pacientes.txt");

        // Atender a los pacientes en orden de prioridad
        while (!emergencias.isEmpty()) {
            Paciente pacienteAtendido = emergencias.remove();
            System.out.println("Atendiendo a: " + pacienteAtendido);
        }
    }
}
