package App.Config;

import App.Infra.Gateway.PlantioGateway;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlantioConfig {

    @Bean
    UseCasePlantioGet useCasePlantioGet(PlantioGateway plantioGateway)
    { return new UseCasePlantioGet(plantioGateway);}

    @Bean
    UseCasePlantioPut useCasePlantioPut(PlantioGateway plantioGateway)
    { return new UseCasePlantioPut(plantioGateway);}

}
