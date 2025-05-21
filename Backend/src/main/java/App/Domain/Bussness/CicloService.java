package App.Domain.Bussness;

import App.Domain.Response.*;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Mapper.*;
import App.Infra.Persistence.Entity.*;
import App.Infra.Persistence.Enum.CICLO;
import App.Infra.Persistence.Repository.CicloRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static App.Infra.Persistence.Enum.CICLO.*;

@Service
public class CicloService {

    private final CicloRepository cicloRepository;
    private final CicloMapper cicloMapper;
    private final GerminacaoService germinacaoService;
    private final MudaService mudaService;
    private final CrecimentoService crecimentoService;
    private final FloracaoService floracaoService;
    private final FrutificacaoService frutificacaoService;
    private final MaturacaoService maturacaoService;
    private final FimCicloService fimCicloService;
    private final GerminacaoMapper germinacaoMapper;
    private final MudaMapper mudaMapper;
    private final CrecimentoMapper crecimentoMapper;
    private final FloracaoMapper floracaoMapper;
    private final FrutificacaoMapper frutificacaoMapper;
    private final MaturacaoMapper maturacaoMapper;
    private final FimCicloMapper fimCicloMapper;

    public CicloService(CicloRepository cicloRepository, CicloMapper cicloMapper, GerminacaoService germinacaoService, MudaService mudaService, CrecimentoService crecimentoService, FloracaoService floracaoService, FrutificacaoService frutificacaoService, MaturacaoService maturacaoService, FimCicloService fimCicloService, GerminacaoMapper germinacaoMapper, MudaMapper mudaMapper, CrecimentoMapper crecimentoMapper, FloracaoMapper floracaoMapper, FrutificacaoMapper frutificacaoMapper, MaturacaoMapper maturacaoMapper, FimCicloMapper fimCicloMapper) {
        this.cicloRepository = cicloRepository;
        this.cicloMapper = cicloMapper;
        this.germinacaoService = germinacaoService;
        this.mudaService = mudaService;
        this.crecimentoService = crecimentoService;
        this.floracaoService = floracaoService;
        this.frutificacaoService = frutificacaoService;
        this.maturacaoService = maturacaoService;
        this.fimCicloService = fimCicloService;
        this.germinacaoMapper = germinacaoMapper;
        this.mudaMapper = mudaMapper;
        this.crecimentoMapper = crecimentoMapper;
        this.floracaoMapper = floracaoMapper;
        this.frutificacaoMapper = frutificacaoMapper;
        this.maturacaoMapper = maturacaoMapper;
        this.fimCicloMapper = fimCicloMapper;
    }


    public ResponseEntity<Ciclo> BuscarCicloPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            CicloEntity entity = cicloRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Ciclo response = cicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Ciclo> NovoCiclo()
    {
        try
        {
            CicloEntity entity = new CicloEntity();
            Germinacao germinacao = germinacaoService.NovoCiclo().getBody();
            Muda muda = mudaService.NovoCiclo().getBody();
            Crecimento crecimento = crecimentoService.NovoCiclo().getBody();
            Floracao floracao = floracaoService.NovoCiclo().getBody();
            Frutificacao frutificacao = frutificacaoService.NovoCiclo().getBody();
            Maturacao maturacao = maturacaoService.NovoCiclo().getBody();
            Fim fim = fimCicloService.NovoCiclo().getBody();
            GerminacaoEntity germinacaoEntity = germinacaoMapper.DtoToEntity(germinacao);
            MudaEntity mudaEntity = mudaMapper.DtoToEntity(muda);
            CrecimentoEntity crecimentoEntity = crecimentoMapper.DtoToEntity(crecimento);
            FloracaoEntity floracaoEntity = floracaoMapper.DtoToEntity(floracao);
            FrutificacaoEntity frutificacaoEntity = frutificacaoMapper.DtoToEntity(frutificacao);
            MaturacaoEntity maturacaoEntity = maturacaoMapper.DtoToEntity(maturacao);
            FimEntity fimEntity = fimCicloMapper.DtoToEntity(fim);
            entity.SetInfo(germinacaoEntity,mudaEntity,crecimentoEntity,floracaoEntity,frutificacaoEntity,maturacaoEntity,fimEntity);
            cicloRepository.save(entity);
            Ciclo response = cicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Ciclo> AlterarCiclo(Long id, CICLO ciclo)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(ciclo == null){throw new NullargumentsException();}
            CicloEntity entity = cicloRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Boolean valida = entity.ValidaCiclo(ciclo);
            if(valida.equals(Boolean.FALSE)){throw new IllegalActionException();}
            if(ciclo.equals(MUDA))
            {
              germinacaoService.AtualizarEntidadeFim(entity.getGerminacao().getId());
              mudaService.AtualizarEntidadeInicio(entity.getMuda().getId());
            }
            if(ciclo.equals(CRESCIMENTO))
            {
                mudaService.AtualizarEntidadeFim(entity.getMuda().getId());
                crecimentoService.AtualizarEntidadeInicio(entity.getCrecimento().getId());
            }
            if(ciclo.equals(FLORACAO))
            {
              crecimentoService.AtualizarEntidadeFim(entity.getCrecimento().getId());
              floracaoService.AtualizarEntidadeInicio(entity.getFloracao().getId());
            }
            if(ciclo.equals(FRUTIFICACAO))
            {
              floracaoService.AtualizarEntidadeFim(entity.getFloracao().getId());
              frutificacaoService.AtualizarEntidadeInicio(entity.getFrutificacao().getId());
            }
            if(ciclo.equals(MATURACAO))
            {
                frutificacaoService.AtualizarEntidadeFim(entity.getFrutificacao().getId());
                maturacaoService.AtualizarEntidadeInicio(entity.getMaturacao().getId());
            }
            if(ciclo.equals(FIM))
            {
                if(ciclo.equals(MUDA))
                {
                    mudaService.AtualizarEntidadeFim(entity.getMuda().getId());
                }
                if(ciclo.equals(CRESCIMENTO))
                {
                    crecimentoService.AtualizarEntidadeFim(entity.getCrecimento().getId());
                }
                if(ciclo.equals(FLORACAO))
                {
                    floracaoService.AtualizarEntidadeFim(entity.getFloracao().getId());
                }
                if(ciclo.equals(FRUTIFICACAO))
                {
                    frutificacaoService.AtualizarEntidadeFim(entity.getFrutificacao().getId());
                }
                if(ciclo.equals(MATURACAO))
                {
                    maturacaoService.AtualizarEntidadeFim(entity.getMaturacao().getId());
                }
                Fim fim = fimCicloService.BuscarCorpoPorId(entity.getFim().getId()).getBody();

            }
            entity.SetNovoCiclo(ciclo);
            cicloRepository.save(entity);
            Ciclo response = cicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Ciclo> SalvarAlteracao(Ciclo ciclo)
    {
        try
        {
            if(ciclo != null)
            {
                CicloEntity entity = cicloMapper.DtoToEntity(ciclo);
                cicloRepository.save(entity);
                Ciclo response = cicloMapper.EntityToDto(entity);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
