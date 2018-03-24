/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.po;

/**
 * @author cgm
 * @version $Id: userDao.java, v 0.1 2018-03-24 15:48 cgm Exp $$
 */
public class userDao {
    public boolean doLogin(user user) {
        if ("admin".equals(user.getPassword())&& "admin".equals(user.getUsername())) {
            return true;
        }
        return false;
    }
}
