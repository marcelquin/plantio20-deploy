package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.LinhaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhaRepository extends JpaRepository<LinhaEntity,Long> {
}
