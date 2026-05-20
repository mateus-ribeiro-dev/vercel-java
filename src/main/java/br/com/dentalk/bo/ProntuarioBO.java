package br.com.dentalk.bo;

import br.com.dentalk.dao.ProntuarioDao;
import br.com.dentalk.entities.Prontuario;

import java.sql.SQLException;

public class ProntuarioBO {
    ProntuarioDao prontuarioDao;

    //Selecionar
    public Prontuario buscarPorId(String id) throws SQLException, ClassNotFoundException {
        prontuarioDao = new ProntuarioDao();
        // regra de negócios
        return prontuarioDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Prontuario prontuario) throws SQLException, ClassNotFoundException {
        ProntuarioDao prontuarioDao = new ProntuarioDao();
        // regra de negócios
        prontuarioDao.inserir(prontuario);
    }

    //atualizar
    public void atualizarBo(Prontuario prontuario) throws SQLException, ClassNotFoundException {
        prontuarioDao = new ProntuarioDao();
        // regra de negócios
        prontuarioDao.atualizar(prontuario);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        prontuarioDao = new ProntuarioDao();
        // regra de negócios
        prontuarioDao.deletar(id);
    }
}
