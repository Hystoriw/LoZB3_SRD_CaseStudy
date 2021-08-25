package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.dao.ICharacterSheetRepo;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.perscholas.lozb3_srd.services.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@Slf4j
@RequestMapping("/charsheet")
@SessionAttributes({"currentProfile"})
public class CharSheetController {

    ICharacterSheetRepo characterSheetRepo;
    IPlayerAccountRepo playerAccountRepo;

    @Autowired
    public CharSheetController(ICharacterSheetRepo characterSheetRepo, IPlayerAccountRepo playerAccountRepo) {
        this.characterSheetRepo = characterSheetRepo;
        this.playerAccountRepo = playerAccountRepo;
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
    @GetMapping("/{sheetId}/{link}")
    public String getSheet(Principal principal,
                           @PathVariable(value = "sheetId") Integer sheetId,
                           @PathVariable(value = "link") String link,
                           Model model) {
        CharacterSheet charsheet = characterSheetRepo.getById(sheetId);

        log.warn("getSheet(), current profile is: " + principal);
        log.warn("getSheet(), account matching current profile is: " + playerAccountRepo.findByUsername(principal.getName()).get());
        PlayerAccount player = playerAccountRepo.findByUsername(principal.getName()).get();
        log.warn("getSheet(), player is: " + player);

        log.warn("Requested sheet: " + characterSheetRepo.getById(sheetId).getSheetName());
        log.warn("Checking if current user's charsheet list contains the requested sheet's id...");
        for (CharacterSheet sheet : player.getCharacterSheetList()) {
            log.warn("getSheet(), current id is: " + sheet.getSheetId());
            if (sheet.getSheetId() == sheetId) {
                log.warn("Match found! Directing to the charsheet.");
                model.addAttribute("character", charsheet);

                switch (link) {
                    case "main":
                        return "charsheet/charsheetmain";
                    case "equipment":
                        return "charsheet/charsheetequipment";
                    case "spells":
                        return "charsheet/charsheetspells";
                    case "techniques":
                        return "charsheet/charsheettechniques";
                    case "advancement":
                        return "charsheet/charsheetadvancement";
                }
            }
        }

        log.warn("No matches found! Returning to sheets page.");
        return "sheets";
    }

    @PostMapping("/{sheetId}/updatecharsheet")
    public String updateCharSheet(@ModelAttribute(value = "character") CharacterSheet newSheet,
                                  @PathVariable(value = "sheetId") Integer sheetId) {
        log.warn("updateCharSheet(), trying to grab newSheet: " + newSheet);

        CharacterSheet oldSheet = characterSheetRepo.findById(sheetId).get();
        log.warn("updateCharSheet(), oldSheet is now: " + oldSheet);
        newSheet.setSheetId(sheetId);
//        newSheet.setPlayerAccount(oldSheet.getPlayerAccount());
        newSheet.setSheetName(oldSheet.getSheetName());
        log.warn("updateCharSheet(), newSheet is now: " + newSheet);

        characterSheetRepo.save(newSheet);

        return "redirect:/";
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
