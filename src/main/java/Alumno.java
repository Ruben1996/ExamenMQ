import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Alumno {

    String nombre;
    String nombreInsti;
    int numOperaciones;

    private List<Operacion> operacionList = new LinkedList<Operacion>();

    public Alumno(){}

    public Alumno(String nombre, String Insti)
    {
        this.nombre=nombre;
        this.nombreInsti=Insti;
        this.numOperaciones=0;
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
        return this.operacionList;
    }
    public void addOperacion (Operacion p){
        this.operacionList.add(p);
        numOperaciones++;
    }
}
