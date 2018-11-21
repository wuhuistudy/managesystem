package com.springboot.api.controller;

import com.springboot.core.ProjectInfoService;
import com.springboot.domain.entity.ProjectInfo;
import com.springboot.domain.entity.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wuhui
 * @Date 2018/11/21
 * @Description
 */
@RestController
public class ProjectInfoController
{
    @Autowired
    private ProjectInfoService projectInfoService;
    @GetMapping("/insert")
    public Return insertProject()
    {
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setAccessAddress("1111");
        projectInfo.setAcceptanceTime(new Date(System.currentTimeMillis()));
        projectInfo.setProjectCode("99999999999999");
        projectInfo.setBudgetSource(989922222222d);
        int data =projectInfoService.insertProject(projectInfo);
        return new Return("0000",null,data);
    }
}
