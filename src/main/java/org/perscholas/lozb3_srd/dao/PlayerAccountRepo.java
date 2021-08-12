package org.perscholas.lozb3_srd.dao;

import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerAccountRepo extends JpaRepository<PlayerAccount, Long> {
    Optional<PlayerAccount> findPlayerAccountsByUserName(String username);
}
