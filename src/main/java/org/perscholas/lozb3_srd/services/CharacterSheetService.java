package org.perscholas.lozb3_srd.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.perscholas.lozb3_srd.models.charsheetmodels.Skill;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    static int sizeBaseVal = 1;

    public static CharacterSheet generateDefaultSheet(PlayerAccount player) {
        CharacterSheet defaultSheet = new CharacterSheet("Default Sheet");
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
        defaultSheet.setSizeBaseVal(sizeBaseVal);

        Skill melee = new Skill("Melee", 0, "Brawn");
        Skill heavy = new Skill("Heavy", 0, "Brawn");
        Skill ranged = new Skill("Ranged", 0, "Agility");
        Skill shields = new Skill("Shields", 0, "Guts");
        Skill spellcraft = new Skill("Spellcraft", 0, "Smarts");
        Skill instruments = new Skill("Instruments", 0, "Wits");
        Skill tools = new Skill("Tools", 0, "Varies");
        Skill athletics = new Skill("Athletics", 0, "Varies");
        Skill riding = new Skill("Riding", 0, "Smarts");
        Skill stealth = new Skill("Stealth", 0, "Agility");
        Skill perception = new Skill("Perception", 0, "Wits");
        Skill survival = new Skill("Survival", 0, "Wits");
        Skill lore = new Skill("Lore", 0, "Smarts");
        Skill composure = new Skill("Composure", 0, "Guts");

        List<Skill> skillListDef = new ArrayList<Skill>();
        skillListDef.add(melee);
        skillListDef.add(heavy);
        skillListDef.add(ranged);
        skillListDef.add(shields);
        skillListDef.add(spellcraft);
        skillListDef.add(instruments);
        skillListDef.add(tools);
        skillListDef.add(athletics);
        skillListDef.add(riding);
        skillListDef.add(stealth);
        skillListDef.add(perception);
        skillListDef.add(survival);
        skillListDef.add(lore);
        skillListDef.add(composure);

        defaultSheet.setSkillList(skillListDef);

        return defaultSheet;
    }

    public static CharacterSheet generateDefaultSheet() {
        CharacterSheet defaultSheet = new CharacterSheet();
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
