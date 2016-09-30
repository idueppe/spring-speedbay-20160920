package io.crowdcode.speedbay.product.repository;

import io.crowdcode.speedbay.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);
}
