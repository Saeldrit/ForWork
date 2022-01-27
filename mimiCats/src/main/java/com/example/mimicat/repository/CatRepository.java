package com.example.mimicat.repository;

import com.example.mimicat.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Integer> {
}
