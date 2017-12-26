package com.zhangguo.Spring61.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zhangguo.Spring61.entities.BookType;
import com.zhangguo.Spring61.mapping.BookTypeDAO;

/**
 * ʵ��ͼ���������ݷ���
 *
 */
public class BookTypeDAOImpl implements BookTypeDAO {

    public List<BookType> getAllBookTypes() {
        //��ûỰ����
        SqlSession session=MyBatisUtil.getSession();
        try {
            //ͨ��MyBatisʵ�ֽӿ�BookTypeDAO������ʵ��
            BookTypeDAO bookTypeDAO=session.getMapper(BookTypeDAO.class);
            return bookTypeDAO.getAllBookTypes();
        } finally {
            session.close();
        }
    }

}