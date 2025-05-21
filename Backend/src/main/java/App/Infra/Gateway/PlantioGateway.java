package App.Infra.Gateway;

import App.Domain.Response.Plantio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlantioGateway {

    public ResponseEntity<List<Plantio>> ListarPlantio();

    public ResponseEntity<List<Plantio>> ListarPlantioDisponiveis();

    public ResponseEntity<Plantio> ReduzirLinhas(@RequestParam Long id,
                                                 @RequestParam int numeroLinhas,
                                                 @RequestParam int numeroLocalizacoes);

    public ResponseEntity<Plantio> NovaAdubacao(@RequestParam Long id,
                                                @RequestParam String relatorio);
}
