package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {
    Connection minhaConexao;

    public PacienteDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert / Inserir
    public String inserir(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO paciente " +
                "(cpf, nomeCompleto, nomeSocial, dataNascimento, identidadeGenero, nomeMae, nomePai, nacionalidade, rg) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, paciente.getCpf());
        stmt.setString(2, paciente.getNomeCompleto());
        stmt.setString(3, paciente.getNomeSocial());
        stmt.setString(4, paciente.getDataNascimento());
        stmt.setString(5, paciente.getIdentidadeGenero());
        stmt.setString(6, paciente.getNomeMae());
        stmt.setString(7, paciente.getNomePai());
        stmt.setString(8, paciente.getNacionalidade());
        stmt.setString(9, paciente.getRg());

        stmt.execute();
        stmt.close();

        return  "Paciente cadastrado com sucesso!";
    }

    // Delete
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From paciente where id =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();

        return "Paciente Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Paciente paciente) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE paciente SET " +
                        "cpf = ?, nomeCompleto = ?, nomeSocial = ?, dataNascimento = ?, identidadeGenero = ?, " +
                        "nomeMae = ?, nomePai = ?, nacionalidade = ?, rg = ? " +
                        "WHERE id = ?");
        stmt.setString(1, paciente.getCpf());
        stmt.setString(2, paciente.getNomeCompleto());
        stmt.setString(3, paciente.getNomeSocial());
        stmt.setString(4, paciente.getDataNascimento());
        stmt.setString(5, paciente.getIdentidadeGenero());
        stmt.setString(6, paciente.getNomeMae());
        stmt.setString(7, paciente.getNomePai());
        stmt.setString(8, paciente.getNacionalidade());
        stmt.setString(9, paciente.getRg());
        stmt.setLong(10, paciente.getId());


        stmt.executeUpdate();
        stmt.close();

        return "Paciente Atualizado com Sucesso!";
    }

    // Select / codigo
    public Paciente selecionarPorId(String codigo) throws SQLException {
        Paciente objPaciente = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from paciente where id = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objPaciente = new Paciente();
            objPaciente.setId(rs.getLong(1));
            objPaciente.setCpf(rs.getString(2));
            objPaciente.setNomeCompleto(rs.getString(3));
            objPaciente.setNomeSocial(rs.getString(4));
            objPaciente.setDataNascimento(rs.getString(5));
            objPaciente.setIdentidadeGenero(rs.getString(6));
            objPaciente.setNomeMae(rs.getString(7));
            objPaciente.setNomePai(rs.getString(8));
            objPaciente.setNacionalidade(rs.getString(9));
            objPaciente.setRg(rs.getString(10));
        }
        return objPaciente;
    }

    // Select All
    public List<Paciente> listarTodos() throws SQLException {
        List<Paciente> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM paciente");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Paciente objPaciente = new Paciente();
            objPaciente.setId(rs.getLong(1));
            objPaciente.setCpf(rs.getString(2));
            objPaciente.setNomeCompleto(rs.getString(3));
            objPaciente.setNomeSocial(rs.getString(4));
            objPaciente.setDataNascimento(rs.getString(5));
            objPaciente.setIdentidadeGenero(rs.getString(6));
            objPaciente.setNomeMae(rs.getString(7));
            objPaciente.setNomePai(rs.getString(8));
            objPaciente.setNacionalidade(rs.getString(9));
            objPaciente.setRg(rs.getString(10));
            lista.add(objPaciente);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}