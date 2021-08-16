package org.perscholas.lozb3_srd;

import lombok.extern.java.Log;
import org.perscholas.lozb3_srd.dao.ICharacterSheetRepo;
import org.perscholas.lozb3_srd.dao.IPageModelRepo;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.dao.IRuleModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Log
@Transactional
public class AppStartupRunner {
    ICharacterSheetRepo characterSheetRepo;
    IPageModelRepo pageModelRepo;
    IPlayerAccountRepo playerAccountRepo;
    IRuleModelRepo ruleModelRepo;

    @Autowired
    public AppStartupRunner(ICharacterSheetRepo characterSheetRepo, IPageModelRepo pageModelRepo, IPlayerAccountRepo playerAccountRepo, IRuleModelRepo ruleModelRepo) {
        this.characterSheetRepo = characterSheetRepo;
        this.pageModelRepo = pageModelRepo;
        this.playerAccountRepo = playerAccountRepo;
        this.ruleModelRepo = ruleModelRepo;
    }

    // TODO: Override the run() method to generate some basic data for the app to test with
}
