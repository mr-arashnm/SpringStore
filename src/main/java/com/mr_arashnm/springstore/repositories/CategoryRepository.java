package com.mr_arashnm.springstore.repositories;

import com.mr_arashnm.springstore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<
        Category, Long> {
}
