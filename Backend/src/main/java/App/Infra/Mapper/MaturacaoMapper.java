package App.Infra.Mapper;

import App.Domain.Response.Frutificacao;
import App.Domain.Response.Maturacao;
import App.Infra.Persistence.Entity.FrutificacaoEntity;
import App.Infra.Persistence.Entity.MaturacaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaturacaoMapper {

    MaturacaoEntity DtoToEntity(Maturacao maturacao);

    Maturacao EntityToDto(MaturacaoEntity maturacaoEntity);
}
