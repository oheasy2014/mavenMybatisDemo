package com.hxy.mybatis.util;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by hxy-pc on 8/23/2015.
 */
public class MyBatisUtil {
    private  static SqlSessionFactory factory = null;

    static {
        String resource = "mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static  SqlSessionFactory getFactory() {
        return factory;
    }
}


