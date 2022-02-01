package com.example.mimicat.repository;

import com.example.mimicat.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    Optional<Like> findLikeByCombination(String combination);
}
