package aspire.tech.web.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import aspire.tech.web.test.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
