package com.serralyse.website.repository;

import com.serralyse.website.entity.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
    Optional<RawMaterial> findByNameContainingIgnoreCase(String name);

}
