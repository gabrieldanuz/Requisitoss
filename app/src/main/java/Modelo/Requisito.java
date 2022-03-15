package Modelo;

public class Requisito {

    public int id;
    public String descricao;
    public String dataRegistro;
    public String duracao;
    public String nivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getdataRegistro(){
        return dataRegistro;
    }

    public void setdataRegistro(String dataRegistro){
        this.dataRegistro = dataRegistro;
    }

    public String getDuracao(){
        return duracao;
    }

    public void setDuracao(String duracao){
        this.duracao = duracao;
    }

    public String getNivel(){
        return nivel;
    }

    public void setNivel(String nivel){
        this.nivel = nivel;
    }
}
