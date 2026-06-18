package com.stockEvaluator.Stock.Re_order.Evaluator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
    @Id
    private int id;
    private String productname;
    private int quantity;
    private int reorderlevel;
    private String status;
    public Stock() {
    }
    public Stock(int id, String productname, int quantity, int reorderlevel,String status) {
        this.id = id;
        this.productname = productname;
        this.quantity = quantity;
        this.reorderlevel = reorderlevel;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProductname() {
        return productname;
    }
    public void setProductname(String productname) {
        this.productname = productname;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getReorderlevel() {
        return reorderlevel;
    }
    public void setReorderlevel(int reorderlevel) {
        this.reorderlevel = reorderlevel;
    }
    public String getStatus() {
    return status;
}
    public void setStatus(String status) {
        this.status = status;
    }
}