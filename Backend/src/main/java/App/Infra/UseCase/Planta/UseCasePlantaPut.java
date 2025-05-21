package App.Infra.UseCase.Planta;

import App.Domain.Response.Planta;
import App.Infra.Gateway.PlantaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePlantaPut {

    private final PlantaGateway plantaGateway;

    public UseCasePlantaPut(PlantaGateway plantaGateway) {
        this.plantaGateway = plantaGateway;
    }

    public ResponseEntity<Planta> EditarPlanta(@RequestParam Long plantaId,
                                               @RequestParam String nomeCientifico,
                                               @RequestParam String nomePopular,
                                               @RequestParam String instrucoes)
    {return plantaGateway.EditarPlanta(plantaId, nomeCientifico, nomePopular, instrucoes);}

    public ResponseEntity<Planta> AlterarCiclo(@RequestParam Long id,
                                               @RequestParam String ciclo)
    {return plantaGateway.AlterarCiclo(id, ciclo);}

    public ResponseEntity<Planta> AlterarLocalizacao(@RequestParam Long plantaId,
                                                     @RequestParam Long localizacaoId)
    {return plantaGateway.AlterarLocalizacao(plantaId, localizacaoId);}

}
