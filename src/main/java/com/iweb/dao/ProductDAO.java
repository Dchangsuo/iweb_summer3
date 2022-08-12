package com.iweb.dao;

import com.iweb.pojo.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author DuanChangSuo
 * @date 2022/8/12 9:42
 * @description 类的描述和介绍
 **/
public interface ProductDAO {
    void add(Product product);
    void delete(int id);
    void update(Product product);
    Product get(int cid);
    List<Product> listByLimit(int start, int count,int cid);
    List<Product> list(int cid);
    List<Product> list();
}
