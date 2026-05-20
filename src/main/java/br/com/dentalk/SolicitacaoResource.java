package br.com.dentalk;

import br.com.dentalk.bo.SolicitacaoBO;
import br.com.dentalk.entities.Solicitacao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;
import java.util.List;

@Path("/solicitacao")
public class SolicitacaoResource {

    private SolicitacaoBO solicitacaoBO = new SolicitacaoBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Solicitacao solicitacao, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        SolicitacaoBO.insertBo(solicitacao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((solicitacao.getData()));
        return Response.created(builder.build()).build();
    }

    // Listar todos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Solicitacao> listarTodosRs() throws ClassNotFoundException, SQLException {
        return solicitacaoBO.listarTodosBo();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Solicitacao buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Solicitacao)  solicitacaoBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Solicitacao solicitacao, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        solicitacao.setId(id);
        solicitacaoBO.atualizarBo(solicitacao);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        solicitacaoBO.deletarBo(id);
        return Response.ok().build();
    }
}
