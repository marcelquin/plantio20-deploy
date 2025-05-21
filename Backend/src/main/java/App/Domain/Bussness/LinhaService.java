package App.Domain.Bussness;

import App.Domain.Response.Linha;
import App.Domain.Response.Localizacao;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.LinhaGateway;
import App.Infra.Mapper.LinhaMapper;
import App.Infra.Mapper.LocalizacaoMapper;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import App.Infra.Persistence.Repository.LinhaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinhaService implements LinhaGateway {


    private final LinhaRepository linhaRepository;
    private final LinhaMapper linhaMapper;
    private final LocalizacaoService localizacaoService;
    private final LocalizacaoMapper localizacaoMapper;

    public LinhaService(LinhaRepository linhaRepository, LinhaMapper linhaMapper, LocalizacaoService localizacaoService, LocalizacaoMapper localizacaoMapper) {
        this.linhaRepository = linhaRepository;
        this.linhaMapper = linhaMapper;
        this.localizacaoService = localizacaoService;
        this.localizacaoMapper = localizacaoMapper;
    }

    @Override
    public ResponseEntity<List<Linha>> ListarLinhas()
    {
        try
        {
            List<LinhaEntity> entities = linhaRepository.findAll();
            List<Linha> response = new ArrayList<>();
            for(LinhaEntity entity : entities)
            {
                Linha dto = linhaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Linha>> ListarLinhasDisponiveis()
    {
        try
        {
            List<LinhaEntity> entities = linhaRepository.findAll();
            List<Linha> response = new ArrayList<>();
            for(LinhaEntity entity : entities)
            {
                if(entity.getDisponivel().equals(Boolean.TRUE))
                {
                    Linha dto = linhaMapper.EntityToDto(entity);
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

    public ResponseEntity<Linha> BuscarLinhaPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            LinhaEntity entity = linhaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Linha response = linhaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Linha> NovaLinha(String area,int numero, int numeroPlantio, int numeroLocalizacoes)
    {
        try
        {
            if(numero <= 0) {throw new NullargumentsException();}
            LinhaEntity entity = new LinhaEntity();
            List<LocalizacaoEntity> localizacaoEntities = new ArrayList<>();
            entity.SetInfoInicial(numero);
            for(int i = 1 ; i<=numeroLocalizacoes; i++)
            {
                Localizacao localizacao = localizacaoService.NovaLocalizacao(area,numero,numeroPlantio,i).getBody();
                LocalizacaoEntity localizacaoEntity = localizacaoMapper.DtoToEntity(localizacao);
                entity.getLocalizacoes().add(localizacaoEntity);
            }
            entity.getLocalizacoes().addAll(localizacaoEntities);
            linhaRepository.save(entity);
            Linha response = linhaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Linha> DeletarLinhaPorId(Long id)
    {
        try
        {
            if(id == null) {throw new NullargumentsException();}
            linhaRepository.deleteById(id);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Linha> reduzirLocalizacoes(Long id, int numeroLocalizacoes)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(numeroLocalizacoes <= 0){throw new NullargumentsException();}
            Linha linha = BuscarLinhaPorId(id).getBody();
            List<LocalizacaoEntity> localizacaoEntities = new ArrayList<>();
            LinhaEntity entity = linhaMapper.DtoToEntity(linha);
            entity.setLocalizacoes(localizacaoEntities);
            linhaRepository.save(entity);
            for(Localizacao localizacao : linha.getLocalizacoes())
            {
                String input = localizacao.getReferencia();
                String[] parts = input.split("_");
                String[] subParts = parts[1].split("-");
                String part2 = subParts[0]; // "1"
                String part3 = subParts[1];
                int locAtual = Integer.parseInt(part3);
                if(locAtual > numeroLocalizacoes)
                {
                    localizacaoService.DeletarLocalizacaoPorId(localizacao.getId());
                }
                else
                {
                    LocalizacaoEntity localizacaoEntity = localizacaoMapper.DtoToEntity(localizacao);
                    entity.getLocalizacoes().add(localizacaoEntity);
                }
            }
            linhaRepository.saveAndFlush(entity);
            Linha response = linhaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Void> SalvarAlteracao(Linha linha)
    {
        try
        {
            if(linha == null){throw new NullargumentsException();}
            LinhaEntity entity = linhaMapper.DtoToEntity(linha);
            linhaRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
