package com.springboot.core;

import com.springboot.domain.entity.ProjectInfo;
import org.springframework.stereotype.Service;


@Service
public interface ProjectInfoService {
    int insertProject(ProjectInfo projectInfo);
}
