package App.Infra.Mapper;

import App.Domain.Response.Ciclo;
import App.Infra.Persistence.Entity.CicloEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CicloMapper {

    Ciclo EntityToDto(CicloEntity cicloEntity);

    CicloEntity DtoToEntity(Ciclo ciclo);
}
