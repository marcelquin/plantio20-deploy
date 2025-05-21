package App.Api;

import App.Domain.Bussness.AreaService;
import App.Domain.Response.Area;
import App.Domain.Response.AreaPesquisaResponse;
import App.Infra.UseCase.Area.UseCaseAreaGet;
import App.Infra.UseCase.Area.UseCaseAreaPost;
import App.Infra.UseCase.Area.UseCaseAreaPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("area")
@Tag(name = "Area", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class AreaController {

    private final UseCaseAreaPost caseAreaPost;
    private final UseCaseAreaPut caseAreaPut;
    private final UseCaseAreaGet caseAreaGet;

    public AreaController(UseCaseAreaPost caseAreaPost, UseCaseAreaPut caseAreaPut, UseCaseAreaGet caseAreaGet) {
        this.caseAreaPost = caseAreaPost;
        this.caseAreaPut = caseAreaPut;
        this.caseAreaGet = caseAreaGet;
    }


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarAreas")
    public ResponseEntity<List<Area>> ListarAreas()
    {return caseAreaGet.ListarAreas();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarAreasPesquisa")
    public ResponseEntity<List<AreaPesquisaResponse>> ListarAreasPesquisa()
    {return caseAreaGet.ListarAreasPesquisa();}

    @Operation(summary = "Busca Registro da tabela por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("BuscarAreaPorId")
    public ResponseEntity<Area> BuscarAreaPorId(@RequestParam Long id)
    {return caseAreaGet.BuscarAreaPorId(id);}

    @Operation(summary = "Busca Registro da tabela por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("BuscarAreaPorNome")
    public ResponseEntity<Area> BuscarAreaPorNome(@RequestParam String nome)
    {return caseAreaGet.BuscarAreaPorNome(nome);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("NovaArea")
    public ResponseEntity<Area> NovaArea(@RequestParam String nome,
                                         @RequestParam String dimensao,
                                         @RequestParam String gps,
                                         @RequestParam int numeroPlantios,
                                         @RequestParam int numeroLinhas,
                                         @RequestParam int numeroLocalizacoes)
    {return caseAreaPost.NovaArea(nome, dimensao, gps,numeroPlantios, numeroLinhas,numeroLocalizacoes);}

    @Operation(summary = "Edita Informações referentes a identificação da entidade", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("EditarInformacoesArea")
    public ResponseEntity<Area> EditarInformacoesArea(@RequestParam Long id,
                                                      @RequestParam String nome,
                                                      @RequestParam String dimensao,
                                                      @RequestParam String gps)
    {return caseAreaPut.EditarInformacoesArea(id, nome, dimensao, gps);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("AmpliarPlantio")
    public ResponseEntity<Area> AmpliarPlantio(@RequestParam Long id,
                                               @RequestParam int numeroPlantio,
                                               @RequestParam int numeroLinhas,
                                               @RequestParam int numeroLocalizacoes)
    {return caseAreaPut.AmpliarPlantio(id, numeroPlantio, numeroLinhas,numeroLocalizacoes);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("ReduzirPlantio")
    public ResponseEntity<Area> ReduzirPlantio(@RequestParam Long id,
                                               @RequestParam int numeroPlantio)
    {return caseAreaPut.ReduzirPlantio(id, numeroPlantio);}

}
