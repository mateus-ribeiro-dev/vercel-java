package br.com.dentalk.dao;

import br.com.dentalk.conexoes.ConexaoFactory;
import br.com.dentalk.entities.Cadastro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroDao {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public CadastroDao() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Insert
    public String inserir(Cadastro cadastro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("INSERT INTO cadastro " +
                        "(categoria, status, nome, dataNascimento, cpf, email, telefone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, cadastro.getCategoria());
        stmt.setString(2, cadastro.getStatus());
        stmt.setString(3, cadastro.getNome());
        stmt.setString(4, cadastro.getDataNascimento());
        stmt.setString(5, cadastro.getCpf());
        stmt.setString(6, cadastro.getEmail());
        stmt.setString(7, cadastro.getTelefone());

        stmt.execute();
        stmt.close();

        return "Cadastro feito com sucesso!";
    }

    // Delete
    public String deletar(String id) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From cadastro where id =?");
        stmt.setString(1, id);

        stmt.execute();
        stmt.close();

        return "Cadastro Deletado com Sucesso!";
    }

    // UpDate
    public String atualizar(Cadastro cadastro) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("UPDATE cadastro " +
                        "SET categoria = ?, status = ?, nome = ?, dataNascimento = ?, cpf = ?, email = ?, telefone = ? " +
                        "WHERE id = ?");
        stmt.setString(1, cadastro.getCategoria());
        stmt.setString(2, cadastro.getStatus());
        stmt.setString(3, cadastro.getNome());
        stmt.setString(4, cadastro.getDataNascimento());
        stmt.setString(5, cadastro.getCpf());
        stmt.setString(6, cadastro.getEmail());
        stmt.setString(7, cadastro.getTelefone());
        stmt.setLong(8, cadastro.getId());

        stmt.executeUpdate();
        stmt.close();

        return "Cadastro Atualizado com Sucesso!";
    }

    // Select Id
    public Cadastro selecionarPorId(String id) throws SQLException {
        Cadastro objCadastro = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from cadastro where id = ?");
        stmt.setString(1, id);

        ResultSet rs = stmt.executeQuery();

        if(rs.next()) {
            objCadastro = new Cadastro();
            objCadastro.setId(rs.getLong(1));
            objCadastro.setCategoria(rs.getString(2));
            objCadastro.setStatus(rs.getString(3));
            objCadastro.setNome(rs.getString(4));
            objCadastro.setDataNascimento(rs.getString(5));
            objCadastro.setCpf(rs.getString(6));
            objCadastro.setEmail(rs.getString(7));
            objCadastro.setTelefone(rs.getString(8));

        }
        return objCadastro;
    }

    // Select All
    public List<Cadastro> listarTodos() throws SQLException {
        List<Cadastro> lista = new ArrayList<>();

        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM atendimento");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cadastro objCadastro = new Cadastro();
            objCadastro = new Cadastro();
            objCadastro.setId(rs.getLong(1));
            objCadastro.setCategoria(rs.getString(2));
            objCadastro.setStatus(rs.getString(3));
            objCadastro.setNome(rs.getString(4));
            objCadastro.setDataNascimento(rs.getString(5));
            objCadastro.setCpf(rs.getString(6));
            objCadastro.setEmail(rs.getString(7));
            objCadastro.setTelefone(rs.getString(8));
            lista.add(objCadastro);
        }

        rs.close();
        stmt.close();
        return lista;
    }
}
