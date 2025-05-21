package App.Infra.UseCase.Area;

import App.Domain.Response.Area;
import App.Domain.Response.AreaPesquisaResponse;
import App.Infra.Gateway.AreaGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseAreaGet {

    private final AreaGateway areaGateway;

    public UseCaseAreaGet(AreaGateway areaGateway) {
        this.areaGateway = areaGateway;
    }

    public ResponseEntity<List<Area>> ListarAreas()
    {return areaGateway.ListarAreas();}

    public ResponseEntity<List<AreaPesquisaResponse>> ListarAreasPesquisa()
    {return areaGateway.ListarAreasPesquisa();}

    public ResponseEntity<Area> BuscarAreaPorId(@RequestParam Long id)
    {return areaGateway.BuscarAreaPorId(id);}

    public ResponseEntity<Area> BuscarAreaPorNome(@RequestParam String nome)
    {return areaGateway.BuscarAreaPorNome(nome);}

}
