package com.lorisoft.operate.controller;

import com.lorisoft.operate.entity.Equipment;
import com.lorisoft.operate.entity.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class OperateController {

    private final EquipmentRepository eRepo;
    private static final Logger log = LoggerFactory.getLogger(OperateController.class);

   @Autowired
    public OperateController(EquipmentRepository eRepo) {
       this.eRepo = eRepo;
    }

    @ModelAttribute("allEquipment")
    public Iterable<Equipment> populatePublications() {
        return eRepo.findAll();
    }

   // index page
   @RequestMapping(value = "/index")
   public String index(Model model) {
    int towns = 6;
    int rollingStock = 23;
    int consignees = 3;
    int dropZones = 10;
    int carRequests = 12;
    int trains = 14;

     model.addAttribute("townCount", towns);
     model.addAttribute("rollingStockCount", rollingStock);
     model.addAttribute("consigneeCount", consignees);
     model.addAttribute("dropZoneCount", dropZones );
     model.addAttribute("carRequestCount", carRequests);
     model.addAttribute("trainCount", trains);

      return "index";
   }

   // equipment registry page
   @RequestMapping(value = "/equipment")
   public String equipment(Model model) {

      return "equipment";
   }

   // modules page
   @RequestMapping(value = "/modules")
   public String modules(Model model) {
      return "modules";
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
