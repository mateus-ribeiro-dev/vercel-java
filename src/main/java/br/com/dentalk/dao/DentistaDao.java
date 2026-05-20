package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Dentista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DentistaDao {
    Connection minhaConexao;

    public DentistaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO dentista " +
                "(nomeCompleto, dataNascimento, identidadeGenero, cpf, cro, especialidade) " +
                "VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, dentista.getNomeCompleto());
        stmt.setString(2, dentista.getDataNascimento());
        stmt.setString(3, dentista.getIdentidadeGenero());
        stmt.setString(4, dentista.getCpf());
        stmt.setString(5, dentista.getCro());
        stmt.setString(6, dentista.getEspecialidade());

        stmt.execute();
        stmt.close();

        return  "Dentista cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From dentista where id =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();

        return "Dentista Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE dentista SET " +
                        "nomeCompleto = ?, dataNascimento = ?, identidadeGenero = ?, " +
                        "cpf = ?, cro = ?, especialidade = ? " +
                        "WHERE id = ?");
        stmt.setString(1, dentista.getNomeCompleto());
        stmt.setString(2, dentista.getDataNascimento());
        stmt.setString(3, dentista.getIdentidadeGenero());
        stmt.setString(4, dentista.getCpf());
        stmt.setString(5, dentista.getCro());
        stmt.setString(6, dentista.getEspecialidade());
        stmt.setLong(7, dentista.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Dentista Atualizado com Sucesso!";
    }


    // Select / codigo
    public Dentista selecionarPorId(String codigo) throws SQLException {
        Dentista objDentista = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from dentista where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objDentista = new Dentista();
            objDentista.setId(rs.getLong(1));
            objDentista.setNomeCompleto(rs.getString(2));
            objDentista.setDataNascimento(rs.getString(3));
            objDentista.setIdentidadeGenero(rs.getString(4));
            objDentista.setCpf(rs.getString(5));
            objDentista.setCro(rs.getString(6));
            objDentista.setEspecialidade(rs.getString(7));
        }
        return objDentista;
    }
}
