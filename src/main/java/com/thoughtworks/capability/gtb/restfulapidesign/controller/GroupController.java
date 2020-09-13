package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/groups")
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

    @PatchMapping()
    public void updateGroupName(@RequestParam Integer groupId,
                            @RequestParam String name){
        groupService.updateGroupName(groupId, name);
    }

}
