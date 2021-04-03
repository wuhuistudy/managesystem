package com.springboot.core.impl;

import com.springboot.core.HelloService;
import com.springboot.data.dao.UserRoleMapper;
import com.springboot.domain.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuhui
 * @version C10 2018/11/19
 * @since SDP V300R003C10
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> sayHello() {
        List<UserRole> data = userRoleMapper.all();
        return data;
    }
}
