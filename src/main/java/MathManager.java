import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public interface MathManager {
    Alumno Identificarse(String nombre);
    void realizarOperacion (String alumn, Operacion op);
    Operacion servirOperacion();
    List<Operacion> listarOperacionesInsti(String Instituto);
    List<Operacion> listarOperacionesAlumno(String Alumno);
    List<Instituto> listadoInsittutosPorNumOp ();


    Alumno consultarAlumno(String alumno);
    void addUser (Alumno newalumno);
    void addInsti (Instituto newinsti);
    void addOperacion (Operacion newoperacion);
    void modIniciadorTest ();
    void modIniciadorRest ();
    int getIniciadorRest ();
    int getIniciadorTest ();

}
