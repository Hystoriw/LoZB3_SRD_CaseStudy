package org.perscholas.lozb3_srd.dao;

import org.perscholas.lozb3_srd.models.RuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRuleModelRepo extends JpaRepository<RuleModel, Integer> {
}
