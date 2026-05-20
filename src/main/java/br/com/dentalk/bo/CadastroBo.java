package br.com.dentalk.bo;

import br.com.dentalk.dao.CadastroDao;
import br.com.dentalk.entities.Cadastro;


import java.sql.SQLException;

public class CadastroBo {

    CadastroDao cadastroDao;

    //Selecionar
    public Cadastro buscarPorId(String id) throws SQLException, ClassNotFoundException {
        cadastroDao = new CadastroDao();
        // regra de negócios
        return cadastroDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Cadastro cadastro) throws SQLException, ClassNotFoundException {
        CadastroDao cadastroDao = new CadastroDao();
        // regra de negócios
        cadastroDao.inserir(cadastro);
    }

    //atualizar
    public void atualizarBo(Cadastro cadastro) throws SQLException, ClassNotFoundException {
        cadastroDao = new CadastroDao();
        // regra de negócios
        cadastroDao.atualizar(cadastro);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        cadastroDao = new CadastroDao();
        // regra de negócios
        cadastroDao.deletar(id);
    }
}
