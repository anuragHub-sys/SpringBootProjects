package com.tms.ECommerce.repository;

import com.tms.ECommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CetegoryRepository extends JpaRepository<Category,Long> {

    public Optional<Category> findByName(String name);
}
