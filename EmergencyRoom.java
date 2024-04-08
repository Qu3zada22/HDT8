public class EmergencyRoom {
    private VectorHeap<Paciente> emergencias;

    public EmergencyRoom(String filename) {
        emergencias = new VectorHeap<>(filename);
    }

    public void atenderPacientes() {
        while (!emergencias.isEmpty()) {
            Paciente pacienteAtendido = emergencias.remove();
            System.out.println("Atendiendo a: " + pacienteAtendido);
        }
    }

    public static void main(String[] args) {
        EmergencyRoom salaEmergencias = new EmergencyRoom("pacientes.txt");
        salaEmergencias.atenderPacientes();
    }
}
