package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.MaturacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaturacaoRepository extends JpaRepository<MaturacaoEntity,Long> {
}
