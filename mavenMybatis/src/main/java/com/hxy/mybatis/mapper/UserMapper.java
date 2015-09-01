package com.hxy.mybatis.mapper;

import com.hxy.mybatis.model.User;

import java.util.List;
import java.util.Map;

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

    User selectChoose(User user);

    User selectWhere(User user);

    User selectTrim(User user);

    void updateSet(User user);

    void updateList(List<User> users);

    void updateArray(int id[]);

    void updateMap(Map map);
}
