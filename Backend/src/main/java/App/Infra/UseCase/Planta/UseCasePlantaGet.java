package App.Infra.UseCase.Planta;

import App.Domain.Response.Planta;
import App.Infra.Gateway.PlantaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCasePlantaGet {

    private final PlantaGateway plantaGateway;

    public UseCasePlantaGet(PlantaGateway plantaGateway) {
        this.plantaGateway = plantaGateway;
    }

    public ResponseEntity<List<Planta>> ListarPlantas()
    {return plantaGateway.ListarPlantas();}

    public ResponseEntity<List<Planta>> ListarPlantasGerminacao()
    {return plantaGateway.ListarPlantasGerminacao();}

    public ResponseEntity<List<Planta>> ListarPlantasMuda()
    {return plantaGateway.ListarPlantasMuda();}

    public ResponseEntity<List<Planta>> ListarPlantasCrescimento()
    {return plantaGateway.ListarPlantasCrescimento();}

    public ResponseEntity<List<Planta>> ListarPlantasFloracao()
    {return plantaGateway.ListarPlantasFloracao();}

    public ResponseEntity<List<Planta>> ListarPlantasFrutificacao()
    {return plantaGateway.ListarPlantasFrutificacao();}

    public ResponseEntity<List<Planta>> ListarPlantasMaturacao()
    {return plantaGateway.ListarPlantasMaturacao();}

    public ResponseEntity<List<Planta>> ListarPlantasFimCiclo()
    {return plantaGateway.ListarPlantasFimCiclo();}

    public ResponseEntity<Planta> BuscarPlantaPorId(@RequestParam Long id)
    {return plantaGateway.BuscarPlantaPorId(id);}
}
