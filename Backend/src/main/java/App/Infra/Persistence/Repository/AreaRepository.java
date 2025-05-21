package App.Infra.Persistence.Repository;

import App.Infra.Persistence.Entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Long> {

    Optional<AreaEntity> findBynome(String nome);
}
