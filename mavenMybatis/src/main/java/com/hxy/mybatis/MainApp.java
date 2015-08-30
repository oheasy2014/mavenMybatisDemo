package com.hxy.mybatis;

import com.hxy.mybatis.mapper.UserMapper;
import com.hxy.mybatis.model.User;
import com.hxy.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by hxy-pc on 8/23/2015.
 */
public class MainApp {
    private static SqlSessionFactory factory = null;
    static {
        factory = MyBatisUtil.getFactory();
    }

    public static void main(String args[]) {
        MainApp mainApp = new MainApp();
//        User user = mainApp.getUserById(1);
//        System.out.println(user.getUserName());

//        //select
//        List<User> users = mainApp.getUserByName("dd");
//        for (User user : users) {
//            System.out.println(user.getUserAddress());
//        }

//        //insert
//        mainApp.insertUser(new User("dd",23,"nanjing"));

//        //delete
//        mainApp.deleteUser(new User("dd",32,"dd"));

//        //update
//        mainApp.updateUser(new User("xx",33,"DD"));

        //select if
        User user = mainApp.selectIf(new User());
        System.out.println(user.getUserAddress());
    }

    private User getUserById(int id) {
        SqlSession session = null;
        User user = null;
        try {
            session = factory.openSession();
            UserMapper userMapper = session.getMapper(UserMapper.class);
            user = userMapper.getUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return  user;
    }

    private List<User> getUserByName(String name) {
        SqlSession session = null;
        List<User> list = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            list = mapper.getUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return  list;

    }

    private void insertUser(User user) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void deleteUser(User user) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.deleteUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void updateUser(User user) {
        SqlSession session = null;

        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private User selectIf(User user) {
        SqlSession session = null;
        User userSelect = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            userSelect = mapper.selectIf(new User());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userSelect;
    }
}
