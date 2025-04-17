package comsep_23.Textile_Industry_Production.controller;


import comsep_23.Textile_Industry_Production.entity.Materials;
import comsep_23.Textile_Industry_Production.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/materials")
@AllArgsConstructor
public class SaleController {

    private final SaleService service;
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to materials";
    }

    @GetMapping("/all-materials")
    @PreAuthorize("hasAuthority('ROLE_SALEMAN') or hasAuthority('ROLE_MANAGER')")
    public List<Materials> allMaterials() {
        return service.allMaterials();
    }

}
