import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class Instituto {

    String nombre;
    int numOperaciones;

    private List<Alumno> alumnoList = new LinkedList<Alumno>();
    private List<Operacion> operacionesList = new LinkedList<Operacion>();

    public Instituto(){

    }

    public Instituto(String nom)
    {
        this.nombre=nom;
        numOperaciones=0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumOperaciones() {
        return numOperaciones;
    }

    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

    public List<Operacion> consultaOperaciones(){
        return this.operacionesList;
    }
    public void addOperacion (Operacion p){
        this.operacionesList.add(p);
        numOperaciones++;
    }

    public List<Alumno> consultaAlumnos(){
        return this.alumnoList;
    }
    public void addAlumno (Alumno p){
        this.alumnoList.add(p);
        numOperaciones=numOperaciones+p.numOperaciones;
    }
}
