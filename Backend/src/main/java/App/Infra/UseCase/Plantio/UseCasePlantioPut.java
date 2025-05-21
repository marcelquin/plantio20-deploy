package App.Infra.UseCase.Plantio;

import App.Domain.Response.Plantio;
import App.Infra.Gateway.PlantioGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePlantioPut {

    private final PlantioGateway plantioGateway;

    public UseCasePlantioPut(PlantioGateway plantioGateway) {
        this.plantioGateway = plantioGateway;
    }

    public ResponseEntity<Plantio> ReduzirLinhas(@RequestParam Long id,
                                                 @RequestParam int numeroLinhas,
                                                 @RequestParam int numeroLocalizacoes)
    {return plantioGateway.ReduzirLinhas(id, numeroLinhas, numeroLocalizacoes);}

    public ResponseEntity<Plantio> NovaAdubacao(@RequestParam Long id,
                                                @RequestParam String relatorio)
    {return plantioGateway.NovaAdubacao(id, relatorio);}

}
