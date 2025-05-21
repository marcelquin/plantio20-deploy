package App.Infra.UseCase.Linha;

import App.Domain.Response.Linha;
import App.Infra.Gateway.LinhaGateway;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UseCaseLinhaGet {

    private final LinhaGateway linhaGateway;

    public UseCaseLinhaGet(LinhaGateway linhaGateway) {
        this.linhaGateway = linhaGateway;
    }

    public ResponseEntity<List<Linha>> ListarLinhas()
    {return linhaGateway.ListarLinhas();}


    public ResponseEntity<List<Linha>> ListarLinhasDisponiveis()
    {return linhaGateway.ListarLinhasDisponiveis();}

}
