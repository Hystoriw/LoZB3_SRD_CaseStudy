package org.perscholas.lozb3_srd.dao;

import org.perscholas.lozb3_srd.models.PageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPageModelRepo extends JpaRepository<PageModel, Integer> {
}
