package App.Domain.Bussness;

import App.Domain.Response.Area;
import App.Domain.Response.Linha;
import App.Domain.Response.Plantio;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.AreaGateway;
import App.Infra.Gateway.PlantioGateway;
import App.Infra.Mapper.LinhaMapper;
import App.Infra.Mapper.PlantioMapper;
import App.Infra.Persistence.Entity.AreaEntity;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.PlantioEntity;
import App.Infra.Persistence.Repository.PlantioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantioService implements PlantioGateway {

    private final PlantioRepository plantioRepository;
    private final PlantioMapper plantioMapper;
    private final LinhaService linhaService;
    private final LinhaMapper linhaMapper;


    public PlantioService(PlantioRepository plantioRepository, PlantioMapper plantioMapper, LinhaService linhaService, LinhaMapper linhaMapper) {
        this.plantioRepository = plantioRepository;
        this.plantioMapper = plantioMapper;
        this.linhaService = linhaService;
        this.linhaMapper = linhaMapper;
    }

    @Override
    public ResponseEntity<List<Plantio>> ListarPlantio()
    {
        try
        {
            List<PlantioEntity> entities = plantioRepository.findAll();
            List<Plantio> response = new ArrayList<>();
            for(PlantioEntity entity : entities)
            {
                    Plantio dto = plantioMapper.EntityToDto(entity);
                    response.add(dto);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Plantio>> ListarPlantioDisponiveis()
    {
        try
        {
            List<PlantioEntity> entities = plantioRepository.findAll();
            List<Plantio> response = new ArrayList<>();
            for(PlantioEntity entity : entities)
            {
                if(entity.getDisponivel().equals(Boolean.TRUE))
                {
                    Plantio dto = plantioMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Plantio> BuscarPlantioPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            PlantioEntity entity = plantioRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Plantio response = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    public ResponseEntity<Plantio> NovoPlantio(String area,int numeroLinhas, int numeroPlantio, int numeroLocalizacoes)
    {
        try
        {
            if(numeroLinhas <= 0){throw new NullargumentsException();}
            if(numeroPlantio <= 0){throw new NullargumentsException();}
            if(numeroLocalizacoes <= 0){throw new NullargumentsException();}
            PlantioEntity entity = new PlantioEntity();
            List<LinhaEntity> linhas = new ArrayList<>();
            for(int i = 1 ; i <= numeroLinhas; i++)
            {
                Linha linha = linhaService.NovaLinha(area,i, numeroPlantio,numeroLocalizacoes).getBody();
                LinhaEntity linhaEntity = linhaMapper.DtoToEntity(linha);
                linhas.add(linhaEntity);
            }
            entity.SetInfoInicial(linhas, numeroPlantio);
            plantioRepository.save(entity);
            Plantio response = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Plantio> ReduzirLinhas(Long id, int numeroLinhas, int numeroLocalizacoes)
    {
        try
        {
            if(id == null){{throw new NullargumentsException();}}
            if(numeroLinhas <= 0){{throw new NullargumentsException();}}
            if(numeroLocalizacoes <= 0){{throw new NullargumentsException();}}
            Plantio plantio = BuscarPlantioPorId(id).getBody();
            List<LinhaEntity> novaLista = new ArrayList<>();
            PlantioEntity entity = plantioMapper.DtoToEntity(plantio);
            entity.setLinhas(novaLista);
            List<Linha> listaAtual = plantio.getLinhas();
            if(plantio.getLinhas().size() > numeroLinhas)
            {
                for (Linha linha : plantio.getLinhas())
                {
                    Linha linha1 = linhaService.reduzirLocalizacoes(linha.getId(),numeroLocalizacoes).getBody();
                    if (linha.getNumero() > numeroLinhas)
                    {
                        linhaService.DeletarLinhaPorId(linha.getId());
                    }
                    else
                    {
                        LinhaEntity linhaEntity = linhaMapper.DtoToEntity(linha1);
                        novaLista.add(linhaEntity);
                    }
                }
                plantioRepository.save(entity);
            }
            plantio = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(plantio, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> DeletarPlantio(Long id)
    {
        try
        {
            if(id == null) {throw new NullargumentsException();}
            Plantio plantio = BuscarPlantioPorId(id).getBody();
            PlantioEntity entity = plantioMapper.DtoToEntity(plantio);
            List<LinhaEntity> novaLista = new ArrayList<>();
            entity.setLinhas(novaLista);
            plantioRepository.save(entity);
            for(Linha linha : plantio.getLinhas())
            {
                linhaService.DeletarLinhaPorId(linha.getId());
            }
            plantioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Plantio> NovaAdubacao(Long id, String relatorio)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(relatorio == null){throw new NullargumentsException();}
            Plantio plantio = BuscarPlantioPorId(id).getBody();
            PlantioEntity entity = plantioMapper.DtoToEntity(plantio);
            entity.SetNovaAdubacao(relatorio);
            plantioRepository.save(entity);
            plantio = plantioMapper.EntityToDto(entity);
            return new ResponseEntity<>(plantio,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
