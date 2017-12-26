package com.zhangguo.Spring61.test;

import static org.junit.Assert.assertNotNull;

//import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.zhangguo.Spring61.dao.BookTypeDAOImpl;
import com.zhangguo.Spring61.entities.BookType;
import com.zhangguo.Spring61.mapping.BookTypeDAO;

public class TestBookTypeDAOImpl {

    static BookTypeDAO bookTypeDao;
    @BeforeClass
    public static void beforeClass()
    {
    	bookTypeDao=new BookTypeDAOImpl();
    }
    
    @Test
    public void testGetAllBookTypes() {
        List<BookType> booktypes=bookTypeDao.getAllBookTypes();
        for (BookType bookType : booktypes) {
            System.out.println(bookType);
        }
        assertNotNull(booktypes);
    }

}