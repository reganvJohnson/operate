package com.lorisoft.operate.controller;

import com.lorisoft.operate.Repository.EquipmentRepository;
import com.lorisoft.operate.Repository.ModuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

@Controller
public class OperateController {

    private final EquipmentRepository eRepo;
    private final ModuleRepository mRepo;

    private static final Logger log = LoggerFactory.getLogger(OperateController.class);


    @Autowired
    public OperateController(EquipmentRepository eRepo, ModuleRepository mRepo) {
        this.eRepo = eRepo;
        this.mRepo = mRepo;
    }

    // index page
   @RequestMapping(value = "/")
   public String index(Model model) {
    int towns = 6;
    int moduleCount = mRepo.moduleCount();
    int equipmmentCount = eRepo.equipmentCount();
    //int equipmmentCount = 5;
    int consignees = 3;
    int dropZones = 10;
    int carRequests = 12;
    int trains = 14;

     model.addAttribute("moduleCount", moduleCount);
     model.addAttribute("equipmentCount", equipmmentCount);
     model.addAttribute("consigneeCount", consignees);
     model.addAttribute("dropZoneCount", dropZones );
     model.addAttribute("carRequestCount", carRequests);
     model.addAttribute("trainCount", trains);

      return "index";
   }


   // trains page
   @RequestMapping(value = "/trains")
   public String trains(Model model) {
      return "trains";
   }   


   // trainLists page
   @RequestMapping(value = "/trainLists")
   public String trainLists(Model model) {
      return "trainLists";
   }   


   // preferences page
   @RequestMapping(value = "/preferences")
   public String preferences(Model model) {
      return "preferences";
   }
}
