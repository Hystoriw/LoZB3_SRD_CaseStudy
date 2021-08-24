package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/addcharacter")
    public String addCharacter(Model model) {
        CharacterSheet cs = new CharacterSheet();
        cs.setCharacterName("Something");
        model.addAttribute("character", cs);
        return "charsheet/charsheetmain";
    }

    @GetMapping("/character")
    public String getCharacter(Model model) {
        CharacterSheet cs = new CharacterSheet();
        cs.setCharacterName("Something");
        model.addAttribute("character", cs);
        return "charsheet/charsheetmain";
    }

    @GetMapping("/profiles")
    public String profiles() { return "profiles"; }

    // TODO: Navigate to the sheets page, and insert the current user's PlayerAccount model so it can populate the charSheetList
    @GetMapping("/sheets")
    public String sheets(PlayerAccount player, Model model) {
        model.addAttribute("currentProfile", player);
        return "sheets";
    }

    // TODO: Have this take the current user and the new CharacterSheet from sheets.html, and insert the data into a charsheet page
    @PostMapping("/addnewcharactersheet")
    public String addNewCharacterSheet(@RequestParam(value = "sheetName") String sheetName, PlayerAccount player, Model model) {
        log.warn("Grabbing name '" + sheetName + "' from form, creating a new CharacterSheet and inserting into model...");
        CharacterSheet characterSheet = new CharacterSheet(player, sheetName);
        model.addAttribute("character", characterSheet);

        log.warn("Adding new charsheet '" + characterSheet.getSheetName() + "' to user " + player.getUsername() + "...");
        if (player.getCharacterSheetList() == null)
        {
            log.warn("Existing sheet list not found! Creating new sheet list...");
            List<CharacterSheet> newSheetList = new ArrayList<>();
            player.setCharacterSheetList(newSheetList);
        }
        player.getCharacterSheetList().add(characterSheet);

        return "charsheet/charsheetmain";
    }
}
