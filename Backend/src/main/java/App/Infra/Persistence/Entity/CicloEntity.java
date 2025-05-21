package App.Infra.Persistence.Entity;

import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Persistence.Enum.CICLO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ciclo")
public class CicloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CICLO ciclo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataUltimoCiclo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCicloAtual;

    @OneToOne
    @JoinColumn(name = "germinacaoEntity_id", referencedColumnName = "id")
    private GerminacaoEntity germinacao;

    @OneToOne
    @JoinColumn(name = "mudaEntity_id", referencedColumnName = "id")
    private MudaEntity muda;

    @OneToOne
    @JoinColumn(name = "crecimentoEntity_id", referencedColumnName = "id")
    private CrecimentoEntity crecimento;

    @OneToOne
    @JoinColumn(name = "floracaoEntity_id", referencedColumnName = "id")
    private FloracaoEntity floracao;

    @OneToOne
    @JoinColumn(name = "frutificacaoEntity_id", referencedColumnName = "id")
    private FrutificacaoEntity frutificacao;

    @OneToOne
    @JoinColumn(name = "maturacaoEntity_id", referencedColumnName = "id")
    private MaturacaoEntity maturacao;

    @OneToOne
    @JoinColumn(name = "fimEntity_id", referencedColumnName = "id")
    private FimEntity fim;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime timeStamp;

    private List<String> notificacoes;

    public CicloEntity() {
    }

    public CicloEntity(Long id, CICLO ciclo, LocalDate dataUltimoCiclo, LocalDate dataCicloAtual, GerminacaoEntity germinacao, MudaEntity muda, CrecimentoEntity crecimento, FloracaoEntity floracao, FrutificacaoEntity frutificacao, MaturacaoEntity maturacao, FimEntity fim, LocalDateTime timeStamp, List<String> notificacoes) {
        this.id = id;
        this.ciclo = ciclo;
        this.dataUltimoCiclo = dataUltimoCiclo;
        this.dataCicloAtual = dataCicloAtual;
        this.germinacao = germinacao;
        this.muda = muda;
        this.crecimento = crecimento;
        this.floracao = floracao;
        this.frutificacao = frutificacao;
        this.maturacao = maturacao;
        this.fim = fim;
        this.timeStamp = timeStamp;
        this.notificacoes = notificacoes;
    }

    public GerminacaoEntity getGerminacao() {
        return germinacao;
    }

    public void setGerminacao(GerminacaoEntity germinacao) {
        this.germinacao = germinacao;
    }

    public MudaEntity getMuda() {
        return muda;
    }

    public void setMuda(MudaEntity muda) {
        this.muda = muda;
    }

    public CrecimentoEntity getCrecimento() {
        return crecimento;
    }

    public void setCrecimento(CrecimentoEntity crecimento) {
        this.crecimento = crecimento;
    }

    public FloracaoEntity getFloracao() {
        return floracao;
    }

    public void setFloracao(FloracaoEntity floracao) {
        this.floracao = floracao;
    }

    public FrutificacaoEntity getFrutificacao() {
        return frutificacao;
    }

    public void setFrutificacao(FrutificacaoEntity frutificacao) {
        this.frutificacao = frutificacao;
    }

    public MaturacaoEntity getMaturacao() {
        return maturacao;
    }

    public void setMaturacao(MaturacaoEntity maturacao) {
        this.maturacao = maturacao;
    }

    public FimEntity getFim() {
        return fim;
    }

    public void setFim(FimEntity fim) {
        this.fim = fim;
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

    public void SetInfo(GerminacaoEntity germinacaoEntity,
                        MudaEntity mudaEntity,
                        CrecimentoEntity crecimentoEntity,
                        FloracaoEntity floracaoEntity,
                        FrutificacaoEntity frutificacaoEntity,
                        MaturacaoEntity maturacaoEntity,
                        FimEntity fimEntity)
    {
        List<String>list = new ArrayList<>();
        this.notificacoes = list;
        this.ciclo = CICLO.GERMINACAO;
        this.dataCicloAtual = LocalDate.now();
        this.timeStamp = LocalDateTime.now();
        this.germinacao = germinacaoEntity;
        this.muda = mudaEntity;
        this.crecimento = crecimentoEntity;
        this.floracao = floracaoEntity;
        this.frutificacao = frutificacaoEntity;
        this.maturacao = maturacaoEntity;
        this.fim = fimEntity;
    }

    public Boolean ValidaCiclo(CICLO ciclo)
    {
        if(this.ciclo.equals(CICLO.GERMINACAO) && ciclo != CICLO.MUDA){return Boolean.FALSE;}
        if(this.ciclo.equals(CICLO.MUDA) && ciclo != CICLO.CRESCIMENTO){return Boolean.FALSE;}
        if(this.ciclo.equals(CICLO.CRESCIMENTO) && ciclo == CICLO.MUDA){return Boolean.FALSE;}
        if(this.ciclo.equals(CICLO.CRESCIMENTO) && ciclo == CICLO.GERMINACAO){return Boolean.FALSE;}
        if(ciclo.equals(CICLO.GERMINACAO) && this.dataUltimoCiclo != null){return Boolean.FALSE;}
        if(ciclo.equals(this.ciclo)){return Boolean.FALSE;}
        return Boolean.TRUE;
    }

    public void FimCiclo(FimEntity fim)
    {
        List<String>list = new ArrayList<>();
        this.dataCicloAtual = null;
        this.dataUltimoCiclo = null;
        this.ciclo = CICLO.FIM;
        this.notificacoes = list;
        this.timeStamp = LocalDateTime.now();
    }

    public void SetNovoCiclo(CICLO ciclo)
    {
        this.ciclo = ciclo;
        this.dataUltimoCiclo = this.dataCicloAtual;
        this.dataCicloAtual = LocalDate.now();
        this.timeStamp = LocalDateTime.now();
    }

    public CICLO retornaCicloAnterior(CICLO novoCiclo)
    {
        if(ciclo.equals(CICLO.MUDA))
        {
            return CICLO.GERMINACAO;
        }
        if(ciclo.equals(CICLO.CRESCIMENTO))
        {
            return CICLO.MUDA;
        }
        if(ciclo.equals(CICLO.FLORACAO))
        {
            return CICLO.CRESCIMENTO;
        }
        if(ciclo.equals(CICLO.FRUTIFICACAO))
        {
            return CICLO.FLORACAO;
        }
        if(ciclo.equals(CICLO.MATURACAO))
        {
            return CICLO.FRUTIFICACAO;
        }
        if(ciclo.equals(CICLO.FIM))
        {
            return CICLO.FRUTIFICACAO;
        }
        return this.ciclo;
    }

}
