import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearArchivoTexto {

    public static void main(String[] args) {
        try {
            // Ruta del archivo y nombre
            String nombreArchivo = "pacientes.txt";
            
            // Crear un objeto FileWriter y un objeto PrintWriter para escribir en el archivo
            FileWriter archivo = new FileWriter(nombreArchivo);
            PrintWriter escritor = new PrintWriter(archivo);
            
            // Datos de los pacientes
            String[] pacientes = {
                "Juan Perez, fractura de pierna, C",
                "Maria Ramirez, apendicitis, A",
                "Lorenzo Toledo, chikunguya, E",
                "Carmen Sarmientos, dolores de parto, B"
            };
            
            // Escribir cada paciente en una línea del archivo
            for (String paciente : pacientes) {
                escritor.println(paciente);
            }
            
            // Cerrar el archivo
            escritor.close();
            
            // Mensaje de éxito
            System.out.println("El archivo " + nombreArchivo + " ha sido creado con éxito.");
            
        } catch (IOException e) {
            // Manejar cualquier excepción de IO
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
