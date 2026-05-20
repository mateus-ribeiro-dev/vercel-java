package br.com.dentalk.entities;

public class Atendimento {
    private String idConsulta;
    private String pacienteNome;
    private String data;
    private String horarioInicial;
    private String horarioFinal;
    private String procedimento;
    private String observacoes;
    private String pacientePresente;

//    private Paciente paciente;
//    private Dentista dentista;

    public Atendimento() {
    }

    public Atendimento(String idConsulta, String pacienteNome, String data, String horarioInicial, String horarioFinal, String procedimento, String observacoes, String pacientePresente) {
        this.idConsulta = idConsulta;
        this.pacienteNome = pacienteNome;
        this.data = data;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.procedimento = procedimento;
        this.observacoes = observacoes;
        this.pacientePresente = pacientePresente;
//        this.paciente = paciente;
//        this.dentista = dentista;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPacientePresente() {
        return pacientePresente;
    }

    public void setPacientePresente(String pacientePresente) {
        this.pacientePresente = pacientePresente;
    }

//    public Paciente getPaciente() {
//        return paciente;
//    }
//
//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    }
//
//    public Dentista getDentista() {
//        return dentista;
//    }
//
//    public void setDentista(Dentista dentista) {
//        this.dentista = dentista;
//    }
//
//    @Override
//    public String toString() {
//        return "\n\nInformações do atendimento" +
//                "\nData: " + data +
//                "\nHorario: " + horarioInicial +
//                "\nDescrição: " + procedimento +
//                (paciente != null ? "\nPaciente: " + paciente.getNomeCompleto() : "") + // Pega apenas o nome do paciente e não a classe inteira com todos os atributos
//                dentista;
//    }
//
//    // Metodo Worker de confirmação de atendimento
//    public String confirmarAtendimento() {
//        return "\nAtendimento do paciente " + paciente.getNomeCompleto() +
//                " registrado com o dentista " + dentista.getNomeCompleto() +
//                " no dia " + data + " às " + horarioInicial + ".";
//    }

}
