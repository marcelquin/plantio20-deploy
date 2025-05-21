package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Area")
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(unique = true)
    private String nome;

    private String dimensao;

    private String gps;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    private Boolean disponivel;

    @OneToMany
    private List<PlantioEntity> plantios;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public AreaEntity() {
    }

    public AreaEntity(Long id, String nome, String dimensao, String gps, LocalDate dataCadastro, Boolean disponivel, List<PlantioEntity> plantios, LocalDateTime timeStamp) {
        this.id = id;
        this.nome = nome;
        this.dimensao = dimensao;
        this.gps = gps;
        this.dataCadastro = dataCadastro;
        this.disponivel = disponivel;
        this.plantios = plantios;
        this.timeStamp = timeStamp;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
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

    public List<PlantioEntity> getPlantios() {
        return plantios;
    }

    public void setPlantios(List<PlantioEntity> plantios) {
        this.plantios = plantios;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void SetInfoInicial(String nome, String dimensao, String gps)
    {
        List<PlantioEntity> list = new ArrayList<>();
        this.plantios = list;
        this.gps = gps;
        this.nome = nome;
        this.dimensao = dimensao;
        this.disponivel = Boolean.TRUE;
        this.dataCadastro = LocalDate.now();
        this.timeStamp = LocalDateTime.now();
    }

    public void EditInfol(String nome, String dimensao, String gps)
    {
        this.gps = gps;
        this.nome = nome;
        this.dimensao = dimensao;
        this.timeStamp = LocalDateTime.now();
    }


}
