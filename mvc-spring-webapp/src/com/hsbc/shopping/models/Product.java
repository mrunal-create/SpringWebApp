package com.hsbc.shopping.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
private long productId;
private String name;
@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
private LocalDate dop;
private long unitPrice;
public long getProductId() {
	return productId;
}
public void setProductId(long productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDop() {
	return dop;
}
public void setDop(LocalDate dop) {
	this.dop = dop;
}
public long getUnitPrice() {
	return unitPrice;
}
public void setUnitPrice(long unitPrice) {
	this.unitPrice = unitPrice;
}

}
