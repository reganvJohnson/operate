package com.lorisoft.operate.controller;

import com.lorisoft.operate.Repository.ConsigneeRepository;
import com.lorisoft.operate.Repository.ZoneRepository;
import com.lorisoft.operate.entity.CarClass;
import com.lorisoft.operate.Repository.CarClassRepository;
import com.lorisoft.operate.entity.Module;
import com.lorisoft.operate.Repository.ModuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@Controller
public class ModuleController {

    private final ConsigneeRepository cRepo;
    private final ModuleRepository mRepo;
    private final ZoneRepository zRepo;
    private static final Logger log = LoggerFactory.getLogger(ModuleController.class);

   @Autowired
    public ModuleController(ConsigneeRepository cRepo, ModuleRepository mRepo, ZoneRepository zRepo) {

       this.cRepo = cRepo;
       this.mRepo = mRepo;
       this.zRepo = zRepo;
    }

    @ModelAttribute("allModules")
    public Iterable<Module> populateModules() {
        return mRepo.findAll();
    }


   // equipment registry page
   @RequestMapping(value = {"/module/list", "/module"})
   public String list_modules(Model model) {
       List<String> moduleIds = mRepo.findIds();

       HashMap<String, List> bob = new HashMap<>();
       for (String id: moduleIds) {
           bob.put(id, cRepo.findByModuleId(Integer.valueOf(id)));
       }
       model.addAttribute("consigneeStuff", bob);

       List<String> consigneeIds = cRepo.findIds();
       HashMap<String, List> sue = new HashMap<>();
       for (String id: consigneeIds) {
           sue.put(id, zRepo.findByConsigneeId(Integer.valueOf(id)));
       }
       System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX'");
    System.out.println(sue);
       System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX'");
       model.addAttribute("zoneStuff", sue);

       model.addAttribute("maxSize", "5");

       for (String moduleId: moduleIds) {

       }

      return "module/list";
   }

    // equipment registry page
    @RequestMapping(value = "/module/add")
    public String equipment(Model model) {
//       List<Equipment> allEquip = (List<Equipment>) model.getAttribute("allEquipment");
//       allEquip.add(new Equipment());
//       model.addAttribute("allEquipment", allEquip);
        model.addAttribute("module", new Module());
       return "module/add";
    }

    // process result of filled in add form
    @PostMapping("/module/save_add")
    public String newIssue(@Valid Module module, BindingResult result, Model model) {

        mRepo.save(module);
        model.addAttribute("allModules", mRepo.findAll());
        return "module/list";
    }

    // delete a module registry entry
    @GetMapping("/module/delete/{id}")
    public String deleteModule(@PathVariable("id") int id, Model model) {
        log.info("delete Module called");
        Module module = mRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Unknown Module id:" + id));
        mRepo.delete(module);
        model.addAttribute("allModules", mRepo.findAll());
        return "module/list";
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
    @GetMapping("/module/edit/{id}")
    public String updateModule(@PathVariable("id") int id, Model model) {
        log.info(String.format("update Equipment %d called", id));
        Module module = mRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Unknown Module:" + id));
        model.addAttribute("module", module);
        log.info("about to edit module" + module.toString());
        return "module/edit";
    }


    // process result of editing
    @PostMapping("module/update/{id}")
    public String equipmentUpdate(@PathVariable("id") int id, @Valid Module module, BindingResult result, Model model) {

        if (result.hasErrors()) {
            module.setId(id);
            return "module/edit";
        }
        //issue.setPublication(pRepo.findByTitle(issue.getPublication().getId()).get(0));
        log.info("Saving module: " + module.toString());
        mRepo.save(module);
        model.addAttribute("allModules", mRepo.findAll());
        return "module/list";

    }

}
