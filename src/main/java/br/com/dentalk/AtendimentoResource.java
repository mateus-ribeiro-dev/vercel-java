package br.com.dentalk;

import br.com.dentalk.bo.AtendimentoBO;
import br.com.dentalk.entities.Atendimento;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.List;

@Path("/atendimento")
public class AtendimentoResource {

    private AtendimentoBO atendimentoBO = new AtendimentoBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Atendimento atendimento, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        AtendimentoBO.insertBo(atendimento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(atendimento.getIdConsulta()));
        return Response.created(builder.build()).build();
    }

    // Listar todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atendimento> listarTodosRs() throws ClassNotFoundException, SQLException {
        return atendimentoBO.listarTodosBo();
    }

    // buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Atendimento buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Atendimento)  atendimentoBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Atendimento atendimento, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        atendimentoBO.atualizarBo(atendimento);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        atendimentoBO.deletarBo(id);
        return Response.ok().build();
    }

}
