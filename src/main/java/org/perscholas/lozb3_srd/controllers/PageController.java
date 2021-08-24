package org.perscholas.lozb3_srd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.lozb3_srd.dao.IPageModelRepo;
import org.perscholas.lozb3_srd.dao.IRuleModelRepo;
import org.perscholas.lozb3_srd.models.PageModel;
import org.perscholas.lozb3_srd.models.RuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@SessionAttributes("currentPage")
public class PageController {


    IPageModelRepo pageRepo;
    IRuleModelRepo ruleModelRepo;

    @Autowired
    public PageController(IPageModelRepo pageRepo, IRuleModelRepo ruleModelRepo) {
        this.pageRepo = pageRepo;
        this.ruleModelRepo = ruleModelRepo;
    }

    @ModelAttribute("currentPage")
    public PageModel initCurrentPage() {
        return new PageModel();
    }

    @GetMapping({"/rulebook/{link}", "/rulebook"})
    public String generatePage(@PathVariable(value = "link", required = false) String link, RedirectAttributes model) {
        log.warn("The link is now: " + link);
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName(link);

//        model.addAttribute("currentPage", currentPage.get());
        model.addFlashAttribute("currentPage", currentPage);
        return "redirect:/index";
    }
}
