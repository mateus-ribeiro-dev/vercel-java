package br.com.dentalk.bo;

import br.com.dentalk.dao.DentistaDao;
import br.com.dentalk.entities.Dentista;

import java.sql.SQLException;
import java.util.List;

public class DentistaBO {

    DentistaDao dentistaDao;

    //Selecionar
    public Dentista buscarPorId(String id) throws SQLException, ClassNotFoundException {
        dentistaDao = new DentistaDao();
        // regra de negócios
        return dentistaDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Dentista dentista) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDao = new DentistaDao();
        // regra de negócios
        dentistaDao.inserir(dentista);
    }

    //atualizar
    public void atualizarBo(Dentista dentista) throws SQLException, ClassNotFoundException {
        dentistaDao = new DentistaDao();
        // regra de negócios
        dentistaDao.atualizar(dentista);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        dentistaDao = new DentistaDao();
        // regra de negócios
        dentistaDao.deletar(id);
    }

    // selecionar todos
    public List<Dentista> listarTodosBo() throws SQLException, ClassNotFoundException {
        dentistaDao = new DentistaDao();
        return dentistaDao.listarTodos();
    }
}
