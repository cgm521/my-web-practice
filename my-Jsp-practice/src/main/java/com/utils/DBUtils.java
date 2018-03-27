/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.utils;

import com.entity.item;
import com.entity.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cgm
 * @version $Id: DBUtils.java, v 0.1 2018-03-26 15:54 cgm Exp $$
 */
public class DBUtils {
    /**
     * 声明Connection对象
     */
    static Connection conn = null;

    /**
     * 驱动名称
     */
    static String driver = "com.mysql.jdbc.Driver";

    static {
        try {
            //加载驱动
            Class.forName(driver);
            //链接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf8",
                    "root", "123456");

            if (null != conn) {
                System.out.println("数据库链接成功");
            } else {
                System.out.println("连接失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<item> findItemList() {
        Statement statementt = null;
        ResultSet resultSet = null;
        ArrayList<item> items = new ArrayList<item>();
        try {
            statementt = conn.createStatement();
            String sql = "select * from item";
            resultSet = statementt.executeQuery(sql);

            while (resultSet.next()) {
                item item = new item();
                item.setId(resultSet.getInt("id"));
                item.setPrice(resultSet.getDouble("price"));
                item.setImg(resultSet.getString("img"));
                item.setSource(resultSet.getString("source"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != statementt) {
                try {
                    statementt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return items;
    }

    public static item findItemById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        item it = new item();
        try {
            preparedStatement = conn.prepareStatement("select * from item WHERE id=?");
            preparedStatement.setInt(1, id);


            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                it.setId(resultSet.getInt("id"));
                it.setPrice(resultSet.getDouble("price"));
                it.setImg(resultSet.getString("img"));
                it.setSource(resultSet.getString("source"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return it;
    }

    public static user findUserByName(String name) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        user user = new user();
        try {
            preparedStatement = conn.prepareStatement("select * from user WHERE name=?");
            preparedStatement.setString(1, name);


            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setName(resultSet.getString("name"));
                user.setBirth(resultSet.getString("birth"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

}
