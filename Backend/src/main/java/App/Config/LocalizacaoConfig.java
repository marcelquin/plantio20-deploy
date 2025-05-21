package App.Config;

import App.Infra.Gateway.LocalizacaoGateway;
import App.Infra.UseCase.Localizacao.UseCaseLocalizacaoGet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalizacaoConfig {

    @Bean
    UseCaseLocalizacaoGet useCaseLocalizacaoGet(LocalizacaoGateway localizacaoGateway)
    {return new UseCaseLocalizacaoGet(localizacaoGateway);}
}
