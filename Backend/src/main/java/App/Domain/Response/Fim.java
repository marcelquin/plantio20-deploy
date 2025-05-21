package App.Domain.Response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fim {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCiclo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public Fim() {
    }

    public Fim(Long id, LocalDate dataCiclo, LocalDateTime timeStamp) {
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
}
