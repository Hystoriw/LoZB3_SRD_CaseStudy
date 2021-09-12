package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @PostMapping("/login/createprofile")
    public String createProfile(@RequestParam(name = "newUsername") String username,
                                @RequestParam(name = "newPassword") String password,
                                @RequestParam(name = "newVerifiedPassword") String verifiedPassword,
                                Model model) {
        if (!password.equals(verifiedPassword)) {
            log.warn("createProfile(), new passwords '"+password+"' and '"+verifiedPassword+"' do not match!");
            return "redirect:/login?badpassword=true";
        }

        log.warn("Finding if a player with the username of '" + username + "' already exists...");
        for (PlayerAccount player: playerAccountRepo.findAll()) {
            if (player.getUsername().equals(username)) {
                log.warn("This user already exists!");
                return "redirect:/login?nametaken=true";
            }
        }

        PlayerAccount newPlayer = new PlayerAccount(username, new BCryptPasswordEncoder(4).encode(password));
        playerAccountRepo.save(newPlayer);
        return "redirect:/login?success=true";
    }
}
