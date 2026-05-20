package br.com.dentalk.bo;

import br.com.dentalk.dao.OngDao;
import br.com.dentalk.entities.Ong;

import java.sql.SQLException;

public class OngBO {

    OngDao ongDao;

    //Selecionar
    public Ong buscarPorId(String id) throws SQLException, ClassNotFoundException {
        ongDao = new OngDao();
        // regra de negócios
        return ongDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Ong ong) throws SQLException, ClassNotFoundException {
        OngDao ongDao = new OngDao();
        // regra de negócios
        ongDao.inserir(ong);
    }

    //atualizar
    public void atualizarBo(Ong ong) throws SQLException, ClassNotFoundException {
        ongDao = new OngDao();
        // regra de negócios
        ongDao.atualizar(ong);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        ongDao = new OngDao();
        // regra de negócios
        ongDao.deletar(id);
    }
}
