package App.Infra.Mapper;

import App.Domain.Response.Area;
import App.Infra.Persistence.Entity.AreaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    @Mapping(target = "plantios", source = "plantios")
    AreaEntity DtoToEntity(Area area);

    @Mapping(target = "plantios", source = "plantios")
    Area EntityToDto(AreaEntity areaEntity);
}
