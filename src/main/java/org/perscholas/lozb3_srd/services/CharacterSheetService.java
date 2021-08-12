package org.perscholas.lozb3_srd.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharacterSheetService {

    // Default values according to the rulebook
    static int agilityDef = 1;
    static int brawnDef = 1;
    static int gutsDef = 1;
    static int witsDef = 1;
    static int smartsDef = 1;
    static int hpMaxDef = 12;
    static int mpMaxDef = 12;
    static int spMaxDef = 12;
    static int virtueDef = 1;
    static int skillPointMaxDef = 15;


    public static CharacterSheet generateDefaultSheet(PlayerAccount player) {
        CharacterSheet defaultSheet = new CharacterSheet(player);
        // Generates a blank character sheet with all stats set to their minimum
        defaultSheet.setAgilityVal(agilityDef);
        defaultSheet.setBrawnVal(brawnDef);
        defaultSheet.setGutsVal(gutsDef);
        defaultSheet.setWitsVal(witsDef);
        defaultSheet.setSmartsVal(smartsDef);
        defaultSheet.setHpBaseMax(hpMaxDef);
        defaultSheet.setMpBaseMax(mpMaxDef);
        defaultSheet.setSpBaseMax(spMaxDef);
        defaultSheet.setVirtueVal(virtueDef);
        defaultSheet.setSkillPointMax(skillPointMaxDef);
        return defaultSheet;
    }
}
