package org.perscholas.lozb3_srd.dao;

import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterSheetRepo extends JpaRepository<CharacterSheet, Integer> {

}
