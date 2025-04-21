package comsep_23.Textile_Industry_Production.config;

import comsep_23.Textile_Industry_Production.entity.Material;
import comsep_23.Textile_Industry_Production.repository.MaterialRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BootstrapData implements CommandLineRunner {

    private final MaterialRepository materialRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE_TIME;

    @Autowired
    public BootstrapData(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadMaterialsFromCsv();
    }

    private void loadMaterialsFromCsv() throws IOException {
        Reader reader = new InputStreamReader(new ClassPathResource("material.csv").getInputStream());

        CSVFormat csvFormat = CSVFormat.Builder
                .create()
                .setHeader("materialName", "order_date", "quantity")
                .setSkipHeaderRecord(true)
                .build();

        try (CSVParser records = csvFormat.parse(reader)) {
            for (CSVRecord record : records) {
                Material material = new Material();

                material.setMaterialName(record.get("materialName"));

                String orderDateStr = record.get("order_date");
                try {
                    material.setOrderDate(LocalDateTime.parse(orderDateStr, dateFormatter));
                } catch (Exception e) {
                    System.err.println("Invalid date: " + orderDateStr);
                    continue;
                }

                String quantityStr = record.get("quantity");
                try {
                    material.setQuantity(Integer.parseInt(quantityStr));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid quantity: " + quantityStr);
                    continue;
                }

                materialRepository.save(material);
            }
        }
    }
}
