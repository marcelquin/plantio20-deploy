package App.Infra.Mapper;

import App.Domain.Response.Area;
import App.Domain.Response.Localizacao;
import App.Infra.Persistence.Entity.AreaEntity;
import App.Infra.Persistence.Entity.LocalizacaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocalizacaoMapper {

    LocalizacaoEntity DtoToEntity(Localizacao localizacao);
    Localizacao EntityToDto(LocalizacaoEntity localizacaoEntity);
}
