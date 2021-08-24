package org.perscholas.lozb3_srd.controllers;

import org.perscholas.lozb3_srd.models.CharacterSheet;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/profiles")
    public String profiles(PlayerAccount player, Model model) {
        if (player != null) {
            model.addAttribute("currentProfile", player);
        }
        return "profiles";
    }

}
