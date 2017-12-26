package com.zhangguo.Spring61.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import com.zhangguo.Spring61.entities.BookType;
import com.zhangguo.Spring61.mapping.BookTypeDAO;
public class BTDImpl implements BookTypeDAO {
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

//    @Override
    public List<BookType> getAllBookTypes() {
        return sqlSession.selectList("com.zhangguo.Spring61.mapping.BookTypeDAO.getAllBookTypes");
    }

}