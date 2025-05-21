package App.Infra.Mapper;

import App.Domain.Response.Crecimento;
import App.Domain.Response.Muda;
import App.Infra.Persistence.Entity.CrecimentoEntity;
import App.Infra.Persistence.Entity.MudaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CrecimentoMapper {

    CrecimentoEntity DtoToEntity(Crecimento crecimento);

    Crecimento EntityToDto(CrecimentoEntity crecimentoEntity);
}
