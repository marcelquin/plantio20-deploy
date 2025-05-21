package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.FrutificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrutificacaoRepository extends JpaRepository<FrutificacaoEntity,Long> {
}
