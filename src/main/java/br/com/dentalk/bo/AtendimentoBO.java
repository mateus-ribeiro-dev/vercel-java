package br.com.dentalk.bo;

import br.com.dentalk.dao.AtendimentoDao;
import br.com.dentalk.entities.Atendimento;

import java.sql.SQLException;
import java.util.List;

public class AtendimentoBO {

    AtendimentoDao atendimentoDao;

    //Selecionar
    public Atendimento buscarPorId(String id) throws SQLException, ClassNotFoundException {
        atendimentoDao = new AtendimentoDao();
        // regra de negócios
        return atendimentoDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        // regra de negócios
        atendimentoDao.inserir(atendimento);
    }

    //atualizar
    public void atualizarBo(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        atendimentoDao = new AtendimentoDao();
        // regra de negócios
        atendimentoDao.atualizar(atendimento);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        atendimentoDao = new AtendimentoDao();
        // regra de negócios
        atendimentoDao.deletar(id);
    }

    // selecionar todos
    public List<Atendimento> listarTodosBo() throws SQLException, ClassNotFoundException {
        atendimentoDao = new AtendimentoDao();
        return atendimentoDao.listarTodos();
    }
}
