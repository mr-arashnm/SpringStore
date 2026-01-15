package com.mr_arashnm.springstore.repositories;

import com.mr_arashnm.springstore.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CroudRepository<Product, Long> {
    List<Product> findByaAme(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNAmeStartingWith(String name);
    List<Product> findByNAmeEndingWith(String name);
    List<Product> findByNAmeEndingWithIgnoreCase(String name);

    // Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min,  BigDecimal max);

    // Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull(String name);

    // Multiple condition
    List<Product> findByDescriptionNullAndNameNull();

    // Sort (orderBy)
    List<Product> findByNameOrderByPrice(String name);

    // Limit (Top/First)
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // Find Product whose price are in given range and sort by name
    List<Product> findByNameBetweenOrderByName(BigDecimal min, BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceWithCategory(BigDecimal newPrice, Byte categoryId);
}
