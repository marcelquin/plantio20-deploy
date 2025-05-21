package App.Config;

import App.Infra.Gateway.PlantaGateway;
import App.Infra.UseCase.Planta.UseCasePlantaGet;
import App.Infra.UseCase.Planta.UseCasePlantaPost;
import App.Infra.UseCase.Planta.UseCasePlantaPut;
import App.Infra.UseCase.Plantio.UseCasePlantioGet;
import App.Infra.UseCase.Plantio.UseCasePlantioPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlantaConfig {

    @Bean
    UseCasePlantaPut useCasePlantaPut(PlantaGateway plantaGateway)
    {return new UseCasePlantaPut(plantaGateway);}

    @Bean
    UseCasePlantaPost useCasePlantaPost(PlantaGateway plantaGateway)
    {return new UseCasePlantaPost(plantaGateway);}

    @Bean
    UseCasePlantaGet useCasePlantaGet(PlantaGateway plantaGateway)
    {return new UseCasePlantaGet(plantaGateway);}
}
