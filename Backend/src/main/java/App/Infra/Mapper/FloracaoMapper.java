package App.Infra.Mapper;

import App.Domain.Response.Floracao;
import App.Domain.Response.Muda;
import App.Infra.Persistence.Entity.FloracaoEntity;
import App.Infra.Persistence.Entity.MudaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FloracaoMapper {

    FloracaoEntity DtoToEntity(Floracao floracao);

    Floracao EntityToDto(FloracaoEntity floracaoEntity);
}
