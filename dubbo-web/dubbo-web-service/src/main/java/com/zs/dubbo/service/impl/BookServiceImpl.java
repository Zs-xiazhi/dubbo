package com.zs.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zs.dubbo.mapper.BookMapper;
import com.zs.dubbo.model.Book;
import com.zs.dubbo.service.IBookService;
import com.zs.dubbo.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/6
 **/
@Service(timeout = 50000)
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Map<String, Object> selectAllBook() {
        List<Book> books = bookMapper.selectAllBook();
        return MapUtil.setResultMap(books);
    }

    @Override
    public Map<String, Object> insertBook(Book book) {
        Integer affectRows = bookMapper.insert(book) > 0 ? 1 : null;
        return MapUtil.setResultMap(affectRows);
    }

    @Override
    public Map<String, Object> selectBookById(Integer id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        return MapUtil.setResultMap(book);
    }

    @Override
    public Map<String, Object> updateBook(Book book) {
        Integer affectRows = bookMapper.updateByPrimaryKey(book) > 0 ? 1 : null;
        return MapUtil.setResultMap(affectRows);
    }

    @Override
    public Map<String, Object> deleteBookById(Integer id) {
        Integer affectRows = bookMapper.deleteByPrimaryKey(id)> 0 ? 1 : null;
        return MapUtil.setResultMap(affectRows);
    }
}
