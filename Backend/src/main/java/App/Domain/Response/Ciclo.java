package App.Domain.Response;

import App.Infra.Persistence.Enum.CICLO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Ciclo {

    private Long id;

    @Enumerated(EnumType.STRING)
    private CICLO ciclo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataUltimoCiclo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCicloAtual;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    private List<String> notificacoes;

    public Ciclo() {
    }

    public Ciclo(Long id, CICLO ciclo, LocalDate dataUltimoCiclo, LocalDate dataCicloAtual, LocalDateTime timeStamp, List<String> notificacoes) {
        this.id = id;
        this.ciclo = ciclo;
        this.dataUltimoCiclo = dataUltimoCiclo;
        this.dataCicloAtual = dataCicloAtual;
        this.timeStamp = timeStamp;
        this.notificacoes = notificacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CICLO getCiclo() {
        return ciclo;
    }

    public void setCiclo(CICLO ciclo) {
        this.ciclo = ciclo;
    }

    public LocalDate getDataUltimoCiclo() {
        return dataUltimoCiclo;
    }

    public void setDataUltimoCiclo(LocalDate dataUltimoCiclo) {
        this.dataUltimoCiclo = dataUltimoCiclo;
    }

    public LocalDate getDataCicloAtual() {
        return dataCicloAtual;
    }

    public void setDataCicloAtual(LocalDate dataCicloAtual) {
        this.dataCicloAtual = dataCicloAtual;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<String> notificacoes) {
        this.notificacoes = notificacoes;
    }
}
