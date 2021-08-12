package org.perscholas.lozb3_srd.services;

import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CharacterSheetService {

    // Default values according to the rulebook


    public static CharacterSheet generateDefaultSheet() {
        CharacterSheet defaultSheet = new CharacterSheet();
        //TODO: populate the character sheet with all necessary values

        return defaultSheet;
    }
}
