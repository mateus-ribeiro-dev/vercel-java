package br.com.dentalk.bo;

import br.com.dentalk.dao.ColaboradorDao;
import br.com.dentalk.entities.Colaborador;

import java.sql.SQLException;

public class ColaboradorBO {

    ColaboradorDao colaboradorDao;

    //Selecionar
    public Colaborador buscarPorId(String id) throws SQLException, ClassNotFoundException {
        colaboradorDao = new ColaboradorDao();
        // regra de negócios
        return colaboradorDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        ColaboradorDao colaboradorDao = new ColaboradorDao();
        // regra de negócios
        colaboradorDao.inserir(colaborador);
    }

    //atualizar
    public void atualizarBo(Colaborador colaborador) throws SQLException, ClassNotFoundException {
        colaboradorDao = new ColaboradorDao();
        // regra de negócios
        colaboradorDao.atualizar(colaborador);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        colaboradorDao = new ColaboradorDao();
        // regra de negócios
        colaboradorDao.deletar(id);
    }
}
