package com.shujia.bean;

public class ItemInfo {
    private String price;
    private String StockStateName;
    private String vender;
    private String website;
    private String url;
    private String productColor;
    private String productSize;
    private String name;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStockStateName() {
        return StockStateName;
    }

    public void setStockStateName(String stockStateName) {
        StockStateName = stockStateName;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "price='" + price + '\'' +
                ", StockStateName='" + StockStateName + '\'' +
                ", vender='" + vender + '\'' +
                ", website='" + website + '\'' +
                ", url='" + url + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productSize='" + productSize + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public ItemInfo() {
    }

    public ItemInfo(String price, String stockStateName, String vender, String website, String url, String productColor, String productSize, String name) {
        this.price = price;
        StockStateName = stockStateName;
        this.vender = vender;
        this.website = website;
        this.url = url;
        this.productColor = productColor;
        this.productSize = productSize;
        this.name = name;
    }
}

