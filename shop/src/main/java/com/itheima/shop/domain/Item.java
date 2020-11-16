package com.itheima.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/*****
 * @Author: http://www.itheima.com
 * @Description: com.itheima.shop.domain.Item
 ****/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item implements Serializable {

    private String id;
    private String name;
    private String description;
    private String images;
    private String video;
    private Integer count;
    private Integer price;
}
