package com.zhangguo.Spring61.test;

import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.zhangguo.Spring61.dao.BTDImpl;
import com.zhangguo.Spring61.entities.BookType;

public class TestMyBatisSpring02 {
    @Test
    public void test01() {
        //��ʼ������
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //���bean
        BTDImpl bTDImpl=ctx.getBean("bTDImpl",BTDImpl.class);
        //�������ݿ�
        List<BookType> booktypes=bTDImpl.getAllBookTypes();
        for (BookType bookType : booktypes) {
            System.out.println(bookType);
        }
        assertNotNull(booktypes);
    }
}