package App.Infra.Mapper;

import App.Domain.Response.Germinacao;
import App.Infra.Persistence.Entity.GerminacaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GerminacaoMapper {

    GerminacaoEntity DtoToEntity(Germinacao germinacao);

    Germinacao EntityToDto(GerminacaoEntity germinacaoEntity);
}
