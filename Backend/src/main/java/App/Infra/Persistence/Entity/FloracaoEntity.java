package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Floracao")
public class FloracaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFim;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public FloracaoEntity() {
    }

    public FloracaoEntity(Long id, LocalDate dataInicio, LocalDate dataFim, LocalDateTime timeStamp) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void SetinfoInicial()
    {
        this.timeStamp = LocalDateTime.now();
    }

    public void Setdados()
    {
        this.timeStamp = LocalDateTime.now();
        this.dataInicio = LocalDate.now();
    }

    public void FimCiclo()
    {
        this.timeStamp = LocalDateTime.now();
        this.dataFim = LocalDate.now();
    }
}
