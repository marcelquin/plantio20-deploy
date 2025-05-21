package App.Infra.Mapper;

import App.Domain.Response.Germinacao;
import App.Domain.Response.Muda;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import App.Infra.Persistence.Entity.MudaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MudaMapper {

    MudaEntity DtoToEntity(Muda muda);

    Muda EntityToDto(MudaEntity mudaEntity);
}
