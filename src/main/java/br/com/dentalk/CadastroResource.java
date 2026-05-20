package br.com.dentalk;

import br.com.dentalk.bo.CadastroBo;
import br.com.dentalk.entities.Cadastro;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;

@Path("/cadastro")
public class CadastroResource {

    private CadastroBo cadastroBo = new CadastroBo();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Cadastro cadastro, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        CadastroBo.insertBo(cadastro);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((cadastro.getNome()));
        return Response.created(builder.build()).build();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cadastro buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Cadastro)  cadastroBo.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Cadastro cadastro, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        cadastro.setId(id);
        cadastroBo.atualizarBo(cadastro);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        cadastroBo.deletarBo(id);
        return Response.ok().build();
    }


}
