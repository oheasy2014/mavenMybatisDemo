package com.hxy.mybatis;

import com.hxy.mybatis.mapper.UserMapper;
import com.hxy.mybatis.model.User;
import com.hxy.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//
//        //insert
//        mainApp.insertUser(new User("dd",23,"nanjing"));

//        //delete
//        mainApp.deleteUser(new User("dd",32,"dd"));

//        //update
//        mainApp.updateUser(new User("xx",33,"DD"));

//        //select if
//        User user = mainApp.selectIf(new User());
//        System.out.println(user.getUserAddress());

//        //select choose
//        User user = mainApp.selectChoose(new User(null, 0, "nanjing"));
//        System.out.println(user.getUserName());

//        //select where
//        User user = mainApp.selectWhere(new User("dd", 33, "n"));
//        System.out.println(user.getUserAddress());

//        //select trim
//        User user = mainApp.selectTrim(new User("xx", 22, "E"));
//        System.out.println(user.getUserAddress());

//        //update set
//        mainApp.updateSet(new User("xx",100,"dd"));

//        //update list
//        List<User> users = new ArrayList<User>();
//        users.add(new User("dd", 34, "Dd"));
//        users.add(new User("xx", 34, "xx"));
//        mainApp.updateList(users);

//        //update array
//        int[] ids = {1, 2, 3, 4};
//        mainApp.updateArray(ids);

        //update map
        Map<String, Object> map = new HashMap<String, Object>();
        int[] ids = {1, 2};
        map.put("ids", ids);
        map.put("name", "hxy");
        mainApp.updateMap(map);
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

    private User selectChoose(User user) {
        SqlSession session = null;
        User userChoose = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            userChoose = mapper.selectChoose(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userChoose;
    }

    private User selectWhere(User user) {
        SqlSession session = null;
        User userWhere = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            userWhere = mapper.selectWhere(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userWhere;
    }

    private User selectTrim(User user) {
        SqlSession session = null;
        User userTrim = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            userTrim = mapper.selectTrim(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return userTrim;
    }

    private void updateSet(User user) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateSet(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    private void updateList(List<User> users) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateList(users);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void updateArray(int ids[]) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateArray(ids);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private void updateMap(Map map) {
        SqlSession session = null;
        try {
            session = factory.openSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.updateMap(map);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
