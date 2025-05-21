package App.Infra.UseCase.Plantio;

import App.Domain.Response.Plantio;
import App.Infra.Gateway.PlantioGateway;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UseCasePlantioGet {

    private final PlantioGateway plantioGateway;

    public UseCasePlantioGet(PlantioGateway plantioGateway) {
        this.plantioGateway = plantioGateway;
    }

    public ResponseEntity<List<Plantio>> ListarPlantio()
    {return plantioGateway.ListarPlantio();}


    public ResponseEntity<List<Plantio>> ListarPlantioDisponiveis()
    { return plantioGateway.ListarPlantioDisponiveis();}


}
