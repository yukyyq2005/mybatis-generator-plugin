package com.kfit;


import java.util.Date;

import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ：youq
 * @date ：Created in 2019/2/18 21:03
 * @modified By：
 */
public class Product {

    public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Range(min=1,max=12,message="1dao12之间")
    private Long id;
    @JsonIgnore
    private  String productName;
    private  String note;
    private Date time;

	public Product(@Range(min = 1, max = 12, message = "1dao12之间") Long id, String productName, String note,
			Date time) {
		super();
		this.id = id;
		this.productName = productName;
		this.note = note;
		this.time = time;
	}

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
