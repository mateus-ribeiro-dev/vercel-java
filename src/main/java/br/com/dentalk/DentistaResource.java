package br.com.dentalk;

import br.com.dentalk.bo.DentistaBO;
import br.com.dentalk.entities.Dentista;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;

@Path("/dentista")
public class DentistaResource {
    private DentistaBO dentistaBO = new DentistaBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Dentista dentista, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        DentistaBO.insertBo(dentista);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((dentista.getCpf()));
        return Response.created(builder.build()).build();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dentista buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Dentista)  dentistaBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Dentista dentista, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        dentista.setId(id);
        dentistaBO.atualizarBo(dentista);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        dentistaBO.deletarBo(id);
        return Response.ok().build();
    }
}
