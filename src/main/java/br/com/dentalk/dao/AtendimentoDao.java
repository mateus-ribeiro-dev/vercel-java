package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Atendimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtendimentoDao {
    Connection minhaConexao;

    public AtendimentoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Atendimento atendimento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO atendimento " +
                        "(id_consulta, nome_pac, data, horario_inicial, horario_final, procedimento, observacoes, paciente_presente) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, atendimento.getIdConsulta());
        stmt.setString(2, atendimento.getPacienteNome());
        stmt.setString(3, atendimento.getData());
        stmt.setString(4, atendimento.getHorarioInicial());
        stmt.setString(5, atendimento.getHorarioFinal());
        stmt.setString(6, atendimento.getProcedimento());
        stmt.setString(7, atendimento.getObservacoes());
        stmt.setString(8, atendimento.getPacientePresente());

        stmt.execute();
        stmt.close();

        return  "Atendimento cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String idConsulta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From atendimento where id_consulta =?");
        stmt.setString(1, idConsulta);

        stmt.execute();
        stmt.close();

        return "Atendimento Deletado com Sucesso!!!";
    }

    // UpDate
    public String atualizar(Atendimento atendimento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE atendimento SET " +
                        "nome_pac = ?, data = ?, horario_inicial = ?, horario_final = ?, procedimento = ?, observacoes = ?, paciente_presente = ? " +
                        "WHERE id_consulta = ?");
        stmt.setString(1, atendimento.getPacienteNome());
        stmt.setString(2, atendimento.getData());
        stmt.setString(3, atendimento.getHorarioInicial());
        stmt.setString(4, atendimento.getHorarioFinal());
        stmt.setString(5, atendimento.getProcedimento());
        stmt.setString(6, atendimento.getObservacoes());
        stmt.setString(7, atendimento.getPacientePresente());
        stmt.setString(8, atendimento.getIdConsulta());

        stmt.executeUpdate();
        stmt.close();

        return "Atendimento Atualizado com Sucesso!!!";
    }


    // Select / codigo
    public Atendimento selecionarPorId(String idConsulta) throws SQLException {
        Atendimento objAtendimento = null;

        PreparedStatement stmt = minhaConexao.prepareStatement("select * from atendimento where id_consulta = ?");
        stmt.setString(1, idConsulta);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objAtendimento = new Atendimento();
            objAtendimento.setIdConsulta(rs.getString(1));
            objAtendimento.setPacienteNome(rs.getString(2));
            objAtendimento.setData(rs.getString(3));
            objAtendimento.setHorarioInicial(rs.getString(4));
            objAtendimento.setHorarioFinal(rs.getString(5));
            objAtendimento.setProcedimento(rs.getString(6));
            objAtendimento.setObservacoes(rs.getString(7));
            objAtendimento.setPacientePresente(rs.getString(8));
        }
        return objAtendimento;
    }
}
