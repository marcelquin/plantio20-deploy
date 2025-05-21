package App.Domain.Bussness;

import App.Domain.Response.*;
import App.Infra.Exceptions.EntityNotFoundException;
import App.Infra.Exceptions.IllegalActionException;
import App.Infra.Exceptions.NullargumentsException;
import App.Infra.Gateway.PlantaGateway;
import App.Infra.Mapper.*;
import App.Infra.Persistence.Entity.*;
import App.Infra.Persistence.Enum.CICLO;
import App.Infra.Persistence.Repository.PlantaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static App.Infra.Persistence.Enum.CICLO.*;

@Service
public class PlantaService implements PlantaGateway {

    private final PlantaRepository plantaRepository;
    private final PlantaMapper plantaMapper;
    private final PlantioService plantioService;
    private final PlantioMapper plantioMapper;
    private final CicloMapper cicloMapper;
    private final CicloService cicloService;
    private final LocalizacaoMapper localizacaoMapper;
    private final LocalizacaoService localizacaoService;

    public PlantaService(PlantaRepository plantaRepository, PlantaMapper plantaMapper, PlantioService plantioService, PlantioMapper plantioMapper, CicloMapper cicloMapper, CicloService cicloService, LocalizacaoMapper localizacaoMapper, LocalizacaoService localizacaoService) {
        this.plantaRepository = plantaRepository;
        this.plantaMapper = plantaMapper;
        this.plantioService = plantioService;
        this.plantioMapper = plantioMapper;
        this.cicloMapper = cicloMapper;
        this.cicloService = cicloService;
        this.localizacaoMapper = localizacaoMapper;
        this.localizacaoService = localizacaoService;
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantas()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                Planta dto = plantaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Planta>> ListarPlantasGerminacao()
        {
            try
            {
                List<PlantaEntity> plantaEntities = plantaRepository.findAll();
                List<Planta> response = new ArrayList<>();
                for(PlantaEntity entity : plantaEntities)
                {
                    if (entity.getCiclo().getCiclo().equals(GERMINACAO))
                    {
                        Planta dto = plantaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Planta>> ListarPlantasMuda()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(MUDA))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
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
    public ResponseEntity<List<Planta>> ListarPlantasCrescimento()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(CRESCIMENTO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasFloracao()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(FLORACAO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasFrutificacao()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(FRUTIFICACAO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasMaturacao()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(MATURACAO))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Planta>> ListarPlantasFimCiclo()
    {
        try
        {
            List<PlantaEntity> plantaEntities = plantaRepository.findAll();
            List<Planta> response = new ArrayList<>();
            for(PlantaEntity entity : plantaEntities)
            {
                if (entity.getCiclo().getCiclo().equals(FIM))
                {
                    Planta dto = plantaMapper.EntityToDto(entity);
                    response.add(dto);
                }
            }
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> BuscarPlantaPorId(Long id)
    {
        try
        {
            if(id == null) {throw new NullargumentsException();}
            PlantaEntity entity = plantaRepository.findById(id).orElseThrow(
                    EntityNotFoundException::new
            );
            Planta response = plantaMapper.EntityToDto(entity);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @Override
    public ResponseEntity<Planta> NovaPlanta(Long localizacaoId, String nomeCientifico, String nomePopular, String instrucoes)
    {
        try
        {
            if(nomeCientifico == null){throw new NullargumentsException();}
            if(nomePopular == null){throw new NullargumentsException();}
            if(instrucoes == null){throw new NullargumentsException();}
            if(localizacaoId == null){throw new NullargumentsException();}
            PlantaEntity entity = new PlantaEntity();
            Ciclo ciclo = cicloService.NovoCiclo().getBody();
            cicloService.AlterarCiclo(ciclo.getId(),CICLO.GERMINACAO);
            CicloEntity cicloEntity = cicloMapper.DtoToEntity(ciclo);
            entity.setCiclo(cicloEntity);
            Localizacao localizacao = localizacaoService.BuscarLocalizacaoPorId(localizacaoId).getBody();
            LocalizacaoEntity localizacaoEntity = localizacaoMapper.DtoToEntity(localizacao);
            entity.setLocalizacao(localizacaoEntity);
            localizacaoEntity.SetPlanta();
            Localizacao localizacaoRequest = localizacaoMapper.EntityToDto(localizacaoEntity);
            localizacaoService.SalvarAlteracao(localizacaoRequest);
            entity.SetInfo(nomePopular,nomeCientifico,instrucoes);
            plantaRepository.save(entity);
            Planta response = plantaMapper.EntityToDto(entity);
            return  new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> EditarPlanta(Long plantaId, String nomeCientifico, String nomePopular,String instrucoes)
    {
        try
        {
            if(plantaId != null && nomePopular != null && nomeCientifico != null)
            {
                Planta planta = BuscarPlantaPorId(plantaId).getBody();
                PlantaEntity entity = plantaMapper.DtoToEntity(planta);
                entity.EditInfo(nomePopular,nomeCientifico,instrucoes);
                plantaRepository.save(entity);
                return new ResponseEntity<>(planta, HttpStatus.OK);
            }
            else {throw new NullargumentsException();}
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> AlterarCiclo(Long id, String ciclo)
    {
        try
        {
            if(id != null)
            {
                Planta planta = BuscarPlantaPorId(id).getBody();
                PlantaEntity entity = plantaMapper.DtoToEntity(planta);
                CICLO cicloConvertido = RetornaCicloAtual(ciclo);
                cicloService.AlterarCiclo(entity.getCiclo().getId(), cicloConvertido);
                if(cicloConvertido.equals(FIM))
                {
                    Localizacao localizacao = localizacaoService.BuscarLocalizacaoPorId(entity.getLocalizacao().getId()).getBody();
                    localizacao.setDisponivel(Boolean.TRUE);
                    localizacao.setTimeStamp(LocalDateTime.now());
                    localizacaoService.SalvarAlteracao(localizacao);
                    entity.FimCiclo();
                }
                plantaRepository.save(entity);
                Planta response = plantaMapper.EntityToDto(entity);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else {throw new NullargumentsException();}
        } catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public CICLO RetornaCicloAtual(String ciclo)
    {
        try
        {
            if(ciclo.equals("GERMINACAO"))
            { return GERMINACAO;}
            if(ciclo.equals("MUDA"))
            { return MUDA;}
            if(ciclo.equals("CRESCIMENTO"))
            { return CRESCIMENTO;}
            if(ciclo.equals("FLORACAO"))
            { return FLORACAO;}
            if(ciclo.equals("FRUTIFICACAO"))
            { return FRUTIFICACAO;}
            if(ciclo.equals("MATURACAO"))
            { return MATURACAO;}
            if(ciclo.equals("FIM"))
            { return FIM;}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    public ResponseEntity<Void> SalvarAlteracao(Planta planta)
    {
        try
        {
            if(planta != null)
            {
                PlantaEntity entity = plantaMapper.DtoToEntity(planta);
                plantaRepository.save(entity);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Planta> AlterarLocalizacao(Long plantaId, Long localizacaoId)
    {
        try
        {
            if(plantaId != null)
            {
               if(localizacaoId < 0L){throw new IllegalActionException();}
               if(plantaId != null)
               {
                   Planta planta = BuscarPlantaPorId(plantaId).getBody();
                   PlantaEntity entity = plantaMapper.DtoToEntity(planta);
                   if(entity.getLocalizacao() != null)
                   {
                       Localizacao localizacao = localizacaoService.BuscarLocalizacaoPorId(entity.getLocalizacao().getId()).getBody();
                       LocalizacaoEntity localizacaoEntity = localizacaoMapper.DtoToEntity(localizacao);
                       localizacaoEntity.setDisponivel(Boolean.TRUE);
                       localizacao = localizacaoMapper.EntityToDto(localizacaoEntity);
                       localizacaoService.SalvarAlteracao(localizacao);
                       //entity.setBloco(null);
                   }
                   if(localizacaoId > 0L)
                   {
                        Localizacao novaLocalizacao = localizacaoService.BuscarLocalizacaoPorId(localizacaoId).getBody();
                        LocalizacaoEntity novaLocalizacaoEntity = localizacaoMapper.DtoToEntity(novaLocalizacao);
                        Localizacao localizacaoRequest = localizacaoMapper.EntityToDto(novaLocalizacaoEntity);
                        localizacaoService.SalvarAlteracao(localizacaoRequest);
                        entity.setLocalizacao(novaLocalizacaoEntity);
                        entity.setTimeStamp(LocalDateTime.now());
                        plantaRepository.save(entity);
                        planta = plantaMapper.EntityToDto(entity);

                   }
                   return new ResponseEntity<>(planta, HttpStatus.OK);
               }
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
