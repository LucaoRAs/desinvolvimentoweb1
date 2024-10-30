package org.trabalho;

public class Marca {
    private int id;
    private String nome;
    private String descricao;
    private String paisOrigem;
    private int anoFundacao;
    private String website;

    // Construtor Padrão
    public Marca() {}

    // Construtor com parâmetros
    public Marca(int id, String nome, String descricao, String paisOrigem, int anoFundacao, String website) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.paisOrigem = paisOrigem;
        this.anoFundacao = anoFundacao;
        this.website = website;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Marca [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", paisOrigem=" + paisOrigem
                + ", anoFundacao=" + anoFundacao + ", website=" + website + "]";
    }
}
