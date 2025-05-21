package App.Domain.Bussness;

import App.Domain.Response.Fim;
import App.Domain.Response.Floracao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Mapper.FimCicloMapper;
import App.Infra.Persistence.Entity.FimEntity;
import App.Infra.Persistence.Entity.FloracaoEntity;
import App.Infra.Persistence.Repository.FimRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FimCicloService {

    private final FimRepository fimRepository;
    private final FimCicloMapper fimCicloMapper;

    public FimCicloService(FimRepository fimRepository, FimCicloMapper fimCicloMapper) {
        this.fimRepository = fimRepository;
        this.fimCicloMapper = fimCicloMapper;
    }

    public ResponseEntity<Fim> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            FimEntity entity = fimRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Fim response = fimCicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Fim> NovoCiclo()
    {
        try
        {
            FimEntity entity = new FimEntity();
            entity.Setinfo();
            fimRepository.save(entity);
            Fim response = fimCicloMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void>AtualizarEntidade(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Fim fim = BuscarCorpoPorId(id).getBody();
            FimEntity fimEntity = fimCicloMapper.DtoToEntity(fim);
            fimEntity.SetDados();
            fimRepository.save(fimEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
