package App.Api;

import App.Domain.Response.Localizacao;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoGet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("localizacao")
@Tag(name = "Localizacao", description = "Manipula dados relacioados a entidade")
@CrossOrigin(origins = "*")
public class LocalizacaoController {

    private final UseCaseLocalizacaoGet caseLocalizacaoGet;

    public LocalizacaoController(UseCaseLocalizacaoGet caseLocalizacaoGet) {
        this.caseLocalizacaoGet = caseLocalizacaoGet;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLocalizacoesDisponiveis")
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis()
    {return caseLocalizacaoGet.ListarLocalizacoesDisponiveis();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLocalizacoes")
    public ResponseEntity<List<Localizacao>> ListarLocalizacoes()
    {return caseLocalizacaoGet.ListarLocalizacoes();}

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("ListarLocalizacoesNaoDisponiveis")
    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis()
    {return caseLocalizacaoGet.ListarLocalizacoesNaoDisponiveis();}


}
