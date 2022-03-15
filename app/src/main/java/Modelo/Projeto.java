package Modelo;

public class Projeto {
    public int id;
    public String nome;
    public String dataInicio;
    public String dataFim;

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

    public String getDataInicio(){
        return dataInicio;
    }

    public void setDataInicio(String dataInicio){
        this.dataInicio = dataInicio;
    }

    public String getDataFim(){
        return dataFim;
    }

    public void setDataFim(String dataFim){
        this.dataFim = dataFim;
    }
}
