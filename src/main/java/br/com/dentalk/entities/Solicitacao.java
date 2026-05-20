package br.com.dentalk.entities;

public class Solicitacao {
    private Long id;
    private String data;
    private String horario;
    private String descQueixa;
    private String status;
    private String prioridade;
    private Paciente paciente;
    private Colaborador colaborador;

    public Solicitacao() {}

    public Solicitacao(Long id, String data, String horario, String descQueixa, String status, String prioridade, Paciente paciente, Colaborador colaborador) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.descQueixa = descQueixa;
        this.status = status;
        this.prioridade = prioridade;
        this.paciente = paciente;
        this.colaborador = colaborador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescQueixa() {
        return descQueixa;
    }

    public void setDescQueixa(String descQueixa) {
        this.descQueixa = descQueixa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\nSolicitação de atendimento" +
                "\nData de solicitação: " + data +
                "\nHorário de solicitação: " + horario +
                "\nDescrição da queixa: " + descQueixa +
                "\nStatus atual do caso: " + status +
                "\nNível de prioridade: " + prioridade +
                (colaborador != null ? "\nColaborador responsável: " + colaborador.getNomeCompleto() : "") + // Pega apenas o nome do colaborador e não a classe inteira
                paciente;
    }

    // Metodo worker: Verifica o publico-alvo da ONG por meio de critérios já definidos
    public boolean verificarPublicoAlvo(Paciente paciente) {
        int idade = calcularIdade(paciente.getDataNascimento());

        boolean jovem = idade >= 11 && idade <= 17;
        boolean mulherVitima = paciente.getIdentidadeGenero().equalsIgnoreCase("Feminino");

        return jovem || mulherVitima;
    }

    // Calcula a idade do ano atual a fim de saber se o usuario está dentro dos criterios para participacao
    private int calcularIdade(String dataNascimento) {
        int anoNasc = Integer.parseInt(dataNascimento.substring(6)); // Considerando que o usuário digitará a formatação da data com os '/'
        int anoAtual = 2026;
        return anoAtual - anoNasc;
    }

}
