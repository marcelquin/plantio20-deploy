package App.Domain.Bussness;

import App.Domain.Response.Crecimento;
import App.Domain.Response.Germinacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Mapper.CrecimentoMapper;
import App.Infra.Mapper.GerminacaoMapper;
import App.Infra.Persistence.Entity.CrecimentoEntity;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import App.Infra.Persistence.Repository.CrecimentoRepository;
import App.Infra.Persistence.Repository.GerminacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CrecimentoService {


    private final CrecimentoRepository crecimentoRepository;
    private final CrecimentoMapper crecimentoMapper;

    public CrecimentoService(CrecimentoRepository crecimentoRepository, CrecimentoMapper crecimentoMapper) {
        this.crecimentoRepository = crecimentoRepository;
        this.crecimentoMapper = crecimentoMapper;
    }

    public ResponseEntity<Crecimento> BuscarCorpoPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            CrecimentoEntity entity = crecimentoRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Crecimento response = crecimentoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Crecimento> NovoCiclo()
    {
        try
        {
            CrecimentoEntity entity = new CrecimentoEntity();
            entity.SetinfoInicial();
            crecimentoRepository.save(entity);
            Crecimento response = crecimentoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Crecimento> AtualizarEntidadeInicio(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Crecimento crecimento = BuscarCorpoPorId(id).getBody();
            CrecimentoEntity entity = crecimentoMapper.DtoToEntity(crecimento);
            entity.Setdados();
            crecimentoRepository.save(entity);
            Crecimento response = crecimentoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Crecimento> AtualizarEntidadeFim(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            Crecimento crecimento = BuscarCorpoPorId(id).getBody();
            CrecimentoEntity entity = crecimentoMapper.DtoToEntity(crecimento);
            entity.FimCiclo();
            crecimentoRepository.save(entity);
            Crecimento response = crecimentoMapper.EntityToDto(entity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> SalvarAlteracao(Crecimento crecimento)
    {
        try
        {
            CrecimentoEntity entity = crecimentoMapper.DtoToEntity(crecimento);
            crecimentoRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
