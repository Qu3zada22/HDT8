public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    // Constructor
    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    public void setCodigoEmergencia(char codigoEmergencia) {
        this.codigoEmergencia = codigoEmergencia;
    }

    // Método compareTo para comparar pacientes por su código de emergencia
    @Override
    public int compareTo(Paciente otroPaciente) {
        return Character.compare(this.codigoEmergencia, otroPaciente.getCodigoEmergencia());
    }

    // Método toString para representar un paciente como una cadena de texto
    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
