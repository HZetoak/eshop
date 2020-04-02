package com.example.eshop.login.service.impl;

import com.example.eshop.login.entity.Permissions;
import com.example.eshop.login.entity.Role;
import com.example.eshop.login.entity.User;
import com.example.eshop.login.mapper.LoginMapper;
import com.example.eshop.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;
    @Override
    public User getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return loginMapper.getUserByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permissions permissions1 = new Permissions();
        permissions1.setId("1");
        permissions1.setPermissionsName("query");
        Permissions permissions2 = new Permissions();
        permissions1.setId("2");
        permissions1.setPermissionsName("add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role();
        role.setId("1");
        role.setRoleName("admin");
        role.setPermissions(permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User();
        user.setId("1");
        user.setUserName("wsl");
        user.setPassword("123456");
        user.setRoles(roleSet);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Permissions permissions3 = new Permissions();
        permissions3.setId("3");
        permissions3 .setPermissionsName("query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role();
        role.setId("2");
        role.setRoleName("user");
        role.setPermissions(permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User();
        user.setId("2");
        user.setUserName("zhangsan");
        user.setPassword("123456");
        user.setRoles(roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }
}