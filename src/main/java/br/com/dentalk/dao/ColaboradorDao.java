package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDao {
    Connection minhaConexao;

    public ColaboradorDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }


    // Insert / Inserir
    public String inserir(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO colaborador " +
                "(registro_colab, nome_colab, dat_nascimento, cargo_colab) " +
                "VALUES (?, ?, ?, ?)");
        stmt.setString(1, colaborador.getRegistroColab());
        stmt.setString(2, colaborador.getNomeCompleto());
        stmt.setString(3, colaborador.getDataNascimento());
        stmt.setString(4, colaborador.getCargo());

        stmt.execute();
        stmt.close();
        minhaConexao.close();

        return  "Colaborador cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From colaborador where id =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();
        minhaConexao.close();


        return "Colaborador Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("update colaborador set nome_colab = ?, dat_nascimento = ?, cargo_colab = ?, registro_colab = ? where id = ?");
        stmt.setString(1, colaborador.getNomeCompleto());
        stmt.setString(2, colaborador.getDataNascimento());
        stmt.setString(3, colaborador.getCargo());
        stmt.setString(4, colaborador.getRegistroColab());
        stmt.setLong(5, colaborador.getId());

        stmt.executeUpdate();
        stmt.close();
        minhaConexao.close();

        return "Colaborador Atualizado com Sucesso!";
    }


    // Select / codigo
    public Colaborador selecionarPorId(String codigo) throws SQLException, ClassNotFoundException {
        Colaborador objColaborador = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from colaborador where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objColaborador = new Colaborador();
            objColaborador.setId(rs.getLong(1));
            objColaborador.setregistroColab(rs.getString(2));
            objColaborador.setNomeCompleto(rs.getString(3));
            objColaborador.setDataNascimento(rs.getString(4));
            objColaborador.setCargo(rs.getString(5));
        }
        minhaConexao.close();
        return objColaborador;
    }

    // Select All
    public List<Colaborador> listarTodos() throws SQLException {
        List<Colaborador> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("select * from colaborador WHERE id IS NOT NULL");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Colaborador objColaborador = new Colaborador();
            objColaborador.setId(rs.getLong(1));
            objColaborador.setregistroColab(rs.getString(2));
            objColaborador.setNomeCompleto(rs.getString(3));
            objColaborador.setDataNascimento(rs.getString(4));
            objColaborador.setCargo(rs.getString(5));
            lista.add(objColaborador);
        }

        rs.close();
        stmt.close();
        minhaConexao.close();
        return lista;
    }
}
