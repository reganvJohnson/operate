package com.lorisoft.operate.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


@Controller
public class OperateController {

private static final Logger log = LoggerFactory.getLogger(OperateController.class);

   @Autowired
    public OperateController() {
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

   // preferences page
   @RequestMapping(value = "/preferences")
   public String preferences(Model model) {
      return "preferences";
   }
}
