package br.com.dentalk.entities;

public class Dentista {
    private Long id;
    private String nomeCompleto;
    private String dataNascimento;
    private String identidadeGenero;
    private String cpf;
    private String cro;
    private String especialidade;

    public Dentista() {}

    public Dentista(Long id, String nomeCompleto, String dataNascimento, String identidadeGenero, String cpf, String cro, String especialidade) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.identidadeGenero = identidadeGenero;
        this.cpf = cpf;
        this.cro = cro;
        this.especialidade = especialidade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getIdentidadeGenero() {
        return identidadeGenero;
    }

    public void setIdentidadeGenero(String identidadeGenero) {
        this.identidadeGenero = identidadeGenero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\nInformações do dentista" +
                "\nNome completo: " + nomeCompleto +
                "\nData de nascimento: " + dataNascimento +
                "\nIdentidade de gênero: " + identidadeGenero +
                "\nCPF: " + cpf +
                "\nCRO: " + cro +
                "\nEspecialidade: " + especialidade;
    }
}
