package App.Infra.Persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Linha")
public class LinhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numero;

    private Boolean disponivel;

    @OneToMany
    private List<LocalizacaoEntity> localizacoes;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    public LinhaEntity() {
    }

    public LinhaEntity(Long id, int numero, Boolean disponivel, List<LocalizacaoEntity> localizacoes, LocalDateTime timeStamp) {
        this.id = id;
        this.numero = numero;
        this.disponivel = disponivel;
        this.localizacoes = localizacoes;
        this.timeStamp = timeStamp;
    }

    public List<LocalizacaoEntity> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<LocalizacaoEntity> localizacoes) {
        this.localizacoes = localizacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public void SetInfoInicial(int numero)
    {
        this.localizacoes = new ArrayList<>();
        this.disponivel = Boolean.TRUE;
        this.timeStamp = LocalDateTime.now();
        this.numero = numero;
    }



}
