/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

/**
 *
 * @author User
 */
public class Product {
    private String prodID;
    private String prodName;
    private String noProd;
    private String issueDate;
    private String supplier;
    private String seller;

    public Product(String prodID, String prodName, String noProd, String issueDate, String supplier, String seller) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.noProd = noProd;
        this.issueDate = issueDate;
        this.supplier = supplier;
        this.seller = seller;
    }

    public Product(String prodID, String prodName, String noProd, String issueDate, String seller) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.noProd = noProd;
        this.issueDate = issueDate;
        this.seller = seller;
    }
    
    
    
    
    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getNoProd() {
        return noProd;
    }

    public void setNoProd(String noProd) {
        this.noProd = noProd;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String productDetails() {
        return prodID + "," + prodName + "," + noProd + "," + issueDate + "," + supplier + "," + seller;
    }

    

    
    
}
