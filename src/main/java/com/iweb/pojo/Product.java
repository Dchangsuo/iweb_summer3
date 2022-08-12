package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DuanChangSuo
 * @date 2022/8/12 9:42
 * @description 类的描述和介绍
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private float price;
    private int stock;
    private int cid;
}
