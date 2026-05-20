package br.com.dentalk;

import br.com.dentalk.bo.PacienteBO;
import br.com.dentalk.entities.Paciente;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;

@Path("/paciente")
public class PacienteResource {

    private PacienteBO pacienteBO = new PacienteBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        PacienteBO.insertBo(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((paciente.getCpf()));
        return Response.created(builder.build()).build();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Paciente)  pacienteBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        paciente.setId(id);
        pacienteBO.atualizarBo(paciente);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        pacienteBO.deletarBo(id);
        return Response.ok().build();
    }

}
