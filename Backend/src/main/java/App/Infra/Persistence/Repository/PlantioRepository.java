package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.PlantioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantioRepository extends JpaRepository<PlantioEntity,Long> {
}
