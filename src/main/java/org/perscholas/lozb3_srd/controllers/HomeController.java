package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@SessionAttributes({"currentProfile"})
public class HomeController {

    IPlayerAccountRepo playerAccountRepo;

    @Autowired
    public HomeController(IPlayerAccountRepo playerAccountRepo) {
        this.playerAccountRepo = playerAccountRepo;
    }

    @ModelAttribute("currentProfile")
    public PlayerAccount initPlayerAccount(Principal principal) {
        log.warn("InitMethod, current user's name is: " + principal.getName());
        return playerAccountRepo.findByUsername(principal.getName()).get();
    }

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
    public String sheets(Principal principal,
                         Model model) {
        PlayerAccount currentProfile = playerAccountRepo.findByUsername(principal.getName()).get();
        model.addAttribute("currentProfile", currentProfile);
        return "sheets";
    }


}
