
import jdk.nashorn.internal.codegen.OptimisticTypesPersistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class MathManagerTest {

    MathManager p = null;
    Alumno Ruben = null;
    Alumno Arnau = null;
    Alumno David = null;
    Operacion r = null;
    Operacion y = null;
    Operacion z = null;
    List<Instituto> listaInstitutos =new ArrayList<Instituto>();

    @Before
    public void setUp() {
        this.p = Singleton.getInstance().getImpl();
        int x = this.p.getIniciadorTest();
        if (x==0) {
            this.Ruben = new Alumno("Ruben", "llor");
            this.Arnau = new Alumno("Arnau", "cos");
            this.David = new Alumno("David", "itaca");
            this.r = new Operacion(1, 2, '+');
            this.y = new Operacion(4, 6, '-');
            this.z = new Operacion(2, 5, '*');

            this.p.addUser(Ruben);
            this.p.addUser(Arnau);
            this.p.addUser(David);
            this.p.addOperacion(r);
            this.p.addOperacion(y);
            this.p.addOperacion(z);
            this.p.modIniciadorTest();
        }
    }
    @After
    public void tearDown() {
        //this.p.clear();
    }

    @Test
    public void consultarAlumnoTest() {
        Alumno resultadoReal = p.consultarAlumno("Ruben");
        assertEquals("Ruben", resultadoReal.getNombre());
    }

    @Test
    public void consultarAlumno() {
        Alumno u = this.p.consultarAlumno("Ruben");
        assertEquals(u.getNombre(), "Ruben");

        u = this.p.consultarAlumno("XXXXX");
        assertNull(u);

    }

    @Test
    public void realizarOperacion() {

        Operacion op = new Operacion();
        op.setNum1(1);
        op.setNum2(2);
        op.setX('+');
        int resultado = this.p.realizarOperacion("Ruben", op);

    }

    @Test
    public void listadoProductosByVentasTest() {
        //la lista de compras en el productmanager esta vacia no se que debo hacer
        Instituto insti = new Instituto();
        insti.addAlumno(Ruben);
        insti.addAlumno(David);
        insti.addAlumno(Arnau);


        List<Instituto> listaOperacones = this.p.listadoProductosByVentas();
        assertEquals("Patata",listaVendidos.get(0).getNombre());
        assertEquals(listaVendidos.get(0).getNumeroVentas(), 20);


        assertEquals("cafe",listaVendidos.get(1).getNombre());
        assertEquals("coca cola",listaVendidos.get(2).getNombre());
    }


}
