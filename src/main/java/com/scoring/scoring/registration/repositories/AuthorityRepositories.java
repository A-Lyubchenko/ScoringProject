package com.scoring.scoring.registration.repositories;

import com.scoring.scoring.registration.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorityRepositories extends JpaRepository<Authority, UUID> {

}
