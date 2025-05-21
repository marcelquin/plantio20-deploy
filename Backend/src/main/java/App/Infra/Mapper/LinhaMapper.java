package App.Infra.Mapper;

import App.Domain.Response.Linha;
import App.Domain.Response.Plantio;
import App.Infra.Persistence.Entity.LinhaEntity;
import App.Infra.Persistence.Entity.PlantioEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LinhaMapper {

    LinhaEntity DtoToEntity(Linha linha);

    Linha EntityToDto(LinhaEntity linhaEntity);

    List<Linha> EntityListToDto(List<LinhaEntity> linhaEntities);

    List<LinhaEntity> DtoListToEntity(List<Linha> linhas);

}
