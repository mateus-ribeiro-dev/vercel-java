package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Prontuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioDao {
    Connection minhaConexao;

    public ProntuarioDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Prontuario prontuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO prontuario " +
                "(diagnosticoCid, procedimento, observacao, statusEvolucao) " +
                "VALUES (?, ?, ?, ?)");
        stmt.setString(1, prontuario.getDiagnosticoCid());
        stmt.setString(2, prontuario.getProcedimento());
        stmt.setString(3, prontuario.getObservacao());
        stmt.setString(4, prontuario.getStatusEvolucao());


        stmt.execute();
        stmt.close();

        return  "Prontuario cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From prontuario where id =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();

        return "Prontuario Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Prontuario prontuario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("update prontuario set procedimento = ?, observacao = ?, statusEvolucao = ?, diagnosticoCid = ? where id = ?");
        stmt.setString(1, prontuario.getProcedimento());
        stmt.setString(2, prontuario.getObservacao());
        stmt.setString(3, prontuario.getStatusEvolucao());
        stmt.setString(4, prontuario.getDiagnosticoCid());
        stmt.setLong(5, prontuario.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Prontuario Atualizado com Sucesso!";
    }

    // Select / codigo
    public Prontuario selecionarPorId(String codigo) throws SQLException {
        Prontuario objProntuario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from prontuario where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objProntuario = new Prontuario();
            objProntuario.setId(rs.getLong(1));
            objProntuario.setDiagnosticoCid(rs.getString(2));
            objProntuario.setProcedimento(rs.getString(3));
            objProntuario.setObservacao(rs.getString(4));
            objProntuario.setStatusEvolucao(rs.getString(5));
        }
        return objProntuario;
    }

    // Select All
    public List<Prontuario> listarTodos() throws SQLException {
        List<Prontuario> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM prontuario");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Prontuario objProntuario = new Prontuario();
            objProntuario.setId(rs.getLong(1));
            objProntuario.setDiagnosticoCid(rs.getString(2));
            objProntuario.setProcedimento(rs.getString(3));
            objProntuario.setObservacao(rs.getString(4));
            objProntuario.setStatusEvolucao(rs.getString(5));
            lista.add(objProntuario);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
