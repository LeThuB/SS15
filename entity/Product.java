package SS15.entity;

import SS15.utils.GetInput;

import java.time.LocalDate;
import java.util.Scanner;

public class Product {
    private int productID;
    private String productName;
    private float productPrice;
    private String productTitle;
    private LocalDate productCreated;
    private String productCatalog;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productID, String productName, Float productPrice, String productTitle, LocalDate productCreated, String productCatalog, boolean productStatus) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
        this.productCreated = productCreated;
        this.productCatalog = productCatalog;
        this.productStatus = productStatus;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public LocalDate getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(LocalDate productCreated) {
        this.productCreated = productCreated;
    }

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, boolean update){
        this.productName = GetInput.getString(scanner,"Nhap ten san pham : ", 1, Integer.MAX_VALUE);
        this.productPrice= GetInput.getFloat(scanner,"Nhap gia san pham : ", 0.01f,Float.MAX_VALUE);
        this.productTitle = GetInput.getString(scanner,"Nhap tieu de san pham :  ", 1,Integer.MAX_VALUE);
        this.productCreated = GetInput.getDate(scanner,"NHap ngay theo dinh dang dd-MM-yyy : ");
        this.productCatalog = GetInput.getString(scanner,"Nhap ten danh muc san pham : ",1,Integer.MAX_VALUE);
        if (update) {
            this.productStatus = GetInput.getBoolean(scanner,"NHap trang thai(1-Active / 0-Deactive) : ");

        }else {
            this.productStatus = true;
        }
    }

    public String toString(){
        return "ID: " + productID + ", Name: " + productName +
                ", Price: " + productPrice + ", Title: " + productTitle +
                " , Created: " + productCreated +
                " , Catalog: "+ productCatalog + " , Status: " + productStatus;}
}
