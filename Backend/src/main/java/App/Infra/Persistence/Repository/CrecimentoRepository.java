package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.CrecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrecimentoRepository extends JpaRepository<CrecimentoEntity,Long> {
}
