package comsep_23.Textile_Industry_Production.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/delivery-service")
@AllArgsConstructor
public class DeliveryController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to materials DELIVERYMAN";
    }
}
