package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {
    Connection minhaConexao;

    public EnderecoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO endereco " +
                        "(logradouro, numero, complemento, bairro, cidade, estado, pais, cep) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

        stmt.setString(1, endereco.getLogradouro());
        stmt.setInt(2, endereco.getNumero());
        stmt.setString(3, endereco.getComplemento());
        stmt.setString(4, endereco.getBairro());
        stmt.setString(5, endereco.getCidade());
        stmt.setString(6, endereco.getEstado());
        stmt.setString(7, endereco.getPais());
        stmt.setString(8, endereco.getCep());

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return  "Endereco cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From endereco where id =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return "Endereco Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Endereco endereco) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("update endereco set logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, pais = ?, cep = ? where id = ?");
        stmt.setString(1, endereco.getLogradouro());
        stmt.setInt(2, endereco.getNumero());
        stmt.setString(3, endereco.getComplemento());
        stmt.setString(4, endereco.getBairro());
        stmt.setString(5, endereco.getCidade());
        stmt.setString(6, endereco.getEstado());
        stmt.setString(7, endereco.getPais());
        stmt.setString(8, endereco.getCep());
        stmt.setLong(9,endereco.getId());

        stmt.executeUpdate();
        stmt.close();
        minhaConexao.close();

        return "Endereco Atualizado com Sucesso!";
    }


    // Select / codigo
    public Endereco selecionarPorId(String codigo) throws SQLException {
        Endereco objEndereco = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from endereco where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objEndereco = new Endereco();
            objEndereco.setId(rs.getLong(1));
            objEndereco.setLogradouro(rs.getString(2));
            objEndereco.setNumero(rs.getInt(3));
            objEndereco.setComplemento(rs.getString(4));
            objEndereco.setBairro(rs.getString(5));
            objEndereco.setCidade(rs.getString(6));
            objEndereco.setEstado(rs.getString(7));
            objEndereco.setPais(rs.getString(8));
            objEndereco.setCep(rs.getString(9));
        }
        minhaConexao.close();
        return objEndereco;
    }

    // Select All
    public List<Endereco> listarTodos() throws SQLException {
        List<Endereco> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM endereco WHERE id IS NOT NULL");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Endereco objEndereco = new Endereco();
            objEndereco = new Endereco();
            objEndereco.setId(rs.getLong(1));
            objEndereco.setLogradouro(rs.getString(2));
            objEndereco.setNumero(rs.getInt(3));
            objEndereco.setComplemento(rs.getString(4));
            objEndereco.setBairro(rs.getString(5));
            objEndereco.setCidade(rs.getString(6));
            objEndereco.setEstado(rs.getString(7));
            objEndereco.setPais(rs.getString(8));
            objEndereco.setCep(rs.getString(9));
            lista.add(objEndereco);
        }

        rs.close();
        stmt.close();
        minhaConexao.close();
        return lista;
    }
}
