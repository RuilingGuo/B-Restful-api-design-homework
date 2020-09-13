package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.GroupNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService {

    private static Integer BASE_TEAM_NUM = 6;
    private static Integer studentTeamIncId = 1;

    private List<Group> groupList;

    private StudentService studentService;

    public GroupService(StudentService studentService) {
        this.studentService = studentService;
        initGroupList();
    }

    private void initGroupList() {
        this.groupList =  new ArrayList<>();
        for (int i = 0; i < BASE_TEAM_NUM; i++) {
            groupList.add(new Group(studentTeamIncId++,i+1));
        }
    }

    public void groupStudent() {
        int teamIndex = 0 ;
        int randomStudentIndex;
        Random random = new Random();
        List<Student> studentList =  studentService.getStudentList();
        initGroupList();
        List<Group> groupList = this.groupList;
        int iterationNum = studentList.size();
        for(int i = 0 ; i< iterationNum ;i++){
            randomStudentIndex = random.nextInt(studentList.size());
            groupList.get(teamIndex).addStudent(studentList.get(randomStudentIndex));
            studentList.remove(randomStudentIndex);
            teamIndex++;
            if(teamIndex==BASE_TEAM_NUM){
                teamIndex = 0;
            }
        }
        groupList.forEach(team -> team.getStudentList().sort(Comparator.comparingInt(Student::getId)));
        this.groupList= groupList;
    }

    public List<Group> findGroups(){
        return this.groupList;
    }

    public void updateGroupName(Integer groupId,String updateName) {
        Optional<Group> groupOptional = groupList.stream().filter(e -> e.getId().equals(groupId)).findFirst();
        if(!groupOptional.isPresent()){
            throw new GroupNotFoundException("该小组不存在");
        }
        Group group =  groupOptional.get();
        group.setName(updateName);
    }
}
