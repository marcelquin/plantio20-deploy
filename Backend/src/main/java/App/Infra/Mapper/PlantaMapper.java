package App.Infra.Mapper;

import App.Domain.Response.Planta;
import App.Infra.Persistence.Entity.PlantaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantaMapper {

    PlantaEntity DtoToEntity(Planta planta);

    Planta EntityToDto(PlantaEntity plantaEntity);
}
