package App.Domain.Bussness;

import App.Domain.Response.Localizacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.LocalizacaoGateway;
import App.Infra.Mapper.LocalizacaoMapper;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import App.Infra.Persistence.Repository.LocalizacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocalizacaoService implements LocalizacaoGateway {

    private final LocalizacaoRepository localizacaoRepository;
    private final LocalizacaoMapper localizacaoMapper;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository, LocalizacaoMapper localizacaoMapper) {
        this.localizacaoRepository = localizacaoRepository;
        this.localizacaoMapper = localizacaoMapper;
    }

    public ResponseEntity<List<Localizacao>> ListarLocalizacoes()
    {
        try
        {
            List<LocalizacaoEntity> localizacaoEntities = localizacaoRepository.findAll();
            List<Localizacao> response = new ArrayList<>();
            for(LocalizacaoEntity entity : localizacaoEntities)
            {
                Localizacao dto = localizacaoMapper.EntityToDto(entity);
                response.add(dto);
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis()
    {
        try
        {
            List<LocalizacaoEntity> localizacaoEntities = localizacaoRepository.findAll();
            List<Localizacao> response = new ArrayList<>();
            for(LocalizacaoEntity entity : localizacaoEntities)
            {
                if(entity.getDisponivel().equals(Boolean.TRUE))
                {
                    Localizacao dto = localizacaoMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis()
    {
        try
        {
            List<LocalizacaoEntity> localizacaoEntities = localizacaoRepository.findAll();
            List<Localizacao> response = new ArrayList<>();
            for(LocalizacaoEntity entity : localizacaoEntities)
            {
                if(entity.getDisponivel().equals(Boolean.FALSE))
                {
                    Localizacao dto = localizacaoMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Localizacao> BuscarLocalizacaoPorId(Long id)
    {
        try
        {
            if(id == null) {throw new NullargumentsException();}
            LocalizacaoEntity entity = localizacaoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Localizacao response = localizacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Localizacao> BuscarLocalizacaoPorReferencia(String referencia)
    {
        try
        {
            if(referencia == null) {throw new NullargumentsException();}
            LocalizacaoEntity entity = localizacaoRepository.findByreferencia(referencia).orElseThrow(
                    EntityNotFoundException::new
            );
            Localizacao response = localizacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Localizacao> NovaLocalizacao(String area, int numeroLinha, int numeroPlantio, int referencia)
    {
        try
        {
            if(area == null){throw new NullargumentsException();}
            if(numeroLinha <=0){throw new NullargumentsException();}
            if(referencia <=0){throw new NullargumentsException();}
            if(numeroPlantio <=0){throw new NullargumentsException();}
            LocalizacaoEntity entity = new LocalizacaoEntity();
            entity.SetInfoInicial(area, numeroPlantio, numeroLinha,referencia);
            localizacaoRepository.save(entity);
            Localizacao response = localizacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Localizacao> EditarLocalizacao(Long id, String area, int numeroLinha)
    {
        try
        {
            if(area == null){throw new NullargumentsException();}
            if(numeroLinha <=0){throw new NullargumentsException();}
            if(id == null){throw new NullargumentsException();}
            Localizacao localizacao = BuscarLocalizacaoPorId(id).getBody();
            localizacao.setNomeArea(area);
            localizacao.setTimeStamp(LocalDateTime.now());
            LocalizacaoEntity entity = localizacaoMapper.DtoToEntity(localizacao);
            localizacaoRepository.save(entity);
            return new ResponseEntity<>(localizacao, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> SalvarAlteracao(Localizacao localizacao)
    {
        try
        {
            if(localizacao == null){throw new NullargumentsException();}
            LocalizacaoEntity entity = localizacaoMapper.DtoToEntity(localizacao);
            localizacaoRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Localizacao> DeletarLocalizacaoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            localizacaoRepository.deleteById(id);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
