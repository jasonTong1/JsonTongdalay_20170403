package com.zhangguo.Spring61.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhangguo.Spring61.entities.BookType;
import com.zhangguo.Spring61.mapping.BookTypeDAO;

public class TestMyBatisSpring01 {
    @Test
    public void test01() {
        //��ʼ������
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //���bean
        BookTypeDAO bookTypeDao=ctx.getBean("bookTypeDao",BookTypeDAO.class);
        //�������ݿ�
        List<BookType> booktypes=bookTypeDao.getAllBookTypes();
        for (BookType bookType : booktypes) {
            System.out.println(bookType);
        }
        assertNotNull(booktypes);
    }
}