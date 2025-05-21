package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.CicloEntity;
import App.Infra.Persistence.Entity.MudaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MudaRepository extends JpaRepository<MudaEntity,Long> {
}
