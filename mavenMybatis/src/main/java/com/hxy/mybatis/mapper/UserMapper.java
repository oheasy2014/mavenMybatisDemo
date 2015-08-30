package com.hxy.mybatis.mapper;

import com.hxy.mybatis.model.User;

import java.util.List;

/**
 * Created by hxy-pc on 8/23/2015.
 */
public interface UserMapper {
    public User getUserById(int id);

    public List<User> getUserByName(String userName);

    public void insertUser(User user);

    public void deleteUser(User user);

    void updateUser(User user);

    User selectIf(User user);
}
