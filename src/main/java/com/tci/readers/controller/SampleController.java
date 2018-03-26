package com.tci.readers.controller;

import com.tci.readers.mapper.GroupMapper;
import com.tci.readers.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SampleController {
    @RequestMapping("/hello")
    String home(){
        return "Hello world";
    }

    @Autowired
    private GroupMapper groupMapper;

    @RequestMapping("/queryAll")
    public List<Group> queryAll(){
        List<Group> groups = groupMapper.query();
        return groups;
    }
    @RequestMapping("/queryById")
    public Group queryById(String id){
        Group group = groupMapper.queryById(id);
        return group;
    }
}
