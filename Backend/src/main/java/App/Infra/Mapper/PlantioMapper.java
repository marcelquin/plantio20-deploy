package App.Infra.Mapper;

import App.Domain.Response.Area;
import App.Domain.Response.Plantio;
import App.Infra.Persistence.Entity.AreaEntity;
import App.Infra.Persistence.Entity.PlantioEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlantioMapper {

    PlantioEntity DtoToEntity(Plantio plantio);

    Plantio EntityToDto(PlantioEntity plantioEntity);

    List<Plantio> EntityListToDto(List<PlantioEntity> plantioEntities);

    List<PlantioEntity> DtoListToEntity(List<Plantio> plantios);
}
