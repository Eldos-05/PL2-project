package comsep_23.Textile_Industry_Production.controller;


import comsep_23.Textile_Industry_Production.entity.Material;
import comsep_23.Textile_Industry_Production.entity.User;
import comsep_23.Textile_Industry_Production.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/materials")
@AllArgsConstructor
public class SaleController {

    private final SaleService service;
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to materials SALEMAN";
    }

    @GetMapping("/all-materials")
    @PreAuthorize("hasAuthority('ROLE_SALEMAN')")
    public List<Material> allMaterials() {
        return service.allMaterials();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_SALEMAN')")
    public Material materialByID(@PathVariable int id) {
        return service.materialByID(id);
    }

    @GetMapping("/materialsByName")
    @PreAuthorize("hasAuthority('ROLE_SALEMAN')")
    public List<Material> materialsByName(@RequestParam String name) {
        return service.findByMaterialName(name);
    }

    @PostMapping("new-user")
    public String addUser(@RequestBody User user) {
        service.addUser(user);
        return "User is saved";
    }




}
