package comsep_23.Textile_Industry_Production.service;

import com.github.javafaker.Faker;
import comsep_23.Textile_Industry_Production.entity.Materials;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Service
@Getter
public class SaleService {

    private List<Materials> materials;

    @PostConstruct
    public void generateMaterials() {
        Faker faker = new Faker();
        this.materials = IntStream.rangeClosed(1, 50)
                .mapToObj(i -> Materials.builder()
                        .id((long) i)
                        .materialName(faker.commerce().productName())
                        .quantity(ThreadLocalRandom.current().nextInt(1, 101))
                        .orderDate(LocalDateTime.now().minusDays(ThreadLocalRandom.current().nextInt(0, 30)))
                        .build())
                .toList();

        System.out.println("Generated 100 fake materials.");
        materials.forEach(System.out::println);
    }

    public List<Materials> allMaterials() {
        return materials;
    }
}
