package com.kfit;


import org.hibernate.validator.constraints.Range;

/**
 * @author ：youq
 * @date ：Created in 2019/2/18 21:03
 * @modified By：
 */
public class Product {

    @Range(min=1,max=12,message="1dao12之间")
    private Long id;
    private  String productName;
    private  String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
