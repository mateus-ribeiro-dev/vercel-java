package br.com.dentalk;

import br.com.dentalk.bo.ProntuarioBO;
import br.com.dentalk.entities.Prontuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;

@Path("/prontuario")
public class ProntuarioResource {

    private ProntuarioBO prontuarioBO = new ProntuarioBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Prontuario prontuario, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        ProntuarioBO.insertBo(prontuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((prontuario.getDiagnosticoCid()));
        return Response.created(builder.build()).build();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prontuario buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Prontuario)  prontuarioBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Prontuario prontuario, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        prontuario.setId(id);
        prontuarioBO.atualizarBo(prontuario);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        prontuarioBO.deletarBo(id);
        return Response.ok().build();
    }
}
