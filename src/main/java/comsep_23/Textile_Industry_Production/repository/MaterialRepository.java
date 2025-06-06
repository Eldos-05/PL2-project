package comsep_23.Textile_Industry_Production.repository;

import comsep_23.Textile_Industry_Production.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findAll = List.of();
}
