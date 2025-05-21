package App.Config;

import App.Infra.Gateway.LinhaGateway;
import App.Infra.UseCase.Linha.UseCaseLinhaGet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LinhaConfig {

    @Bean
    UseCaseLinhaGet useCaseLinhaGet(LinhaGateway linhaGateway)
    {return new UseCaseLinhaGet(linhaGateway);}
}
