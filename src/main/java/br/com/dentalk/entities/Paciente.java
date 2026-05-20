package br.com.dentalk.entities;

public class Paciente {
    private Long id;
    private String cpf;
    private String nomeCompleto;
    private String nomeSocial;
    private String dataNascimento;
    private String identidadeGenero;
    private String nomeMae;
    private String nomePai;
    private String nacionalidade;
    private String rg;
    private Endereco endereco;
    private Contato contato;
    private Prontuario prontuario;

    public Paciente() {}

    public Paciente(Long id, String cpf, String nomeCompleto, String nomeSocial, String dataNascimento, String identidadeGenero, String nomeMae, String nomePai, String nacionalidade, String rg, Endereco endereco, Contato contato, Prontuario prontuario) {
        this.id = id;
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.dataNascimento = dataNascimento;
        this.identidadeGenero = identidadeGenero;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.nacionalidade = nacionalidade;
        this.rg = rg;
        this.endereco = endereco;
        this.contato = contato;
        this.prontuario = prontuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\nInformações do paciente" +
                "\nCPF: " + cpf +
                "\nRG: " + rg +
                "\nNome completo: " + nomeCompleto +
                "\nNome social: " + nomeSocial +
                "\nData de nascimento: " + dataNascimento +
                "\nIdentidade de gênero: " + identidadeGenero +
                "\nNome da mãe: " + nomeMae +
                "\nNome do pai: " + nomePai +
                "\nNacionalidade: " + nacionalidade +
                endereco +
                contato +
                prontuario;
    }
}