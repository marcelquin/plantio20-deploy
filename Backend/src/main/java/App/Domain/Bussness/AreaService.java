package App.Domain.Bussness;

import App.Domain.Response.*;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.AreaGateway;
import App.Infra.Mapper.AreaMapper;
import App.Infra.Mapper.LinhaMapper;
import App.Infra.Mapper.LocalizacaoMapper;
import App.Infra.Mapper.PlantioMapper;
import App.Infra.Persistence.Entity.AreaEntity;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import App.Infra.Persistence.Entity.PlantioEntity;
import App.Infra.Persistence.Repository.AreaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService implements AreaGateway {

    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;
    private final LinhaService linhaService;
    private final LinhaMapper linhaMapper;
    private final PlantioService plantioService;
    private final PlantioMapper plantioMapper;
    private final LocalizacaoService localizacaoService;
    private final LocalizacaoMapper localizacaoMapper;

    public AreaService(AreaRepository areaRepository, AreaMapper areaMapper, LinhaService linhaService, LinhaMapper linhaMapper, PlantioService plantioService, PlantioMapper plantioMapper, LocalizacaoService localizacaoService, LocalizacaoMapper localizacaoMapper) {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
        this.linhaService = linhaService;
        this.linhaMapper = linhaMapper;
        this.plantioService = plantioService;
        this.plantioMapper = plantioMapper;
        this.localizacaoService = localizacaoService;
        this.localizacaoMapper = localizacaoMapper;
    }

    @Override
    public ResponseEntity<List<Area>> ListarAreas()
    {
        try
        {
            List<AreaEntity> list = areaRepository.findAll();
            List<Area> response = new ArrayList<>();
            for(AreaEntity entity : list)
            {
                Area area = areaMapper.EntityToDto(entity);
                response.add(area);
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
    public ResponseEntity<List<AreaPesquisaResponse>> ListarAreasPesquisa()
    {
        try
        {
            List<AreaEntity> list = areaRepository.findAll();
            List<AreaPesquisaResponse> response = new ArrayList<>();
            List<Plantio> plantios = new ArrayList<>();
            List<Linha> linhas = new ArrayList<>();
            List<Localizacao> localizacoes = new ArrayList<>();
            for(AreaEntity entity : list)
            {
                AreaPesquisaResponse dto = new AreaPesquisaResponse();
                dto.setId(entity.getId());
                dto.setGps(entity.getGps());
                dto.setDisponivel(entity.getDisponivel());
                dto.setNome(entity.getNome());
                dto.setDataCadastro(entity.getDataCadastro());
                dto.setDimensao(entity.getDimensao());
                plantios = plantioMapper.EntityListToDto(entity.getPlantios());
                for(Plantio plantioInterno : plantios)
                {
                    linhas.addAll(plantioInterno.getLinhas());
                }
                for(Linha linhaInterna : linhas)
                {
                    localizacoes.addAll(linhaInterna.getLocalizacoes());
                }
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
    public ResponseEntity<Area> BuscarAreaPorId(Long id)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            AreaEntity entity = areaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Area response = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> BuscarAreaPorNome(String nome)
    {
        try
        {
            if(nome == null){throw new NullargumentsException();}
            AreaEntity entity = areaRepository.findBynome(nome).orElseThrow(
                    EntityNotFoundException::new
            );
            Area response = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> NovaArea(String nome,
                                         String dimensao,
                                         String gps,
                                         int numeroPlantios,
                                         int numeroLinhas,
                                         int numeroLocalizacoes)
    {
        try
        {
            if(nome == null){throw new NullargumentsException();}
            if(dimensao == null){throw new NullargumentsException();}
            if(gps == null){throw new NullargumentsException();}
            if(numeroLinhas <= 0){throw new NullargumentsException();}
            if(numeroPlantios <= 0){throw new NullargumentsException();}
            if(numeroLocalizacoes <= 0){throw new NullargumentsException();}
            AreaEntity entity = new AreaEntity();
            entity.SetInfoInicial(nome,dimensao,gps);
            for(int i = 1; i<=numeroPlantios; i++)
            {
                Plantio plantio = plantioService.NovoPlantio(nome,numeroLinhas,i,numeroLocalizacoes).getBody();
                PlantioEntity plantioEntity = plantioMapper.DtoToEntity(plantio);
                entity.getPlantios().add(plantioEntity);
            }
            areaRepository.save(entity);
            Area response = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> EditarInformacoesArea(Long id,
                                                      String nome,
                                                      String dimensao,
                                                      String gps)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(nome == null){throw new NullargumentsException();}
            if(dimensao == null){throw new NullargumentsException();}
            if(gps == null){throw new NullargumentsException();}
            Area area = BuscarAreaPorId(id).getBody();
            AreaEntity entity = areaMapper.DtoToEntity(area);
            entity.EditInfol(nome,dimensao,gps);
            areaRepository.save(entity);
            area = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(area, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> AmpliarPlantio(Long id,int numeroPlantio, int numeroLinhas, int numeroLocalizacoes)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(numeroLinhas <= 0){throw new NullargumentsException();}
            if(numeroPlantio <= 0){throw new NullargumentsException();}
            if(numeroLocalizacoes <= 0){throw new NullargumentsException();}
            Area area = BuscarAreaPorId(id).getBody();
            for(Plantio plantio : area.getPlantios())
            {
                if(plantio.getLinhas().size() < numeroLinhas)
                {
                    int inicio = plantio.getLinhas().size() + 1;
                    int fim = numeroLinhas;
                    for( int i = inicio ; i<=fim;i++)
                    {
                        Linha linha = linhaService.NovaLinha(area.getNome(),i,numeroPlantio,numeroLocalizacoes).getBody();
                        plantio.getLinhas().add(linha);
                    }
                }
                for(Linha linha : plantio.getLinhas())
                {
                    if(linha.getLocalizacoes().size() < numeroLocalizacoes)
                    {
                        int inicio = linha.getLocalizacoes().size()+1;
                        int fim = numeroLocalizacoes;
                        for(int i = inicio; i<=fim;i++)
                        {
                            Localizacao localizacao = localizacaoService.NovaLocalizacao(area.getNome(),numeroLinhas,numeroPlantio,i).getBody();
                            linha.getLocalizacoes().add(localizacao);
                        }
                        linhaService.SalvarAlteracao(linha);
                    }
                }
            }
            if(area.getPlantios().size() < numeroPlantio)
            {
                List<Plantio> plantioEntities = new ArrayList<>();
                int j = area.getPlantios().size() + 1;
                for(int i = j; i<=numeroPlantio;i++)
                {
                    Plantio plantio = plantioService.NovoPlantio(area.getNome(),numeroLinhas, i,numeroLocalizacoes).getBody();
                    plantioEntities.add(plantio);
                }
                area.getPlantios().addAll(plantioEntities);
                area.setTimeStamp(LocalDateTime.now());
            }
            AreaEntity entity = areaMapper.DtoToEntity(area);
            areaRepository.save(entity);
            return new ResponseEntity<>(area, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Area> ReduzirPlantio(Long id,int numeroPlantio)
    {
        try
        {
            if(id == null){throw new NullargumentsException();}
            if(numeroPlantio <= 0){throw new NullargumentsException();}
            Area area = BuscarAreaPorId(id).getBody();
            AreaEntity entity = areaMapper.DtoToEntity(area);
            List<PlantioEntity> plantioEntities = new ArrayList<>();
            entity.setPlantios(plantioEntities);
            for(Plantio plantio : area.getPlantios())
            {
                if(plantio.getNumero() > numeroPlantio)
                {
                    plantioService.DeletarPlantio(plantio.getId());
                }
                else
                {
                    PlantioEntity plantioEntity = plantioMapper.DtoToEntity(plantio);
                    plantioEntities.add(plantioEntity);
                }
            }
            areaRepository.save(entity);
            area = areaMapper.EntityToDto(entity);
            return new ResponseEntity<>(area, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
