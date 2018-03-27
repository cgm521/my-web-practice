/**
 * Choicesoft.com.cn Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.dao;

import com.entity.item;
import com.utils.DBUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author cgm
 * @version $Id: itemDao.java, v 0.1 2018-03-26 16:45 cgm Exp $$
 */
public class itemDao {

    public List<item> findListItem() throws SQLException {
        return DBUtils.findItemList();
    }

    public item findItemById(int id) throws SQLException {
        return DBUtils.findItemById(id);
    }

}
