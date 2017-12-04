package com.hin.dao;

import com.hin.controller.MySqlSession;
import com.hin.entity.AccountDO;
import org.apache.ibatis.session.SqlSession;

public class BatisAccountDao {
    public AccountDO getAccountById(String id) {
        SqlSession session = MySqlSession.newSqlSession();
        try {
            AccountDO accountDO = session.selectOne("getAccount", id);
            return accountDO;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        BatisAccountDao batisAccountDao = new BatisAccountDao();
        batisAccountDao.getAccountById("1");
    }
}
