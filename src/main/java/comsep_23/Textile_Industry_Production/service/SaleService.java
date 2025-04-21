package comsep_23.Textile_Industry_Production.service;

import comsep_23.Textile_Industry_Production.entity.Material;
import comsep_23.Textile_Industry_Production.repository.MaterialRepository;
import comsep_23.Textile_Industry_Production.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import comsep_23.Textile_Industry_Production.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SaleService {

    private final MaterialRepository materialRepository;
    private List<Material> materials;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;


    public List<Material> allMaterials() {
        return materialRepository.findAll();
    }


    public Material materialByID(long id) {
        return materials.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public List<Material> findByMaterialName(String materialName) {
        if (materials == null) return Collections.emptyList();
        return materials.stream()
                .filter(m -> m.getMaterialName().equalsIgnoreCase(materialName))
                .collect(Collectors.toList());
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

}
