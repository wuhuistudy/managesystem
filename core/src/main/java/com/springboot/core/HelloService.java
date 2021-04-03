package com.springboot.core;

import com.springboot.domain.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HelloService {
    List<UserRole> sayHello();
}
