package com.iweb.dao.impl;

import com.iweb.dao.ProductDAO;
import com.iweb.pojo.Product;
import com.iweb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DuanChangSuo
 * @date 2022/8/12 10:07
 * @description 类的描述和介绍
 **/
public class ProductDAOImpl implements ProductDAO {
    @Override
    public void add(Product product) {
        String sql = "insert into product(name,price,stock,cid) values(?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setInt(3, product.getStock());
            ps.setInt(4, product.getCid());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from product where id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {

        }
    }

    @Override
    public void update(Product product) {
        String sql = "update product set name=?,price=?,stock=? where id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setInt(3, product.getStock());
            ps.setInt(4, product.getId());
            ps.execute();
        } catch (SQLException e) {

        }
    }

    @Override
    public Product get(int id) {
        Product product = null;
        String sql = "select * from product where id=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
                product.setStock(rs.getInt("stock"));
                product.setCid(rs.getInt("cid"));
            }
        } catch (SQLException e) {

        }
        return product;
    }

    @Override
    public List<Product> listByLimit(int start, int count, int cid) {
        List<Product> products = new ArrayList<>();
        String sql = "";
        if (cid <= 0) {
            sql = "select * from product limit ?,?";
        } else {
            sql = "select * from product where cid=? limit ?,? ";
        }
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            if (cid <= 0) {
                ps.setInt(1, start);
                ps.setInt(2, count);
            } else {
                ps.setInt(1, cid);
                ps.setInt(2, start);
                ps.setInt(3, count);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
                product.setStock(rs.getInt("stock"));
                product.setCid(rs.getInt("cid"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> list() {
        return listByLimit(0, Integer.MAX_VALUE, 0);
    }

    @Override
    public List<Product> list(int cid) {
        return listByLimit(0, Integer.MAX_VALUE, cid);
    }
}
