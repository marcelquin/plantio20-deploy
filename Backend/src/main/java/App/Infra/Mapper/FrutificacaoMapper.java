package App.Infra.Mapper;

import App.Domain.Response.Floracao;
import App.Domain.Response.Frutificacao;
import App.Infra.Persistence.Entity.FloracaoEntity;
import App.Infra.Persistence.Entity.FrutificacaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FrutificacaoMapper {

    FrutificacaoEntity DtoToEntity(Frutificacao frutificacao);

    Frutificacao EntityToDto(FrutificacaoEntity frutificacaoEntity);
}
