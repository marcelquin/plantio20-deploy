package App.Infra.Gateway;

import App.Domain.Response.Localizacao;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocalizacaoGateway {

    public ResponseEntity<List<Localizacao>> ListarLocalizacoes();

    public ResponseEntity<List<Localizacao>> ListarLocalizacoesDisponiveis();

    public ResponseEntity<List<Localizacao>> ListarLocalizacoesNaoDisponiveis();


}
