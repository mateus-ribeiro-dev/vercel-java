package br.com.dentalk.entities;

public class Ong {
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Colaborador colaborador;

    public Ong(Long id, String cnpj, String razaoSocial, String nomeFantasia, Colaborador colaborador) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.colaborador = colaborador;
    }

    public Ong() {

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\nInformações da ONG" +
                "\nCNPJ: " + cnpj +
                "\nRazão social: " + razaoSocial +
                "\nNome fantasia: " + nomeFantasia +
                colaborador;
    }
}
