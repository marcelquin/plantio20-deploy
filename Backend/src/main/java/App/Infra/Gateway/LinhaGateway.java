package App.Infra.Gateway;

import App.Domain.Response.Linha;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LinhaGateway {

    public ResponseEntity<List<Linha>> ListarLinhas();

    public ResponseEntity<List<Linha>> ListarLinhasDisponiveis();
}
