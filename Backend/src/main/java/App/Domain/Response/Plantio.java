package App.Domain.Response;

import App.Infra.Persistence.Entity.LinhaEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Plantio {

    private Long id;

    private int numero;

    private List<Linha> linhas;

    private Boolean disponivel;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate DataAdubacao;

    private List<String> notificacoes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Plantio() {
    }

    public Plantio(Long id, int numero, List<Linha> linhas, Boolean disponivel, LocalDate dataAdubacao, List<String> notificacoes, LocalDateTime timeStamp) {
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

    public List<Linha> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<Linha> linhas) {
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
}
