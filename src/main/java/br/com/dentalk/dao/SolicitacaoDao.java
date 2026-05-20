package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SolicitacaoDao {
    Connection minhaConexao;

    public SolicitacaoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Solicitacao solicitacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO solicitacao " +
                "(data, horario, descQueixa, status, prioridade) " +
                "VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, solicitacao.getData());
        stmt.setString(2, solicitacao.getHorario());
        stmt.setString(3, solicitacao.getDescQueixa());
        stmt.setString(4, solicitacao.getStatus());
        stmt.setString(5, solicitacao.getPrioridade());


        stmt.execute();
        stmt.close();

        return  "Solicitacao cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From solicitacao where id = ?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();

        return "Solicitacao Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Solicitacao solicitacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE solicitacao SET " +
                        "horario = ?, descQueixa = ?, status = ?, prioridade = ?, data = ? " +
                        "WHERE id = ?");
        stmt.setString(1, solicitacao.getHorario());
        stmt.setString(2, solicitacao.getDescQueixa());
        stmt.setString(3, solicitacao.getStatus());
        stmt.setString(4, solicitacao.getPrioridade());
        stmt.setString(5, solicitacao.getData());
        stmt.setLong(6, solicitacao.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Solicitacao Atualizado com Sucesso!";
    }

    // Select / codigo
    public Solicitacao selecionarPorId(String codigo) throws SQLException {
        Solicitacao objSolicitacao = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from solicitacao where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objSolicitacao = new Solicitacao();
            objSolicitacao.setId(rs.getLong(1));
            objSolicitacao.setData(rs.getString(2));
            objSolicitacao.setHorario(rs.getString(3));
            objSolicitacao.setDescQueixa(rs.getString(4));
            objSolicitacao.setStatus(rs.getString(5));
            objSolicitacao.setPrioridade(rs.getString(6));
        }
        return objSolicitacao;
    }
}
