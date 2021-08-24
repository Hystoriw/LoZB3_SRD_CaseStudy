package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.dao.ICharacterSheetRepo;
import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.services.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/charsheet")
public class CharSheetController {

    ICharacterSheetRepo characterSheetRepo;

    @Autowired
    public CharSheetController(ICharacterSheetRepo characterSheetRepo) {
        this.characterSheetRepo = characterSheetRepo;
    }

    @GetMapping({"/blank", "/"})
    public String blankCharSheet(Model model) {
        CharacterSheet cs = CharacterSheetService.generateDefaultSheet();
        model.addAttribute("character", cs);
        return "charsheet/charsheetmain";
    }

    // TODO: Have this persist the data entered into boxes when navigating between pages
    @GetMapping("/{link}")
    public String mainSheet(@PathVariable(value = "link") String link, Model model) {
        if (model.getAttribute("character") == null) {
            log.warn("character attribute is null, creating default sheet...");
            CharacterSheet cs = CharacterSheetService.generateDefaultSheet();
            model.addAttribute("character", cs);
        }
        else {
            log.warn("character attribute exists, adding to new model...");
            CharacterSheet cs = (CharacterSheet) model.getAttribute("character");
            model.addAttribute("character", cs);
        }

        if (link.equals("main")) {
            return "charsheet/charsheetmain";
        }
        else if (link.equals("equipment")) {
            return "charsheet/charsheetequipment";
        }
        else if (link.equals("spells")) {
            return "charsheet/charsheetspells";
        }
        else if (link.equals("techniques")) {
            return "charsheet/charsheettechniques";
        }
        else if (link.equals("advancement")) {
            return "charsheet/charsheetadvancement";
        }
        log.warn("No matches found, returning to error.html");
        return "error";
    }

    // TODO: Have this read the {link} from the sheets page when selecting from the dropdown list, and inject that sheet model into the character sheet page
    @GetMapping("/getsheet/{link}")
    public String getSheet(@PathVariable(value = "link") String link, Model model) {
        CharacterSheet charsheet = characterSheetRepo.getById(Integer.parseInt(link));
        model.addAttribute("character", charsheet);
        return "charsheet/charsheetmain";
    }

//    @PostMapping("/addcharacter")
//    public String addCharacter(Model model) {
//        CharacterSheet cs = new CharacterSheet();
//        cs.setCharacterName("Something");
//        model.addAttribute("character", cs);
//        return "charsheetmain";
//    }
//
//    @GetMapping("/character")
//    public String getCharacter(Model model) {
//        CharacterSheet cs = new CharacterSheet();
//        cs.setCharacterName("Something");
//        model.addAttribute("character", cs);
//        return "charsheet/charsheetmain";
//    }
}
