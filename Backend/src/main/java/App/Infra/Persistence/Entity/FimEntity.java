package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Fim")
public class FimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCiclo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public FimEntity() {
    }

    public FimEntity(Long id, LocalDate dataCiclo, LocalDateTime timeStamp) {
        this.id = id;
        this.dataCiclo = dataCiclo;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCiclo() {
        return dataCiclo;
    }

    public void setDataCiclo(LocalDate dataCiclo) {
        this.dataCiclo = dataCiclo;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void Setinfo()
    {
        this.timeStamp = LocalDateTime.now();
    }

    public void SetDados()
    {
        this.timeStamp = LocalDateTime.now();
        this.dataCiclo = LocalDate.now();
    }

}
