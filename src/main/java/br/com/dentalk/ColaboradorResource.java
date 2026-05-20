package br.com.dentalk;

import br.com.dentalk.bo.ColaboradorBO;
import br.com.dentalk.entities.Colaborador;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.List;

@Path("/colaborador")
public class ColaboradorResource {

    private ColaboradorBO colaboradorBO = new ColaboradorBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Colaborador colaborador, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        ColaboradorBO.insertBo(colaborador);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((colaborador.getNomeCompleto()));
        return Response.created(builder.build()).build();
    }

    // Listar todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Colaborador> listarTodosRs() throws ClassNotFoundException, SQLException {
        return colaboradorBO.listarTodosBo();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Colaborador buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Colaborador)  colaboradorBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Colaborador colaborador, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        colaborador.setId(id);
        colaboradorBO.atualizarBo(colaborador);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        colaboradorBO.deletarBo(id);
        return Response.ok().build();
    }
}
