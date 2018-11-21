package com.springboot.data.dao;

import com.springboot.domain.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wuhui
 * @Date 2018/11/20
 * @Description
 */
@Repository
public interface UserRoleMapper
{
    /**
     * 查询所有的用户角色
     * @return
     */
    List<UserRole> all();
}
