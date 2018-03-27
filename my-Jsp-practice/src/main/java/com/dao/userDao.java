/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.dao;

import com.entity.user;
import com.utils.DBUtils;

import java.sql.SQLException;

/**
 * @author cgm
 * @version $Id: userDao.java, v 0.1 2018-03-26 19:24 cgm Exp $$
 */
public class userDao {

    public user getUserByName(String name) throws SQLException {
        return DBUtils.findUserByName(name);
    }

    public static void main(String[] args) {
        String newIds = "q,w,r,";
        System.out.println(newIds.substring(0, newIds.lastIndexOf(",")));
    }
}
