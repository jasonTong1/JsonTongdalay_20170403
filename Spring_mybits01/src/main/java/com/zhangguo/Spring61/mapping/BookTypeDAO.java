package com.zhangguo.Spring61.mapping;

import java.util.List;

import com.zhangguo.Spring61.entities.BookType;

/**
 * ͼ���������ݷ��ʽӿ�
 *
 */
public interface BookTypeDAO {
    /*
     * �������ͼ������
     */
    public List<BookType> getAllBookTypes();
}