package com.scoring.scoring.scoring.repositories;


import com.scoring.scoring.scoring.domain.AdditionalContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdditionalContactRepository extends JpaRepository<AdditionalContact, UUID> {
}
