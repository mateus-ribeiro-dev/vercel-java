package br.com.dentalk.entities;

public class Colaborador {
    private Long id;
    private String registroColab;
    private String nomeCompleto;
    private String dataNascimento;
    private String cargo;

    //public Colaborador() {}


    public Colaborador() {
    }

    public Colaborador(Long id, String registroColab, String nomeCompleto, String dataNascimento, String cargo) {
        this.id = id;
        this.registroColab = registroColab;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cargo = cargo;
    }

    public String getRegistroColab() {
        return registroColab;
    }

    public void setregistroColab(String registroColab) {
        this.registroColab = registroColab;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "\n\nInformações do colaborador" +
                "\nRegistro do colaborador: " + registroColab +
                "\nNome completo: " + nomeCompleto +
                "\nData de nascimento: " + dataNascimento +
                "\nCargo: " + cargo;
    }
}
