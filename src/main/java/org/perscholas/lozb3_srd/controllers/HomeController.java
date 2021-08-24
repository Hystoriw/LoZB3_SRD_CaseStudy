package org.perscholas.lozb3_srd.controllers;

import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
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
    public String addNewCharacterSheet(@RequestBody CharacterSheet characterSheet, PlayerAccount player) {
        ModelAndView mav = new ModelAndView("charsheet/charsheetmain");
        mav.addObject(characterSheet);

        if (player.getCharacterSheetList() == null)
        {
            List<CharacterSheet> newSheetList = new ArrayList<>();
            player.setCharacterSheetList(newSheetList);
        }
        player.getCharacterSheetList().add(characterSheet);

        return "charsheet/main";
    }

}
