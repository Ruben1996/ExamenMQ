import java.util.LinkedList;
import java.util.List;
import javax.sound.midi.Track;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/json")
public class JSONService {

    protected MathManagerImpl MathManagerImpl;

    public JSONService() {
        this.MathManagerImpl = Singleton.getInstance().getImpl();
        int x = this.MathManagerImpl.getIniciadorRest();
        if (x==0) {
            MathManagerImpl.AlumnosExistentes();
            String nombre = "Ruben";
            MathManagerImpl.modIniciadorRest();
        }

    }

    @GET
    @Path("/user/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alumno getUser(@PathParam("nom") String nom) {
        return MathManagerImpl.Identificarse(nom);
    }


    @GET
    @Path("/listarOperacionesInstituto/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacion> getListarOperaciones(@PathParam("nom") String nom) {
        return MathManagerImpl.listarOperacionesInsti(nom);

    }


    @GET
    @Path("/listaOPeracionesAlumno/{nom}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Operacion> getListarOperacionesAlumno(@PathParam("nom") String nom) {
        return MathManagerImpl.listarOperacionesAlumno(nom);
    }


    @GET
    @Path("/ListadoInstisPorNumOperaciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instituto> getInstisporOperaciones() {
        return MathManagerImpl.listadoInsittutosPorNumOp();
    }



    @POST
    @Path("/Operacion/{user}/{op}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response compra (@PathParam("user") String user, Pedido pedido) {
        //public Response compra (@PathParam("user") String user, LinkedList pedido) {
        //Pedido p = null;
        //p.setListaDePedidos(pedido);
        boolean col  = productManagerImpl.realizarPedido(user, pedido);
        if (col){
            return Response.status(201).entity("Pedio preparado para realizar").build();
        }
        else{
            return Response.status(409).entity("Error de compra").build();
        }

    }

}

