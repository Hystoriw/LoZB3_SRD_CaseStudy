package org.perscholas.lozb3_srd.controllers;

import org.perscholas.lozb3_srd.dao.IPageModelRepo;
import org.perscholas.lozb3_srd.dao.IRuleModelRepo;
import org.perscholas.lozb3_srd.models.PageModel;
import org.perscholas.lozb3_srd.models.RuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {

    IPageModelRepo pageRepo;
    IRuleModelRepo ruleModelRepo;

    @Autowired
    public PageController(IPageModelRepo pageRepo, IRuleModelRepo ruleModelRepo) {
        this.pageRepo = pageRepo;
        this.ruleModelRepo = ruleModelRepo;
    }

//    @RequestMapping(value = "mainpage", method = RequestMethod.GET)
//    public ModelAndView pageElements() {
//        // TODO: search for the current page's index by name, find a pageModel object with the appropriate name, and insert page and rule elements appropriately
//        ModelAndView mav = new ModelAndView("mainpage");
//        mav.addObject("pageElements", pageRepo.findPageModelByPageName("Main Page"));
//        return mav;
//    }

    @GetMapping("/mainpage")
    public ModelAndView mainPage() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Main Page");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/coremechanics")
    public ModelAndView coreMechanics() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Core Mechanics");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/stats")
    public ModelAndView stats() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Stats");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/charactercreation")
    public ModelAndView characterCreation() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Character Creation");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/exploration")
    public ModelAndView exploration() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Exploration");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/combat")
    public ModelAndView combat() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Combat");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/magic")
    public ModelAndView magic() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Magic");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/situationalrules")
    public ModelAndView situationalRules() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Situational Rules");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }

    @GetMapping("/tables")
    public ModelAndView tables() {
        Optional<PageModel> currentPage = pageRepo.findPageModelByPageName("Tables");

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("currentPage", currentPage);

        return mav;
    }
}
