package App.Api;

import App.Domain.Bussness.PlantioService;
import App.Domain.Response.Area;
import App.Domain.Response.Plantio;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("plantio")
@Tag(name = "Plantio", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class PlantioController {

    private final UseCasePlantioGet casePlantioGet;
    private final UseCasePlantioPut casePlantioPut;

    public PlantioController(UseCasePlantioGet casePlantioGet, UseCasePlantioPut casePlantioPut) {
        this.casePlantioGet = casePlantioGet;
        this.casePlantioPut = casePlantioPut;
    }


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantio")
    public ResponseEntity<List<Plantio>> ListarPlantio()
    {return casePlantioGet.ListarPlantio();}


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantioDisponiveis")
    public ResponseEntity<List<Plantio>> ListarPlantioDisponiveis()
    {return casePlantioGet.ListarPlantioDisponiveis();}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("ReduzirLinhas")
    public ResponseEntity<Plantio> ReduzirLinhas(@RequestParam Long id,
                                                 @RequestParam int numeroLinhas,
                                                 @RequestParam int numeroLocalizacoes)
    {return casePlantioPut.ReduzirLinhas(id, numeroLinhas, numeroLocalizacoes);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("NovaAdubacao")
    public ResponseEntity<Plantio> NovaAdubacao(@RequestParam Long id,
                                                @RequestParam String relatorio)
    {return casePlantioPut.NovaAdubacao(id, relatorio);}
}
