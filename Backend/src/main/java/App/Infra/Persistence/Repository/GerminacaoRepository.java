package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.GerminacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerminacaoRepository extends JpaRepository<GerminacaoEntity,Long> {
}
