package com.serralyse.website.repository;

import com.serralyse.website.entity.MicroPod;
import com.serralyse.website.entity.PodStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MicroPodRepository extends JpaRepository<MicroPod, UUID> {
    Optional<MicroPod> findFirstByStatus(PodStatus status);
}
