package br.com.dentalk;

import br.com.dentalk.bo.EnderecoBO;
import br.com.dentalk.entities.Endereco;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;

@Path("/endereco")
public class EnderecoResource {

    private EnderecoBO enderecoBO = new EnderecoBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Endereco endereco, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        EnderecoBO.insertBo(endereco);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((endereco.getCep()));
        return Response.created(builder.build()).build();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Endereco)  enderecoBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Endereco endereco, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        endereco.setId(id);
        enderecoBO.atualizarBo(endereco);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        enderecoBO.deletarBo(id);
        return Response.ok().build();
    }

}
