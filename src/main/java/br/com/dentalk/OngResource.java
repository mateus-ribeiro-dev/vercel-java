package br.com.dentalk;

import br.com.dentalk.bo.OngBO;
import br.com.dentalk.entities.Ong;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.sql.SQLException;

@Path("/ong")
public class OngResource {

    private OngBO ongBO = new OngBO();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Ong ong, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
        OngBO.insertBo(ong);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((ong.getCnpj()));
        return Response.created(builder.build()).build();
    }

    // Buscar por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ong buscarId(@PathParam("id") String id) throws ClassNotFoundException, SQLException, SQLException {
        return  (Ong)  ongBO.buscarPorId(id);
    }

    // Atualizar
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Ong ong, @PathParam("id") Long id) throws ClassNotFoundException, SQLException {
        ong.setId(id);
        ongBO.atualizarBo(ong);
        return Response.ok().build();
    }

    // Deletar
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") String id) throws ClassNotFoundException, SQLException {
        ongBO.deletarBo(id);
        return Response.ok().build();
    }
}
