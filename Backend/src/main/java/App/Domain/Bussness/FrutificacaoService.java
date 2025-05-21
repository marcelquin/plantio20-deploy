package App.Domain.Bussness;

import App.Domain.Response.Floracao;
import App.Domain.Response.Frutificacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Mapper.FloracaoMapper;
import App.Infra.Mapper.FrutificacaoMapper;
import App.Infra.Persistence.Entity.FloracaoEntity;
import App.Infra.Persistence.Entity.FrutificacaoEntity;
import App.Infra.Persistence.Repository.FloracaoRepository;
import App.Infra.Persistence.Repository.FrutificacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FrutificacaoService {


    private final FrutificacaoRepository frutificacaoRepository;
    private final FrutificacaoMapper frutificacaoMapper;

    public FrutificacaoService(FrutificacaoRepository frutificacaoRepository, FrutificacaoMapper frutificacaoMapper) {
        this.frutificacaoRepository = frutificacaoRepository;
        this.frutificacaoMapper = frutificacaoMapper;
    }


    public ResponseEntity<Frutificacao> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            FrutificacaoEntity entity = frutificacaoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Frutificacao response = frutificacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Frutificacao> NovoCiclo()
    {
        try
        {
            FrutificacaoEntity entity = new FrutificacaoEntity();
            entity.SetinfoInicial();
            frutificacaoRepository.save(entity);
            Frutificacao response = frutificacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Frutificacao> AtualizarEntidadeInicio(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Frutificacao frutificacao = BuscarCorpoPorId(id).getBody();
            FrutificacaoEntity entity = frutificacaoMapper.DtoToEntity(frutificacao);
            entity.Setdados();
            frutificacaoRepository.save(entity);
            Frutificacao response = frutificacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Frutificacao> AtualizarEntidadeFim(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Frutificacao frutificacao = BuscarCorpoPorId(id).getBody();
            FrutificacaoEntity entity = frutificacaoMapper.DtoToEntity(frutificacao);
            entity.FimCiclo();
            frutificacaoRepository.save(entity);
            Frutificacao response = frutificacaoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> SalvarAlteracao(Frutificacao frutificacao)
    {
        try
        {
            FrutificacaoEntity entity = frutificacaoMapper.DtoToEntity(frutificacao);
            frutificacaoRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
