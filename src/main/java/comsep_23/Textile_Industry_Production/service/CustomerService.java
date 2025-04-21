package comsep_23.Textile_Industry_Production.service;

import comsep_23.Textile_Industry_Production.entity.Material;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Locale.filter;

@Service
@NoArgsConstructor
public class CustomerService {

    private List<Material> materials;


    public List<Material> allMaterials() {
        return materials;
    }

    public Material findByMaterialName(String materialName) {
        if (materials == null) return null;
        return materials.stream()
                .filter(m -> m.getMaterialName().equalsIgnoreCase(materialName))
                .findFirst()
                .orElse(null);
    }
}
