package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public void groupStudent(){
        groupService.groupStudent();
    }

    @GetMapping
    public List<Group> findGroups(){
        return groupService.findGroups();
    }
    
}
