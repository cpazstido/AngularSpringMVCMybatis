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

    public AccountDO getAccountByIdInterface(String id){
        SqlSession session = MySqlSession.newSqlSession();
        IAccountMapper accountMapper = session.getMapper(IAccountMapper.class);
        AccountDO accountDO = accountMapper.getAccount(id);
        return accountDO;
    }

    public static void main(String[] args) {
        BatisAccountDao batisAccountDao = new BatisAccountDao();
        batisAccountDao.getAccountById("1");
//        batisAccountDao.getAccountByIdInterface("1");
    }
}
