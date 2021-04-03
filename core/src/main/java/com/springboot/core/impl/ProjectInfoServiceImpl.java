package com.springboot.core.impl;

import com.springboot.core.ProjectInfoService;
import com.springboot.data.dao.ProjectInfoMapper;
import com.springboot.domain.entity.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuhui
 * @Date 2018/11/21
 * @Description
 */
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {
    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Override
    public int insertProject(ProjectInfo projectInfo) {
        return projectInfoMapper.insertProject(projectInfo);
    }
}
