package br.com.dentalk.entities;

public class Prontuario {
    private Long id;
    private String diagnosticoCid;
    private String procedimento;
    private String observacao;
    private String statusEvolucao;
    private Atendimento atendimento;

    public Prontuario() {}

    public Prontuario(Long id, String diagnosticoCid, String procedimento, String observacao, String statusEvolucao, Atendimento atendimento) {
        this.id = id;
        this.diagnosticoCid = diagnosticoCid;
        this.procedimento = procedimento;
        this.observacao = observacao;
        this.statusEvolucao = statusEvolucao;
        this.atendimento = atendimento;
    }

    public String getDiagnosticoCid() {
        return diagnosticoCid;
    }

    public void setDiagnosticoCid(String diagnosticoCid) {
        this.diagnosticoCid = diagnosticoCid;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatusEvolucao() {
        return statusEvolucao;
    }

    public void setStatusEvolucao(String statusEvolucao) {
        this.statusEvolucao = statusEvolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\nProntuário do paciente" +
                "\nCID de diagnóstico: " + diagnosticoCid +
                "\nProcedimento: " + procedimento +
                "\nObservação? " + observacao +
                "\nStatus de evolução do paciente: " + statusEvolucao +
                atendimento;
    }
}
