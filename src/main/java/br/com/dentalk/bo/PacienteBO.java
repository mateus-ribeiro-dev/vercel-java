package br.com.dentalk.bo;


import br.com.dentalk.dao.PacienteDao;
import br.com.dentalk.entities.Paciente;

import java.sql.SQLException;

public class PacienteBO {

    PacienteDao pacienteDao;

    //Selecionar
    public Paciente buscarPorId(String id) throws SQLException, ClassNotFoundException {
        pacienteDao = new PacienteDao();
        // regra de negócios
        return pacienteDao.selecionarPorId(id);
    }

    //inserir
    public static void insertBo(Paciente paciente) throws SQLException, ClassNotFoundException {
        PacienteDao pacienteDao = new PacienteDao();
        // regra de negócios
        pacienteDao.inserir(paciente);
    }

    //atualizar
    public void atualizarBo(Paciente paciente) throws SQLException, ClassNotFoundException {
        pacienteDao = new PacienteDao();
        // regra de negócios
        pacienteDao.atualizar(paciente);
    }

    //Deletar
    public void deletarBo(String id) throws SQLException, ClassNotFoundException {
        pacienteDao = new PacienteDao();
        // regra de negócios
        pacienteDao.deletar(id);
    }
}
