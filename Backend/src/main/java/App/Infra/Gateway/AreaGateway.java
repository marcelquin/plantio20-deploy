package App.Infra.Gateway;

import App.Domain.Response.Area;
import App.Domain.Response.AreaPesquisaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AreaGateway {

    public ResponseEntity<List<Area>> ListarAreas();

    public ResponseEntity<List<AreaPesquisaResponse>> ListarAreasPesquisa();

    public ResponseEntity<Area> BuscarAreaPorId(@RequestParam Long id);

    public ResponseEntity<Area> BuscarAreaPorNome(@RequestParam String nome);

    public ResponseEntity<Area> NovaArea(@RequestParam String nome,
                                         @RequestParam String dimensao,
                                         @RequestParam String gps,
                                         @RequestParam int numeroPlantios,
                                         @RequestParam int numeroLinhas,
                                         @RequestParam int numeroLocalizacoes);

    public ResponseEntity<Area> EditarInformacoesArea(@RequestParam Long id,
                                                      @RequestParam String nome,
                                                      @RequestParam String dimensao,
                                                      @RequestParam String gps);

    public ResponseEntity<Area> AmpliarPlantio(@RequestParam Long id,
                                               @RequestParam int numeroPlantio,
                                               @RequestParam int numeroLinhas,
                                               @RequestParam int numeroLocalizacoes);

    public ResponseEntity<Area> ReduzirPlantio(@RequestParam Long id,
                                               @RequestParam int numeroPlantio);
}
