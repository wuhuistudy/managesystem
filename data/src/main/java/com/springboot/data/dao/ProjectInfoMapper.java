package com.springboot.data.dao;

import com.springboot.domain.entity.ProjectInfo;
import org.springframework.stereotype.Repository;

/**
 * @author wuhui
 * @Date 2018/11/21
 * @Description
 */
@Repository
public interface ProjectInfoMapper
{
    // 插入
    int insertProject(ProjectInfo projectInfo);
}
