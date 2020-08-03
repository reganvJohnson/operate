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
      return "index";
   }
}
