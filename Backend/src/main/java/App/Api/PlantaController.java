package App.Api;


import App.Domain.Response.Planta;
import App.Infra.UseCase.Planta.UseCasePlantaGet;
import App.Infra.UseCase.Planta.UseCasePlantaPost;
import App.Infra.UseCase.Planta.UseCasePlantaPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planta")
@Tag(name = "Planta", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class PlantaController {

    private final UseCasePlantaGet casePlantaGet;
    private final UseCasePlantaPost casePlantaPost;
    private final UseCasePlantaPut casePlantaPut;

    public PlantaController(UseCasePlantaGet casePlantaGet, UseCasePlantaPost casePlantaPost, UseCasePlantaPut casePlantaPut) {
        this.casePlantaGet = casePlantaGet;
        this.casePlantaPost = casePlantaPost;
        this.casePlantaPut = casePlantaPut;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantas")
    public ResponseEntity<List<Planta>> ListarPlantas()
    {return casePlantaGet.ListarPlantas();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasGerminacao")
    public ResponseEntity<List<Planta>> ListarPlantasGerminacao()
    {return casePlantaGet.ListarPlantasGerminacao();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasMuda")
    public ResponseEntity<List<Planta>> ListarPlantasMuda()
    {return casePlantaGet.ListarPlantasMuda();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasCrescimento")
    public ResponseEntity<List<Planta>> ListarPlantasCrescimento()
    {return casePlantaGet.ListarPlantasCrescimento();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasFloracao")
    public ResponseEntity<List<Planta>> ListarPlantasFloracao()
    {return casePlantaGet.ListarPlantasFloracao();}


    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasFrutificacao")
    public ResponseEntity<List<Planta>> ListarPlantasFrutificacao()
    {return casePlantaGet.ListarPlantasFrutificacao();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasMaturacao")
    public ResponseEntity<List<Planta>> ListarPlantasMaturacao()
    {return casePlantaGet.ListarPlantasMaturacao();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarPlantasFimCiclo")
    public ResponseEntity<List<Planta>> ListarPlantasFimCiclo()
    {return casePlantaGet.ListarPlantasFimCiclo();}


    @Operation(summary = "Busca Registro na tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("BuscarPlantaPorId")
    public ResponseEntity<Planta> BuscarPlantaPorId(@RequestParam Long id)
    {return casePlantaGet.BuscarPlantaPorId(id);}

    @Operation(summary = "Salva Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("NovaPlanta")
    public ResponseEntity<Planta> NovaPlanta(@RequestParam Long localizacaoId,
                                             @RequestParam String nomeCientifico,
                                             @RequestParam String nomePopular,
                                             @RequestParam String instrucoes)
    {return casePlantaPost.NovaPlanta(localizacaoId, nomeCientifico, nomePopular, instrucoes);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("EditarPlanta")
    public ResponseEntity<Planta> EditarPlanta(@RequestParam Long plantaId,
                                               @RequestParam String nomeCientifico,
                                               @RequestParam String nomePopular,
                                               @RequestParam String instrucoes)
    {return casePlantaPut.EditarPlanta(plantaId, nomeCientifico, nomePopular, instrucoes);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("AlterarCiclo")
    public ResponseEntity<Planta> AlterarCiclo(@RequestParam Long id,
                                               @RequestParam String ciclo)
    {return casePlantaPut.AlterarCiclo(id, ciclo);}

    @Operation(summary = "Edita Registro da tabela adicionando entidades", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("AlterarLocalizacao")
    public ResponseEntity<Planta> AlterarLocalizacao(@RequestParam Long plantaId,
                                                     @RequestParam Long localizacaoId)
    {return casePlantaPut.AlterarLocalizacao(plantaId,localizacaoId);}

}
