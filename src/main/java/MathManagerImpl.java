import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MathManagerImpl implements MathManager{

    List<Alumno> listaAlumnos = new ArrayList<Alumno>();
    List<Instituto> listaInstitutos =new ArrayList<Instituto>();
    Queue<Operacion> listaOperacioesTotal = new LinkedList<Operacion>();

    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger("myLogger");

    // contador para saber el numero total de operaciones realizadas
    int contadorOperaciones = 0;
    private int iniciadorRest =0;
    private int iniciadorTest=0;


    public void modIniciadorTest (){
        this.iniciadorTest=1;
    }
    public int getIniciadorTest(){
        return this.iniciadorTest;
    }
    public int getIniciadorRest (){
        return this.iniciadorRest;
    }
    public void modIniciadorRest (){
        this.iniciadorRest=1;
    }


    public void AlumnosExistentes() {
        //creamos algunos alumnos por defecto
        Alumno user1 = new Alumno("Ruben", "Llor");
        listaAlumnos.add(user1);
        Alumno user2 = new Alumno("Pepe", "Itaca");
        listaAlumnos.add(user2);
    }



    public Alumno Identificarse(String nombre){

        Alumno al = consultarAlumno(nombre);
        return al;
    }
    public Alumno consultarAlumno(String alumno) {
        for(Alumno userAl: listaAlumnos){
            if (userAl.getNombre().equals(alumno)) {
                return userAl;
            }
        }
        return null;

    }

    public void addUser (Alumno newalumno) {
        listaAlumnos.add(newalumno);
    }
    public void addInsti (Instituto newinsti) {
        listaInstitutos.add(newinsti);
    }
    public void addOperacion (Operacion newoperacion) {
        listaOperacioesTotal.add(newoperacion);
    }


    public void realizarOperacion (String alumn, Operacion op){

        Alumno al = consultarAlumno(alumn);
        op = new Operacion();
        if (al==null){
            logger.log(Level.SEVERE,  "El usuario no existe");
        }
        else{
            al.addOperacion(op);
            listaOperacioesTotal.add(op);
            contadorOperaciones++;
            logger.log(Level.SEVERE,  "Operacion en espera");

        }

    }
    public Operacion servirOperacion () {
        Operacion p = listaOperacioesTotal.poll();
        if (p==null) return p;
        else{
            int x = p.getNum1();
            int y = p.getNum2();
            char j = p.getX();

            int result;
            result = x+j+y;
            p.setResultado(result);
            return p;
        }

    }

    public List<Operacion> listarOperacionesInsti(String Instituto){
        List<Operacion> listaInsti = new ArrayList<Operacion>();
        for(Instituto InstiLis: listaInstitutos){
            if (InstiLis.getNombre().equals(Instituto)) {
                listaInsti = InstiLis.consultaOperaciones();
            }
        }
        return listaInsti;
    }

    public List<Operacion> listarOperacionesAlumno(String Alumno){
        List<Operacion> listaAL = new ArrayList<Operacion>();
        for(Alumno AlumnList: listaAlumnos){
            if (AlumnList.getNombre().equals(Alumno)) {
                listaAL = AlumnList.consultaOperaciones();
            }
        }
        return listaAL;
    }

    public List<Instituto> listadoInsittutosPorNumOp () {
        //ordenamos la lista de productoss por el numero de ventas
        List<Instituto> listaInsits = new ArrayList(listaInstitutos);
        Collections.sort(listaInsits,Comparator.comparing(Instituto::getNumOperaciones));
        Collections.reverse(listaInsits);
        for (Instituto Insti: listaInsits){
            logger.log(Level.SEVERE,  Insti.getNombre()+ "    " + Insti.getNumOperaciones());
        }
        return listaInsits;
    }


}
