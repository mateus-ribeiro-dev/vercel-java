package br.com.dentalk.bo;

import br.com.dentalk.dao.EnderecoDao;
import br.com.dentalk.entities.Endereco;

import java.sql.SQLException;
import java.util.List;

public class EnderecoBO {

    EnderecoDao enderecoDao;

    //Selecionar
    public Endereco buscarPorId(String id) throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDao();
        // regra de negócios
        return enderecoDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Endereco endereco) throws SQLException, ClassNotFoundException {
        EnderecoDao enderecoDao = new EnderecoDao();
        // regra de negócios
        enderecoDao.inserir(endereco);
    }

    //atualizar
    public void atualizarBo(Endereco endereco) throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDao();
        // regra de negócios
        enderecoDao.atualizar(endereco);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDao();
        // regra de negócios
        enderecoDao.deletar(id);
    }

    // selecionar todos
    public List<Endereco> listarTodosBo() throws SQLException, ClassNotFoundException {
        enderecoDao = new EnderecoDao();
        return enderecoDao.listarTodos();
    }
}
