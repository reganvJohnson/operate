package com.lorisoft.operate.controller;

import com.lorisoft.operate.entity.CarClass;
import com.lorisoft.operate.entity.CarClassRepository;
import com.lorisoft.operate.entity.Equipment;
import com.lorisoft.operate.entity.EquipmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class EquipmentController {

    private final EquipmentRepository eRepo;
    private final CarClassRepository cRepo;
    private static final Logger log = LoggerFactory.getLogger(EquipmentController.class);

   @Autowired
    public EquipmentController(EquipmentRepository eRepo, CarClassRepository cRepo) {

       this.eRepo = eRepo;
       this.cRepo = cRepo;
    }

    @ModelAttribute("allEquipment")
    public Iterable<Equipment> populateEquipment() {
        return eRepo.findAll();
    }

    @ModelAttribute("allCarClasses")
    public Iterable<CarClass> populateCarClasses() {
        return cRepo.findAll();
    }


   // equipment registry page
   @RequestMapping(value = "/equipment/list")
   public String add_equipment(Model model) {
       for (Equipment equip: eRepo.findAll()) {
           System.out.println(equip);
       }
      return "equipment/list";
   }

    // equipment registry page
    @RequestMapping(value = "/equipment/add")
    public String equipment(Model model) {
//       List<Equipment> allEquip = (List<Equipment>) model.getAttribute("allEquipment");
//       allEquip.add(new Equipment());
//       model.addAttribute("allEquipment", allEquip);
        model.addAttribute("equipment", new Equipment());
       return "equipment/add";
    }

    // process result of filled in add form
    @PostMapping("/equipment/save_add")
    public String newIssue(@Valid Equipment equipment, BindingResult result, Model model) {
        log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXsaving new equipment");
        log.info(equipment.toString());

//        if (result.hasErrors()) {
//            return "equipment/add";
//        }
        log.info(equipment.toString());
        eRepo.save(equipment);
        model.addAttribute("allEquipment", eRepo.findAll());
        return "equipment/list";
    }

    // delete an equipment registry
    @GetMapping("/equipment/delete/{id}")
    public String deleteEquipment(@PathVariable("id") int id, Model model) {
        log.info("delete Equipment called");
        Equipment equipment = eRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unknown Equipment id:" + id));
        eRepo.delete(equipment);
        model.addAttribute("allEquipment", eRepo.findAll());
        return "equipment/list";
    }

//    // edit an equipment registry
//    @GetMapping("/equipment/edit/{id}")
//    public String editEquipment(@PathVariable("id") int id, Model model) {
///        log.info(String.format("edit Equipment %d called", id));
//        Equipment equipment = eRepo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Unknown Equipment id:" + id));
//        eRepo.delete(equipment);
//        model.addAttribute("allEquipment", eRepo.findAll());
//        return "equipment/edit";
//    }

    // update an equipment registry
    @GetMapping("/equipment/edit/{id}")
    public String updateEquipment(@PathVariable("id") int id, Model model) {
        log.info(String.format("update Equipment %d called", id));
        Equipment equipment = eRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Unknown Equipment:" + id));
        model.addAttribute("equipment", equipment);
        log.info("about to edit equipment" + equipment.toString());
        return "equipment/edit";
    }


    // process result of editing
    @PostMapping("equipment/update/{id}")
    public String equipmentUpdate(@PathVariable("id") int id, @Valid Equipment equipment, BindingResult result, Model model) {

        if (result.hasErrors()) {
            equipment.setId(id);
            return "equipment/edit";
        }
        //issue.setPublication(pRepo.findByTitle(issue.getPublication().getId()).get(0));
        log.info("Saving equipment: " + equipment.toString());
        eRepo.save(equipment);
        model.addAttribute("allEquipment", eRepo.findAll());
        return "equipment/list";

    }

}
