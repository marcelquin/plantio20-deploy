package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.FloracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloracaoRepository extends JpaRepository<FloracaoEntity,Long> {
}
