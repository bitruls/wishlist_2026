package com.example.wishlist_2026.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wishlist_2026.model.Gift;

public interface GiftRepository extends JpaRepository<Gift, Long> {}
