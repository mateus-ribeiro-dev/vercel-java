package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Ong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OngDao {
    Connection minhaConexao;

    public OngDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Ong ong) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO ong " +
                "(cnpj, razaoSocial, nomeFantasia) " +
                "VALUES (?, ?, ?)");
        stmt.setString(1, ong.getCnpj());
        stmt.setString(2, ong.getRazaoSocial());
        stmt.setString(3, ong.getNomeFantasia());


        stmt.execute();
        stmt.close();

        return  "Ong cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From ong where id =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();

        return "Ong Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Ong ong) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE ong SET razaoSocial = ?, nomeFantasia = ?, cnpj = ? WHERE id = ?");
        stmt.setString(1, ong.getRazaoSocial());
        stmt.setString(2, ong.getNomeFantasia());
        stmt.setString(3, ong.getCnpj());
        stmt.setLong(4, ong.getId());


        stmt.executeUpdate();
        stmt.close();

        return "Ong Atualizado com Sucesso!";
    }

    // Select / codigo
    public Ong selecionarPorId(String codigo) throws SQLException {
        Ong objOng = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from ong where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objOng = new Ong();
            objOng.setId(rs.getLong(1));
            objOng.setCnpj(rs.getString(2));
            objOng.setRazaoSocial(rs.getString(3));
            objOng.setNomeFantasia(rs.getString(4));
        }
        return objOng;
    }
}
