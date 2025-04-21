package comsep_23.Textile_Industry_Production.controller;

import comsep_23.Textile_Industry_Production.entity.Material;
import comsep_23.Textile_Industry_Production.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to materials CUSTOMER";
    }
    @GetMapping("/all-materials")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public List<Material> allMaterials() {
        return customerService.allMaterials();
    }

    @GetMapping("/materialsByName")
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    public List<Material> materialsByName(@RequestParam String name) {
        return (List<Material>) customerService.findByMaterialName(name);
    }
}
