package App.Domain.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class AreaPesquisaResponse {

    private Long id;

    private String nome;

    private String dimensao;

    private String gps;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    private Boolean disponivel;

    private List<Plantio> plantios;

    private List<Linha> linhas;

    private List<Localizacao> localizacoes;

    public AreaPesquisaResponse() {
    }

    public AreaPesquisaResponse(Long id, String nome, String dimensao, String gps, LocalDate dataCadastro, Boolean disponivel, List<Plantio> plantios, List<Linha> linhas, List<Localizacao> localizacoes) {
        this.id = id;
        this.nome = nome;
        this.dimensao = dimensao;
        this.gps = gps;
        this.dataCadastro = dataCadastro;
        this.disponivel = disponivel;
        this.plantios = plantios;
        this.linhas = linhas;
        this.localizacoes = localizacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Plantio> getPlantios() {
        return plantios;
    }

    public void setPlantios(List<Plantio> plantios) {
        this.plantios = plantios;
    }

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
        this.linhas = linhas;
    }

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<Localizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }
}
