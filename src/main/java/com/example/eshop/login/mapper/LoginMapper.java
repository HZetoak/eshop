package com.example.eshop.login.mapper;

import com.example.eshop.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface LoginMapper {
    public User getUserByName(@Param("name") String name);
}
