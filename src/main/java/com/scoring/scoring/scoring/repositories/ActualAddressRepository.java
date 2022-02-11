package com.scoring.scoring.scoring.repositories;

import com.scoring.scoring.scoring.domain.ActualAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActualAddressRepository extends JpaRepository<ActualAddress, UUID> {
}
