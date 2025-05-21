package App.Infra.Mapper;

import App.Domain.Response.Fim;
import App.Domain.Response.Frutificacao;
import App.Infra.Persistence.Entity.FimEntity;
import App.Infra.Persistence.Entity.FrutificacaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FimCicloMapper {

    FimEntity DtoToEntity(Fim fim);

    Fim EntityToDto(FimEntity fimEntity);
}
