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
import java.util.ArrayList;
import java.util.List;

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

    @ModelAttribute("currentProfile")
    public PlayerAccount initPlayerAccount(Principal principal) {
        log.warn("InitMethod, current user's name is: " + principal.getName());
        return playerAccountRepo.findByUsername(principal.getName()).get();
    }

    @GetMapping({"/blank", "/"})
    public String blankCharSheet(Model model) {
        CharacterSheet cs = CharacterSheetService.generateDefaultSheet();
        model.addAttribute("character", cs);
        return "charsheet/charsheetmain";
    }

//    // TODO: Have this persist the data entered into boxes when navigating between pages
//    @GetMapping("/{link}")
//    public String mainSheet(@PathVariable(value = "link") String link, Model model) {
//        if (model.getAttribute("character") == null) {
//            log.warn("character attribute is null, creating default sheet...");
//            CharacterSheet cs = CharacterSheetService.generateDefaultSheet();
//            model.addAttribute("character", cs);
//        }
//        else {
//            log.warn("character attribute exists, adding to new model...");
//            CharacterSheet cs = (CharacterSheet) model.getAttribute("character");
//            model.addAttribute("character", cs);
//        }
//
//        if (link.equals("main")) {
//            return "charsheet/charsheetmain";
//        }
//        else if (link.equals("equipment")) {
//            return "charsheet/charsheetequipment";
//        }
//        else if (link.equals("spells")) {
//            return "charsheet/charsheetspells";
//        }
//        else if (link.equals("techniques")) {
//            return "charsheet/charsheettechniques";
//        }
//        else if (link.equals("advancement")) {
//            return "charsheet/charsheetadvancement";
//        }
//        log.warn("No matches found, returning to error.html");
//        return "error";
//    }
//
//    // TODO: Have this read the {link} from the sheets page when selecting from the dropdown list, and inject that sheet model into the character sheet page
//    @GetMapping("/{sheetId}/{link}")
//    public String getSheet(Principal principal,
//                           @PathVariable(value = "sheetId") Integer sheetId,
//                           @PathVariable(value = "link") String link,
//                           Model model) {
//        CharacterSheet charsheet = characterSheetRepo.getById(sheetId);
//
//        log.warn("getSheet(), current profile is: " + principal);
//        log.warn("getSheet(), account matching current profile is: " + playerAccountRepo.findByUsername(principal.getName()).get());
//        PlayerAccount player = playerAccountRepo.findByUsername(principal.getName()).get();
//        log.warn("getSheet(), player is: " + player);
//
//        log.warn("Requested sheet: " + characterSheetRepo.getById(sheetId).getSheetName());
//        log.warn("Checking if current user's charsheet list contains the requested sheet's id...");
//        for (CharacterSheet sheet : player.getCharacterSheetList()) {
//            log.warn("getSheet(), current id is: " + sheet.getSheetId());
//            if (sheet.getSheetId() == sheetId) {
//                log.warn("Match found! Directing to the charsheet.");
//                model.addAttribute("character", charsheet);
//
//                switch (link) {
//                    case "main":
//                        return "charsheet/charsheetmain";
//                    case "equipment":
//                        return "charsheet/charsheetequipment";
//                    case "spells":
//                        return "charsheet/charsheetspells";
//                    case "techniques":
//                        return "charsheet/charsheettechniques";
//                    case "advancement":
//                        return "charsheet/charsheetadvancement";
//                }
//            }
//        }
//
//        log.warn("No matches found! Returning to sheets page.");
//        return "sheets";
//    }

    @PostMapping("/{sheetId}/updatecharsheet")
    public String updateCharSheet(@ModelAttribute(value = "character") CharacterSheet newSheet,
                                  @PathVariable(value = "sheetId") Integer sheetId,
                                  Model model) {
        log.warn("updateCharSheet(), trying to grab newSheet: " + newSheet);

        CharacterSheet oldSheet = characterSheetRepo.findById(sheetId).get();
        log.warn("updateCharSheet(), oldSheet is now: " + oldSheet);
        newSheet.setSheetId(sheetId);
//        newSheet.setPlayerAccount(oldSheet.getPlayerAccount());
        newSheet.setSheetName(oldSheet.getSheetName());
        log.warn("updateCharSheet(), newSheet is now: " + newSheet);

        characterSheetRepo.save(newSheet);

        model.addAttribute("character, newSheet");
        return "charsheet/charsheetconsolidated";
    }

    @GetMapping("/{sheetId}/consolidated")
    public String getConsolidatedSheet(Principal principal,
                           @PathVariable(value = "sheetId") Integer sheetId,
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
                log.warn("Match found! Directing to the consolidated charsheet.");
                model.addAttribute("character", charsheet);

                return "charsheet/charsheetconsolidated";
            }
        }

        log.warn("No matches found! Returning to sheets page.");
        return "sheets";
    }

    // TODO: Have this take the current user and the new CharacterSheet from sheets.html, and insert the data into a charsheet page
    @PostMapping("/addnewcharactersheet")
    public String addNewCharacterSheet(Principal principal,
                                       @RequestParam(name = "newSheetName") String sheetName,
                                       Model model) {

        if (sheetName.isBlank() || sheetName.isEmpty()) {
            return "redirect:/sheets?nosheetname=true";
        }

        PlayerAccount player = playerAccountRepo.findByUsername(principal.getName()).get();

        log.warn("Grabbing name '" + sheetName + "' from form, creating a new CharacterSheet and inserting into model...");
        CharacterSheet characterSheet = CharacterSheetService.generateDefaultSheet();
        characterSheet.setSheetName(sheetName);
        characterSheet = characterSheetRepo.save(characterSheet);
        model.addAttribute("character", characterSheet);

        log.warn("Adding new charsheet '" + characterSheet.getSheetName() + "' to user " + player.getUsername() + "...");
        if (player.getCharacterSheetList() == null)
        {
            log.warn("Existing sheet list not found! Creating new sheet list...");
            List<CharacterSheet> newSheetList = new ArrayList<>();
            player.setCharacterSheetList(newSheetList);
        }

        player.getCharacterSheetList().add(characterSheet);
        log.warn("addNewCharacterSheet(), player is now: " + player);
        for (CharacterSheet cs : player.getCharacterSheetList()) {
            log.warn("addNewCharacterSheet(), got character sheet with the name: " + cs.getSheetName());
        }
        log.warn("addNewCharacterSheet(), player's character sheet list size is now: " + player.getCharacterSheetList().size());
        playerAccountRepo.save(player);

        return "redirect:/sheets?addsuccess=true";
    }

    @PostMapping("/{sheetId}/deletecharactersheet")
    public String deleteCharacterSheet(Principal principal,
                                       @PathVariable(name= "sheetId") int sheetId) {
        // grab the current user from principal
        log.warn("deleteCharacterSheet(), grabbing user: " + playerAccountRepo.findByUsername(principal.getName()).get().getUsername());
        PlayerAccount player = playerAccountRepo.findByUsername(principal.getName()).get();
        // compare the sheetId to be deleted to the user's list of sheet IDs

        log.warn("deleteCharacterSheet(), comparing sheet with ID '" + sheetId + "' to sheets in the grabbed user's list...");
        for (CharacterSheet sheet : player.getCharacterSheetList()) {
            log.warn("deleteCharacterSheet(), current sheet id is: " + sheet.getSheetId());
            if (sheet.getSheetId() == sheetId) {
                //TODO: throw warning to the user in sheets.html to confirm or cancel the deletion
                log.warn("Match found! Throwing warning to the user to confirm deletion...");
                // delete the matching sheet
                log.warn("Removing sheet from player's character sheet list...");
                player.getCharacterSheetList().remove(sheet);
                playerAccountRepo.save(player);
                log.warn("Deleting sheet with ID: " + sheet.getSheetId());
                characterSheetRepo.delete(sheet);

                // redirect to the sheets page with a success message
                log.warn("Character deleted! Redirecting back to the sheets page...");
                return "redirect:/sheets?deletesuccess=true";
            }
        }
        log.warn("No matches found! Redirecting to the sheets page");
        return "redirect:/sheets";
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
