package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Plantio")
public class PlantioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numero;

    @OneToMany
    private List<LinhaEntity> linhas;

    private Boolean disponivel;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate DataAdubacao;

    private List<String> notificacoes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public PlantioEntity() {
    }

    public PlantioEntity(Long id, int numero, List<LinhaEntity> linhas, Boolean disponivel, LocalDate dataAdubacao, List<String> notificacoes, LocalDateTime timeStamp) {
        this.id = id;
        this.numero = numero;
        this.linhas = linhas;
        this.disponivel = disponivel;
        DataAdubacao = dataAdubacao;
        this.notificacoes = notificacoes;
        this.timeStamp = timeStamp;
    }

    public LocalDate getDataAdubacao() {
        return DataAdubacao;
    }

    public void setDataAdubacao(LocalDate dataAdubacao) {
        DataAdubacao = dataAdubacao;
    }

    public List<String> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<String> notificacoes) {
        this.notificacoes = notificacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LinhaEntity> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<LinhaEntity> linhas) {
        this.linhas = linhas;
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

    public void SetInfoInicial(List<LinhaEntity> linhas, int numero)
    {
        List<LinhaEntity> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        this.notificacoes = list1;
        this.linhas = list;
        this.numero = numero;
        this.disponivel = Boolean.TRUE;
        this.timeStamp = LocalDateTime.now();
        this.linhas.addAll(linhas);
    }

    public void SetNovaAdubacao(String relatorio)
    {
        this.notificacoes.add(relatorio);
        this.timeStamp = LocalDateTime.now();
        this.setDataAdubacao(LocalDate.now());
    }
}
