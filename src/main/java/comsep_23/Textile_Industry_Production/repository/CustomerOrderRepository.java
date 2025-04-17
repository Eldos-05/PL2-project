package comsep_23.Textile_Industry_Production.repository;

import comsep_23.Textile_Industry_Production.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<Materials, Long> {

}
