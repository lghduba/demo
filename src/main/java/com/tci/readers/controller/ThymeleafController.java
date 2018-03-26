package com.tci.readers.controller;

import com.tci.readers.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    @Autowired
    private GroupMapper groupMapper;
    @RequestMapping("/display")
    public String display(Model model){
        model.addAttribute("groups", groupMapper.query());
        return "display";
    }
}
