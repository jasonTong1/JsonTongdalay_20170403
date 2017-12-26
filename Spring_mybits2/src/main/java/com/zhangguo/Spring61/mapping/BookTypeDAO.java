package com.zhangguo.Spring61.mapping;

import java.util.List;

import com.zhangguo.Spring61.entities.BookType;

/**
 * 图书类型数据访问接口
 *
 */
public interface BookTypeDAO {
    /*
     * 获得所有图书类型
     */
    public List<BookType> getAllBookTypes();
}