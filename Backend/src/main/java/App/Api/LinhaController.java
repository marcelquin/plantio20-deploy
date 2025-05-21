package App.Api;

import App.Domain.Bussness.LinhaService;
import App.Domain.Response.Linha;
import App.Infra.UseCase.Linha.UseCaseLinhaGet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("linha")
@Tag(name = "Linha", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class LinhaController {

    private final UseCaseLinhaGet caseLinhaGet;

    public LinhaController(UseCaseLinhaGet caseLinhaGet) {
        this.caseLinhaGet = caseLinhaGet;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLinhas")
    public ResponseEntity<List<Linha>> ListarLinhas()
    {return caseLinhaGet.ListarLinhas();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLinhasDisponiveis")
    public ResponseEntity<List<Linha>> ListarLinhasDisponiveis()
    {return caseLinhaGet.ListarLinhasDisponiveis();}

}
