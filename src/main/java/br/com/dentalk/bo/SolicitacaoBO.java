package br.com.dentalk.bo;

import br.com.dentalk.dao.SolicitacaoDao;
import br.com.dentalk.entities.Solicitacao;

import java.sql.SQLException;
import java.util.List;

public class SolicitacaoBO {

    SolicitacaoDao solicitacaoDao;

    //Selecionar
    public Solicitacao buscarPorId(String id) throws SQLException, ClassNotFoundException {
        solicitacaoDao = new SolicitacaoDao();
        // regra de negócios
        return solicitacaoDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        SolicitacaoDao contatoDao = new SolicitacaoDao();
        // regra de negócios
        contatoDao.inserir(solicitacao);
    }

    //atualizar
    public void atualizarBo(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
        solicitacaoDao = new SolicitacaoDao();
        // regra de negócios
        solicitacaoDao.atualizar(solicitacao);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        solicitacaoDao = new SolicitacaoDao();
        // regra de negócios
        solicitacaoDao.deletar(id);
    }

    // selecionar todos
    public List<Solicitacao> listarTodosBo() throws SQLException, ClassNotFoundException {
        solicitacaoDao = new SolicitacaoDao();
        return solicitacaoDao.listarTodos();
    }
}
