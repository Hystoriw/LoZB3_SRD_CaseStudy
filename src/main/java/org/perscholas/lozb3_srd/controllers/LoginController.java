package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    IPlayerAccountRepo playerAccountRepo;

    @Autowired
    public LoginController(IPlayerAccountRepo playerAccountRepo) {
        this.playerAccountRepo = playerAccountRepo;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/createprofile")
    public String createProfile(@RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password,
                                @RequestParam(value = "verifiedPassword") String verifiedPassword,
                                Model model) {
        if (password != verifiedPassword) {
            // TODO: insert "differentPassword" into the param in login.html
            return "login?badPassword=true";
        }

        log.warn("Finding if a player with the username of '" + username + "' already exists...");
        for (PlayerAccount player: playerAccountRepo.findAll()) {
            if (player.getUsername() == username) {
                log.warn("This user already exists!");
                // TODO: Insert "nameTaken" into the param in login.html
                return "login";
            }
        }

        PlayerAccount newPlayer = new PlayerAccount(username, password);
        // TODO: Add newPlayer to the database of players
        // TODO: Insert "success" into the param in login.html
        return "login";
    }
}
