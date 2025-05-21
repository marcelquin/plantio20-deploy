package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.LocalizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocalizacaoRepository extends JpaRepository<LocalizacaoEntity, Long> {

    Optional<LocalizacaoEntity> findByreferencia(String referencia);
}
