package App.Domain.Response;

import App.Infra.Persistence.Entity.PlantioEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Area {

    private Long id;

    private String nome;

    private String dimensao;

    private String gps;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    private Boolean disponivel;

    private List<Plantio> plantios;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Area() {
    }

    public Area(Long id, String nome, String dimensao, String gps, LocalDate dataCadastro, Boolean disponivel, List<Plantio> plantios, LocalDateTime timeStamp) {
        this.id = id;
        this.nome = nome;
        this.dimensao = dimensao;
        this.gps = gps;
        this.dataCadastro = dataCadastro;
        this.disponivel = disponivel;
        this.plantios = plantios;
        this.timeStamp = timeStamp;
    }

    public List<Plantio> getPlantios() {
        return plantios;
    }

    public void setPlantios(List<Plantio> plantios) {
        this.plantios = plantios;
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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
