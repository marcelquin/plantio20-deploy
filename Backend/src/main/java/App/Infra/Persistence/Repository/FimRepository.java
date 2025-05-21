package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.FimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FimRepository extends JpaRepository<FimEntity,Long> {
}
