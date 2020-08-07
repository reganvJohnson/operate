package com.lorisoft.operate.controller;

import com.lorisoft.operate.entity.Equipment;
import com.lorisoft.operate.entity.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.validation.Valid;
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
   public String add_equipment(Model model) {

      return "equipment";
   }



    // equipment registry page
    @RequestMapping(value = "/equipment/add")
    public String equipment(Model model) {
//       List<Equipment> allEquip = (List<Equipment>) model.getAttribute("allEquipment");
//       allEquip.add(new Equipment());
//       model.addAttribute("allEquipment", allEquip);
       return "equipment/add";
    }

    // process result of filled in add form
    @PostMapping("/equipment/save_add")
    public String newIssue(@Valid Equipment equipment, BindingResult result, Model model) {
        log.info("saving new equipment");
        log.info(equipment.toString());

        if (result.hasErrors()) {
            return "equipment/add";
        }
        equipment.setId(34);
        log.info(equipment.toString());
        eRepo.save(equipment);
        model.addAttribute("allEquipment", eRepo.findAll());
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
