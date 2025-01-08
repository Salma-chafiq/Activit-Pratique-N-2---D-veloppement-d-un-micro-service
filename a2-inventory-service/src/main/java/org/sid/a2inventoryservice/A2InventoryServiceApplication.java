package org.sid.a2inventoryservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SpringBootApplication
public class A2InventoryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(A2InventoryServiceApplication.class, args);
  }
  @Bean
  CommandLineRunner start(ProductRepository productRepository){
    return args -> {
      productRepository.save(new Product(null,"Ordinateur",788,12));
      productRepository.save(new Product(null,"Imprimante",88,129));
      productRepository.save(new Product(null,"Smartphone",1288,112));
      productRepository.findAll().forEach(System.out::println);
    };
  }

}

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name ;
  private double price ;
  private double quantity ;

}

@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product ,Long> {
}
