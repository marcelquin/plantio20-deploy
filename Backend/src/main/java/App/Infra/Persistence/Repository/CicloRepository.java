package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.CicloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CicloRepository extends JpaRepository<CicloEntity,Long> {
}
