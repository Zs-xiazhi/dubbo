package com.zs.dubbo.service;

import com.zs.dubbo.model.Book;

import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/6
 **/
public interface IBookService {

    /**
     * 查询所有图书
     *
     * @return
     */
    Map<String, Object> selectAllBook();

    /**
     * 添加新的图书
     *
     * @param book
     * @return
     */
    Map<String, Object> insertBook(Book book);

    /**
     * 根据id查询图书信息
     *
     * @param id
     * @return
     */
    Map<String, Object> selectBookById(Integer id);

    /**
     * 修改图书信息
     *
     * @param book
     * @return
     */
    Map<String, Object> updateBook(Book book);

    /**
     * 根据id删除图书
     * @param id
     * @return
     */
    Map<String, Object> deleteBookById(Integer id);


}
