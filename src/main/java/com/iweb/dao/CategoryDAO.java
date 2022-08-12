package com.iweb.dao;

import com.iweb.pojo.Category;

import java.util.List;

/**
 * @author syl
 * @date 2022/8/11 15:42
 * @description 类的描述和介绍
 */
public interface CategoryDAO {

    /**要添加的分类对象引用
     * @param category
     */
    void add(Category category);

    /**根据id删除分类
     * @param id
     */
    void delete(int id);

    /**修改分类数据
     * @param category
     */
    void update(Category category);

    /**根据id获取单个分类对象
     * @param id
     * @return
     */
    Category get(int id);

    /**对分类信息进行分页查询
     * @param start 起始语句截至行数
     * @param count 截取行数
     * @return
     */
    List<Category> listByLimit(int start,int count);

    /**默认查询所有分类
     * @return 查询到的所有分类集合
     */
    List<Category> list();
}
